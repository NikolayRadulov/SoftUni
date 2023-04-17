package magicGame.models.magics;

public class BlackMagic extends MagicImpl {

	public BlackMagic(String name, int bulletsCount) {
		super(name, bulletsCount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int fire() {
		if(this.getBulletsCount() < 10) return 0;
		this.setBulletCount(getBulletsCount()-10);	
		return 10;
	}

}
