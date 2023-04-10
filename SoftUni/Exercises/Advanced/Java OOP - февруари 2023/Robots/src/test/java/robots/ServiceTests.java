package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

	
	@Test 
	public void testCreation() {
		Service service = new Service("Ser1", 10);
		Assert.assertTrue(service.getName().equals("Ser1") && service.getCapacity() == 10);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreationNullOrBlankName() {
		new Service(null, 0);
		new Service("   ", 0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCreationNegativeCapacity() {
		new Service("Serv1", -10);
	}
	@Test 
	public void testAddRobot() {
		Service service = new Service("S1", 2);
		service.add(new Robot("R1"));
		Assert.assertEquals(1, service.getCount());
	}
	@Test(expected = IllegalArgumentException.class) 
	public void testAddRobotInFullService() {
		Service service = new Service("S1", 0);
		service.add(new Robot("R1"));
	}
	@Test 
	public void testRemoveRobot() {
		Service service = new Service("S1", 2);
		service.add(new Robot("R1"));
		service.add(new Robot("R2"));
		service.remove("R2");
		Assert.assertEquals(1, service.getCount());
	}
	@Test(expected = IllegalArgumentException.class) 
	public void testRemoveUnknownRobot() {
		Service service = new Service("S1", 2);
		service.add(new Robot("R1"));
		service.add(new Robot("R2"));
		service.remove("R3");
	}
	@Test
	public void testRobotOnSale() {
		Service service = new Service("S1", 2);
		Robot robot = new Robot("R1");
		service.add(robot);
		service.add(new Robot("R2"));
		service.forSale("R1");
		Assert.assertFalse(robot.isReadyForSale());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testUnknownRobotOnSale() {
		Service service = new Service("S1", 2);
		Robot robot = new Robot("R1");
		service.add(robot);
		service.add(new Robot("R2"));
		service.forSale("R5");
	}
}
