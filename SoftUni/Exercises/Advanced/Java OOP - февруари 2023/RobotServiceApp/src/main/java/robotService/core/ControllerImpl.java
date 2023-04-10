package robotService.core;

import java.util.ArrayList;
import java.util.Collection;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

public class ControllerImpl implements Controller {

	private SupplementRepository supplements;
	private Collection<Service> services;
	
	public ControllerImpl() {
		this.supplements = new SupplementRepository();
		this.services = new ArrayList<>();
	}

	@Override
	public String addService(String type, String name) {
		Service service;
		
		switch (type) {
			case "MainService": {
				service = new MainService(name);
			}
			break;
			case "SecondaryService": {
				service = new SecondaryService(name);
			}
			break;
			
			default: throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
		}
		this.services.add(service);
		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
	}

	@Override
	public String addSupplement(String type) {
		Supplement supplement;
		
		switch (type) {
			case "MetalArmor": {
				supplement = new MetalArmor();
			}
			break;
			case "PlasticArmor": {
				supplement = new PlasticArmor();
			}
			break;
			
			default: throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
		}
		this.supplements.addSupplement(supplement);
		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
	}

	@Override
	public String supplementForService(String serviceName, String supplementType) {
		Service service = getServiceByName(serviceName);
		Supplement supplement = supplements.findFirst(supplementType);
		if(supplement == null) throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
		
		supplements.removeSupplement(supplement);
		service.addSupplement(supplement);
		
		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
	}

	@Override
	public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
		Service service = getServiceByName(serviceName);
		Robot robot;
		
		switch (robotType) {
			case "MaleRobot": {
				robot = new MaleRobot(robotName, robotKind, price);
				if(service.getClass().getSimpleName().equals("SecondaryService")) return ConstantMessages.UNSUITABLE_SERVICE;
			}
			break;
			case "FemaleRobot": {
				robot = new FemaleRobot(robotName, robotKind, price);
				if(service.getClass().getSimpleName().equals("MainService")) return ConstantMessages.UNSUITABLE_SERVICE;
			}
			break;
			
			default: throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
		}
		service.addRobot(robot);
		
		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
	}

	@Override
	public String feedingRobot(String serviceName) {
		Service service = getServiceByName(serviceName);
		
		service.feeding();
		
		return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
	}

	@Override
	public String sumOfAll(String serviceName) {
		Service service = getServiceByName(serviceName);
		
		double value = 0;
		for (Robot robot : service.getRobots()) {
			value += robot.getPrice();
		}
		for (Supplement supplement : service.getSupplements()) {
			value += supplement.getPrice();
		}
		return String.format(ConstantMessages.VALUE_SERVICE, serviceName, value);
	}

	@Override
	public String getStatistics() {
		StringBuilder builder = new StringBuilder();
		
		for (Service service : services) {
			builder.append(service.getStatistics()).append(System.lineSeparator());
		}
		return builder.toString().trim();
	}

	
	private Service getServiceByName(String name) {
		return this.services.stream().filter(service -> service.getName().equals(name)).findFirst().orElse(null);
	}
}
