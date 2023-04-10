package robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement {
	
	private int hardness;
	private double price;

	public BaseSupplement(int hardness, double price) {
		this.hardness = hardness;
		this.price = price;
	}

	@Override
	public int getHardness() {
		// TODO Auto-generated method stub
		return this.hardness;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

}
