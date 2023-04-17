package magicGame.models.magicians;

import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {

	private String username;
	private int health;
	private int protection;
	private boolean isAlive;
	private Magic magic;
	
	public MagicianImpl(String username, int health, int protection, Magic magic) {
		this.setUsername(username);
		this.setHealth(health);
		this.setProtection(protection);
		this.setMagic(magic);
		if(health > 0) isAlive = true;
		else isAlive = false;
	}

	
	
	public void setUsername(String username) {
		if(username == null || username.trim().isEmpty()) throw new NullPointerException("Username cannot be null or empty.");
		this.username = username;
	}

	public void setHealth(int health) {
		if(health < 0) throw new IllegalArgumentException("Magician health cannot be below 0.");
		this.health = health;
	}

	public void setProtection(int protection) {
		if(protection < 0) throw new IllegalArgumentException("Magician protection cannot be below 0.");
		this.protection = protection;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setMagic(Magic magic) {
		if(magic == null) throw new NullPointerException("Magic cannot be null.");
		this.magic = magic;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}

	@Override
	public int getProtection() {
		// TODO Auto-generated method stub
		return this.protection;
	}

	@Override
	public Magic getMagic() {
		// TODO Auto-generated method stub
		return this.magic;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.isAlive;
	}

	@Override
	public void takeDamage(int points) {
		if(protection < points) {
			points -= protection;
			protection = 0;
		}
		else {
			protection -= points;
			points = 0;
		}
		health -= points;
		if(health <= 0) {
			this.isAlive = false;
			health = 0;
		}

	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("%s: %s", getClass().getSimpleName(), getUsername())).append(System.lineSeparator());
		sBuilder.append("Health: " + getHealth()).append(System.lineSeparator());
		sBuilder.append("Protection: " + getProtection()).append(System.lineSeparator());
		sBuilder.append("Magic: " + getMagic().getName()).append(System.lineSeparator());
		
		return sBuilder.toString().trim();
	}

}
