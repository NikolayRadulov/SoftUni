package robotService.entities.services;

import java.util.ArrayList;
import java.util.Collection;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

public abstract class BaseService implements Service {

	private String name;
	private int capacity;
	private Collection<Supplement> supplements;
	private Collection<Robot> robots;
	
	public BaseService(String name, int capacity) {
		this.setName(name);
		this.capacity = capacity;
		this.supplements = new ArrayList<>();
		this.robots = new ArrayList<>();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void setName(String name) {
		if(name == null || name.trim().length() == 0) throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
		this.name = name;
	}

	@Override
	public Collection<Robot> getRobots() {
		// TODO Auto-generated method stub
		return this.robots;
	}

	@Override
	public Collection<Supplement> getSupplements() {
		// TODO Auto-generated method stub
		return this.supplements;
	}

	@Override
	public void addRobot(Robot robot) {
		if(robots.size() >= capacity) throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
		this.robots.add(robot);

	}

	@Override
	public void removeRobot(Robot robot) {
		this.robots.remove(robot);

	}

	@Override
	public void addSupplement(Supplement supplement) {
		this.supplements.add(supplement);

	}

	@Override
	public void feeding() {
		this.robots.forEach(Robot::eating);
	}

	@Override
	public int sumHardness() {
		int sum = 0;
		for (Supplement supplement : supplements) {
			sum += supplement.getHardness();
		}
		
		return sum;
	}

	@Override
	public String getStatistics() {
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append(this.name + " " + this.getClass().getSimpleName()+":").append(System.lineSeparator());
		sBuilder.append("Robots:");
		if(this.robots.isEmpty()) sBuilder.append(" none");
		else this.robots.forEach(robot -> sBuilder.append(" " + robot.getName()));
		sBuilder.append(System.lineSeparator()).append("Supplements: "+supplements.size() + " Hardness: " + sumHardness());
		
		return sBuilder.toString().trim();
	}

}
