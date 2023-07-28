package exam.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import exam.model.dto.ImportShopDto;
import exam.model.dto.ImportShopsDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParserer;

@Service
public class ShopServiceImpl implements ShopService {

	public static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

	
	private final ShopRepository shopRepository;
	private final ValidationUtil validationUtil;
	private final XmlParserer xmlParserer;
	private final ModelMapper modelMapper;
	private final TownRepository townRepository;
	
	public ShopServiceImpl(ValidationUtil validationUtil, ShopRepository shopRepository, XmlParserer parserer, ModelMapper modelMapper, TownRepository townRepository) {
		this.shopRepository = shopRepository;
		this.validationUtil = validationUtil;
		this.xmlParserer = parserer;
		this.modelMapper = modelMapper;
		this.townRepository = townRepository;
	}

	@Override
	public boolean areImported() {
		// TODO Auto-generated method stub
		return shopRepository.count() > 0;
	}

	@Override
	public String readShopsFileContent() throws IOException {
		// TODO Auto-generated method stub
		return Files.readString(Path.of(SHOPS_FILE_PATH));
	}

	@Override
	public String importShops() throws JAXBException, FileNotFoundException {
		ImportShopsDto importShopsDto = xmlParserer.fromFile(Path.of(SHOPS_FILE_PATH).toFile(), ImportShopsDto.class);
		StringBuilder builder = new StringBuilder();
		
		
		for (ImportShopDto dto : importShopsDto.getDtos()) {
			if(!validationUtil.isValid(dto) || shopRepository.findByName(dto.getName()) != null) {
				builder.append("Invalid shop").append(System.lineSeparator());
				continue;
			}
			Shop shop = modelMapper.map(dto, Shop.class);
			shop.setTown(townRepository.findByName(dto.getTown().getName()));
			shopRepository.save(shop);
			builder.append("Successfully imported Shop " + shop.getName() + " - " + (int)shop.getIncome()).append(System.lineSeparator());		
		}
		
		return builder.toString().trim();
	}

}
