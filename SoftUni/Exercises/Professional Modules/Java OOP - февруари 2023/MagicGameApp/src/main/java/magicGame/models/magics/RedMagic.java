package magicGame.models.magics;

public class RedMagic extends MagicImpl {

	public RedMagic(String name, int bulletsCount) {
		super(name, bulletsCount);
	}

	@Override
	public int fire() {
		if(this.getBulletsCount() < 1) return 0;
		this.setBulletCount(getBulletsCount()-1);	
		return 1;
	}

}
