package magicGame.core;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicianRepository;

public class ControllerImpl implements Controller {

	private MagicRepository<Magic> magics;
	private MagicianRepository<Magician> magicians;
	private Region region;
	
	public ControllerImpl() {
		this.magics = new MagicRepositoryImpl();
		this.magicians = new MagicianRepositoryImpl();
		this.region = new RegionImpl();
	}

	@Override
	public String addMagic(String type, String name, int bulletsCount) {
		Magic magic;
		switch (type) {
			case "RedMagic": magic = new RedMagic(name, bulletsCount);
			break;
			case "BlackMagic": magic = new BlackMagic(name, bulletsCount);
			break;
			default: throw new IllegalArgumentException("Invalid magic type!");
		}
		magics.addMagic(magic);
		return String.format("Successfully added magic %s.", name);
	}

	@Override
	public String addMagician(String type, String username, int health, int protection, String magicName) {
		Magic magic = magics.findByName(magicName);
		if(magic == null) throw new NullPointerException("Magic cannot be found!");
		Magician magician;
		switch (type) {
			case "Wizard": magician = new Wizard(username, health, protection, magic);
			break;
			case "BlackWidow": magician = new BlackWidow(username, health, protection, magic);
			break;
			default: throw new IllegalArgumentException("Invalid magician type!");
		}
		magicians.addMagician(magician);
		return String.format("Successfully added magician %s.", username);
	}

	@Override
	public String startGame() {
		// TODO Auto-generated method stub
		return region.start(magicians.getData());
	}

	@Override
	public String report() {
		List<Magician> magiciansCollection = magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername).thenComparing(magician -> magician.getClass().getSimpleName())).collect(Collectors.toList());			
		StringBuilder sBuilder = new StringBuilder();
		for(Magician magician : magiciansCollection) {
			sBuilder.append(magician.toString()).append(System.lineSeparator()); //Trimming might be needed here!
		}
		return sBuilder.toString().trim();
	}

}
