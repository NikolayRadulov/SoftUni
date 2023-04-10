package robotService.entities.robot;

public class FemaleRobot extends BaseRobot {

	
	private static final int INITIAL_KILOGRAMS = 7;
	
	//Can only live in SecondaryService!
	
	public FemaleRobot(String name, String kind, double price) {
		super(name, kind, INITIAL_KILOGRAMS, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eating() {
		setKilograms(getKilograms()+1);

	}

}
