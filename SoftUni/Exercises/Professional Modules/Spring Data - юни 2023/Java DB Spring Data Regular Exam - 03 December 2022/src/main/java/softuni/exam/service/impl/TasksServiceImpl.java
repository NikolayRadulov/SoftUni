package softuni.exam.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import softuni.exam.models.dto.ImportTaskDto;
import softuni.exam.models.dto.ImportTasksDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.util.enums.CarType;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser parser;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final CarsRepository carRepository;
    
    public TasksServiceImpl(TasksRepository tasksRepository, ValidationUtil validationUtil, XmlParser parser, ModelMapper modelMapper, PartsRepository partsRepository, MechanicsRepository mechanicsRepository, CarsRepository carRepository) {
		this.tasksRepository = tasksRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
		this.parser = parser;
		this.mechanicsRepository = mechanicsRepository;
		this.partsRepository = partsRepository;
		this.carRepository = carRepository;
	}

	@Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
    	
    	ImportTasksDto dto = parser.fromFile(Path.of(TASKS_FILE_PATH).toFile(), ImportTasksDto.class);
    	StringBuilder builder = new StringBuilder();
    	
    	for (ImportTaskDto importTaskDto : dto.getTaskDtos()) {
			Set<ConstraintViolation<ImportTaskDto>> violations = validationUtil.getConstraintViolation(importTaskDto);
			
			Car car = carRepository.findById(importTaskDto.getCar().getId()).get();
			Mechanic mechanic = mechanicsRepository.findByFirstName(importTaskDto.getMechanic().getFirstName());
			Part part = partsRepository.findById(importTaskDto.getPart().getId()).get();
			
			if(!violations.isEmpty() || car == null || mechanic == null) {
				builder.append("Invalid task").append(System.lineSeparator());
				continue;
			}
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(importTaskDto.getDate(), dateTimeFormatter);
			BigDecimal decimal = new BigDecimal(importTaskDto.getPrice());
			
			
			Task task = modelMapper.map(importTaskDto, Task.class);
			task.setDate(dateTime);
			task.setCar(car);
			task.setMechanic(mechanic);
			task.setPrice(decimal);
			task.setPart(part);
			
			tasksRepository.save(task);
			builder.append(String.format("Successfully imported task %.2f", task.getPrice())).append(System.lineSeparator());
			
		}
    	
        return builder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
    	List<Task> tasks = tasksRepository.findAllOrderByPrice();
    	StringBuilder builder = new StringBuilder();
 
    	for (Task task : tasks) {
    		if(task.getCar() == null || task.getCar().getCarType() != CarType.coupe) continue;
    		
			builder.append(String.format("Car %s %s with %dkm", task.getCar().getCarMake(), task.getCar().getCarModel(), task.getCar().getKilometers()))
			.append(System.lineSeparator())
			.append(String.format("-Mechanic: %s %s - task №%d:", task.getMechanic().getFirstName(), task.getMechanic().getLastName(), task.getId()))
			.append(System.lineSeparator())
			.append(String.format(" --Engine: %.1f", task.getCar().getEngine())).append(System.lineSeparator())
			.append(String.format("---Price: %.2f$", task.getPrice().doubleValue())).append(System.lineSeparator());
		}
    	
    	
        return builder.toString().trim();
    }
}
