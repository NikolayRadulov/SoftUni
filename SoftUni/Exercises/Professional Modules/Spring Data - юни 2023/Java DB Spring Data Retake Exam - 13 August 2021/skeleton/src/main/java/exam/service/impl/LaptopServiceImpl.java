package exam.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import exam.model.dto.ImportLaptopDto;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;

@Service
public class LaptopServiceImpl implements LaptopService {

	public static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

	
	private final LaptopRepository laptopRepository;
	private final ShopRepository shopRepository;
	private final ValidationUtil validationUtil;
	private final Gson gson;
	private final ModelMapper modelMapper;
	
	
	public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository,
			ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
		this.laptopRepository = laptopRepository;
		this.shopRepository = shopRepository;
		this.validationUtil = validationUtil;
		this.gson = gson;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean areImported() {
		// TODO Auto-generated method stub
		return laptopRepository.count() > 0;
	}

	@Override
	public String readLaptopsFileContent() throws IOException {
		// TODO Auto-generated method stub
		return Files.readString(Path.of(LAPTOPS_FILE_PATH));
	}

	@Override
	public String importLaptops() throws IOException {
		ImportLaptopDto[] importLaptopDtos = gson.fromJson(readLaptopsFileContent(), ImportLaptopDto[].class);
		StringBuilder builder = new StringBuilder();
		
		for (ImportLaptopDto importLaptopDto : importLaptopDtos) {
			if(!validationUtil.isValid(importLaptopDto) || laptopRepository.existsByMacAddress(importLaptopDto.getMacAddress())) {
				builder.append("Invalid Laptop").append(System.lineSeparator());
				continue;
			}
			
			Laptop laptop = modelMapper.map(importLaptopDto, Laptop.class);
			laptop.setShop(shopRepository.findByName(importLaptopDto.getShop().getName()));
			
			laptopRepository.save(laptop);
			
			builder.append(String.format("Successfully imported Laptop-%s-%.2f-%d-%d",laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage())).append(System.lineSeparator());
		}
		
		return builder.toString().trim();
	}

	@Override
	public String exportBestLaptops() {
		List<Laptop> laptops = laptopRepository.findOrderedLaptops();
		StringBuilder builder = new StringBuilder();
		
		for (Laptop laptop : laptops) {
			builder.append("Laptop - " + laptop.getMacAddress()).append(System.lineSeparator());
			builder.append(String.format("*Cpu speed - %.2f", laptop.getCpuSpeed())).append(System.lineSeparator());
			builder.append("**Ram - " + laptop.getRam()).append(System.lineSeparator());
			builder.append("***Storage - " + laptop.getStorage()).append(System.lineSeparator());
			builder.append(String.format("****Price - %.2f", laptop.getPrice().doubleValue())).append(System.lineSeparator());
			builder.append("#Shop name - " + laptop.getShop().getName()).append(System.lineSeparator());
			builder.append("##Town - " + laptop.getShop().getTown().getName()).append(System.lineSeparator());

		}
		
		return builder.toString().trim();
	}

}
