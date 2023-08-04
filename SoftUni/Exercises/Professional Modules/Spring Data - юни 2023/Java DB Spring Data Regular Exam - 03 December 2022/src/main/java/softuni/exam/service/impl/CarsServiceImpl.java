package softuni.exam.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuni.exam.models.dto.ImportCarDto;
import softuni.exam.models.dto.ImportCarsDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;
import softuni.exam.util.enums.CarType;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser parser;
    
    public CarsServiceImpl(CarsRepository carsRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser parser) {
		this.carsRepository = carsRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
		this.parser = parser;
	}

	@Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
		
		StringBuilder builder = new StringBuilder();
		
		ImportCarsDto dto = parser.fromFile(Path.of(CARS_FILE_PATH).toFile(), ImportCarsDto.class);
		
		for(ImportCarDto importCarDto : dto.getCars()) {
			Set<ConstraintViolation<ImportCarDto>> violations = validationUtil.getConstraintViolation(importCarDto);
			
			if (!violations.isEmpty() || carsRepository.findByPlateNumber(importCarDto.getPlateNumber()) != null) {
				builder.append("Invalid car").append(System.lineSeparator());
				continue;
			}
			
			Car car = modelMapper.map(importCarDto, Car.class);
			car.setCarType(CarType.valueOf(importCarDto.getCarType()));
			carsRepository.save(car);
			builder.append("Successfully imported car " + car.getCarMake() + " - " + car.getCarModel()).append(System.lineSeparator());
		}
        return builder.toString().trim();
    }
}
