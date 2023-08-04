package softuni.exam.service;


import java.io.IOException;

import javax.xml.bind.JAXBException;

public interface CarsService {

    boolean areImported();

    String readCarsFromFile() throws IOException;

    String importCars() throws IOException, JAXBException;
}
