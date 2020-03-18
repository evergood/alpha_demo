package com.demo.alpha.util;

import com.demo.alpha.domen.Box;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Parser {

    @Value("{file.name}")
    private static String fileName;


    public static void parseBox() throws JAXBException {
        File file = new File(fileName);

        JAXBContext jaxbContext = JAXBContext.newInstance(Box.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Box box = (Box) jaxbUnmarshaller.unmarshal(file);
    }
}



