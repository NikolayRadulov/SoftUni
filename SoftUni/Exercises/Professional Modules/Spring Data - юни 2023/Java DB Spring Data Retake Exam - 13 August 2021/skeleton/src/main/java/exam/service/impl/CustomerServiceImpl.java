package exam.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import exam.model.dto.ImportCustomerDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	public static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

	
	private final CustomerRepository customerRepository;
	private final TownRepository townRepository;
	private final ValidationUtil validationUtil;
	private final Gson gson;
	private final ModelMapper modelMapper;
	

	public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository,
			ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.townRepository = townRepository;
		this.validationUtil = validationUtil;
		this.gson = gson;
		this.modelMapper = modelMapper;
	}

	@Override
	public boolean areImported() {
		// TODO Auto-generated method stub
		return customerRepository.count() > 0;
	}

	@Override
	public String readCustomersFileContent() throws IOException {
		// TODO Auto-generated method stub
		return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
	}

	@Override
	public String importCustomers() throws IOException {
		ImportCustomerDto[] importCustomerDtos = gson.fromJson(readCustomersFileContent(), ImportCustomerDto[].class);
		StringBuilder builder = new StringBuilder();
		
		for (ImportCustomerDto importCustomerDto : importCustomerDtos) {
			if(!validationUtil.isValid(importCustomerDto) || customerRepository.existsByEmail(importCustomerDto.getEmail())) {
				builder.append("Invalid Customer").append(System.lineSeparator());
				continue;
			}
			
			Customer customer = modelMapper.map(importCustomerDto, Customer.class);
			final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			customer.setRegisteredOn(LocalDate.parse(importCustomerDto.getRegisteredOn(), dateTimeFormatter));
			customer.setTown(townRepository.findByName(importCustomerDto.getTown().getName()));
			
			customerRepository.save(customer);
			
			builder.append(String.format("Successfully imported Customer %s %s - %s", customer.getFirstName(), customer.getLastName(), customer.getEmail())).append(System.lineSeparator());
		}
		
		return builder.toString().trim();
	}

}
