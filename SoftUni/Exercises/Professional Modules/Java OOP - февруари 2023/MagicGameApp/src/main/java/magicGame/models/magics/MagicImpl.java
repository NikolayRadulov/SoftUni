package magicGame.models.magics;

public abstract class MagicImpl implements Magic {

	private String name;
	private int bulletsCount;
	
	public MagicImpl(String name, int bulletsCount) {
		this.setName(name);
		this.setBulletCount(bulletsCount);
	}

	public void setBulletCount(int bulletsCount) {
		if(bulletsCount < 0) throw new IllegalArgumentException("Bullets cannot be below 0.");
		this.bulletsCount = bulletsCount;
	}

	public void setName(String name) {
		if(name == null || name.trim().isEmpty()) throw new NullPointerException("Magic cannot be null or empty.");
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getBulletsCount() {
		return this.bulletsCount;
	}
}
