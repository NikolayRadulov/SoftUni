package exam.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

@Component
public class XmlParserer {

	@SuppressWarnings("unchecked")
	public <T> T fromFile(File file, Class<T> obj) throws JAXBException, FileNotFoundException {
		final JAXBContext context = JAXBContext.newInstance(obj);
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		
		final FileReader reader = new FileReader(file);
		
		return (T) unmarshaller.unmarshal(reader);
	}

}

