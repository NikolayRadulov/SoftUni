package magicGame.models.region;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

public class RegionImpl implements Region {

	public RegionImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String start(Collection<Magician> magicians) {
		List<Magician> wizards = magicians.stream().filter(magician -> magician instanceof Wizard).collect(Collectors.toList());
		List<Magician> blackWidows = magicians.stream().filter(magician -> magician instanceof BlackWidow).collect(Collectors.toList());
		String status = null;
		boolean turn = false;
		while (true) {
			if(!turn) {
				for (int i = 0; i < wizards.size(); i++) {
					for (Magician magician : blackWidows) {
						int fire = wizards.get(i).getMagic().fire();
						if(fire == 0) continue;
						magician.takeDamage(fire);
					}
				}
			}
			else {
				for (int i = 0; i < blackWidows.size(); i++) {		
					for (Magician magician : wizards) {
						int fire = blackWidows.get(i).getMagic().fire();
						if(fire == 0) continue;
						magician.takeDamage(fire);
					}							
				}
			}
			if(isTeamDead(wizards)) {
				status = "Black widows win!";
				break;
			}
			else if(isTeamDead(blackWidows)) {
				status = "Wizards win!";
				break;
			}
			turn = !turn;
		}
		return status;
	}

	private boolean isTeamDead(Collection<Magician> magicians) {
		for (Magician magician : magicians) {
			if(magician.isAlive()) return false;
		}
		return true;
	}
}
