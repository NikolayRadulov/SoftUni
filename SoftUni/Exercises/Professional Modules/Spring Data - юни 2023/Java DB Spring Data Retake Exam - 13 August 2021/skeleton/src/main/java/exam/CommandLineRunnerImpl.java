package exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import exam.service.CustomerService;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.service.TownService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	private final CustomerService customerService;
	private final LaptopService laptopService;
	private final ShopService shopService;
	private final TownService townService;
	
	
	public CommandLineRunnerImpl(TownService townService, ShopService shopService, LaptopService laptopService, CustomerService customerService) {
		this.customerService = customerService;
		this.laptopService = laptopService;
		this.shopService = shopService;
		this.townService = townService;
	}

	@Override
	public void run(String... args) throws Exception {
		if(!townService.areImported())System.out.println(townService.importTowns());
		if(!shopService.areImported())System.out.println(shopService.importShops());
		if(!customerService.areImported()) System.out.println(customerService.importCustomers());
		if(!laptopService.areImported())System.out.println(laptopService.importLaptops());

		System.out.println(laptopService.exportBestLaptops());
	}

}
