package magicGame.repositories;

import java.util.ArrayList;
import java.util.Collection;

import magicGame.models.magicians.Magician;
import magicGame.repositories.interfaces.MagicianRepository;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

	private Collection<Magician> data;
	public MagicianRepositoryImpl() {
		data = new ArrayList<>();
	}

	@Override
	public Collection<Magician> getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public void addMagician(Magician model) {
		if(model == null) throw new NullPointerException("Cannot add null in Magician Repository.");
		data.add(model);
	}

	@Override
	public boolean removeMagician(Magician model) {
		// TODO Auto-generated method stub
		return data.remove(model);
	}

	@Override
	public Magician findByUsername(String name) {
		return data.stream().filter(magician -> magician.getUsername().equals(name)).findFirst().orElse(null);
	}

}
