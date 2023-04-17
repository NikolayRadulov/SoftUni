package magicGame.repositories;

import java.util.ArrayList;
import java.util.Collection;

import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

	private Collection<Magic> data;
	
	public MagicRepositoryImpl() {
		data = new ArrayList<>();
	}

	@Override
	public Collection<Magic> getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public void addMagic(Magic model) {
		if(model == null) throw new NullPointerException("Cannot add null in Magic Repository.");
		data.add(model);
	}

	@Override
	public boolean removeMagic(Magic model) {
		return data.remove(model);
	}

	@Override
	public Magic findByName(String name) {
		return data.stream().filter(magic -> magic.getName().equals(name)).findFirst().orElse(null);
	}

}
