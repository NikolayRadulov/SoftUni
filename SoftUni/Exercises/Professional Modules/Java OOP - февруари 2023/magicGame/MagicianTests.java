package magicGame;

import org.junit.Test;
import org.junit.Assert;
public class MagicianTests {


	@Test
	public void testCreation() {
		Magician magician = new Magician("Tim", 50);
		Assert.assertTrue(magician.getUsername().equals("Tim") && magician.getHealth() == 50);
	}
	
	@Test(expected = NullPointerException.class)
	public void testBlankAndNullName() {
		new Magician("   ", 50);
		new Magician(null, 50);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeHealth() {
		new Magician("Tim", -50);
	}
	@Test
	public void testDamageIntake() {
		Magician magician = new Magician("Tim", 50);
		magician.takeDamage(30);
		Assert.assertEquals(magician.getHealth(), 20);
	}
	@Test
	public void testHealthSet() {
		Magician magician = new Magician("Tim", 50);
		magician.takeDamage(60);
		Assert.assertEquals(magician.getHealth(), 0);
	}
	@Test(expected = IllegalStateException.class)
	public void testDamageDeadMagician() {
		Magician magician = new Magician("Tim", 50);
		magician.takeDamage(50);
		magician.takeDamage(40);
	}
	@Test
	public void testAddMagic() {
		Magician magician = new Magician("Tim", 50);
		Magic magic = new Magic("Purple magic", 20);
		magician.addMagic(magic);
		Assert.assertTrue(magician.getMagics().size() == 1);
	}
	@Test(expected = NullPointerException.class)
	public void testAddNullMagic() {
		Magician magician = new Magician("Tim", 50);
		magician.addMagic(null);
	}
	
	@Test
	public void testRemoveMagic() {
		Magician magician = new Magician("Tim", 50);
		Magic magic = new Magic("Purple magic", 20);
		magician.addMagic(magic);
		Magic magic2 = new Magic("Black magic", 20);
		magician.addMagic(magic2);
		magician.removeMagic(magic);
		Assert.assertTrue(magician.getMagics().size() == 1);
	}
	
	@Test
	public void testGetMagic() {
		Magician magician = new Magician("Tim", 50);
		Magic magic = new Magic("Purple magic", 20);
		magician.addMagic(magic);
		Magic magic2 = new Magic("Black magic", 20);
		magician.addMagic(magic2);
		Magic magic2_2 = magician.getMagic("Black magic"); 
		Assert.assertEquals(magic2, magic2_2);
	}
}
