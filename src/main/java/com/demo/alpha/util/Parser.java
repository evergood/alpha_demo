package com.demo.alpha.util;

import com.demo.alpha.domen.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class Parser {

    @Value("{file.name}")
    private static String fileName;

    public static Storage parseStorage() throws JAXBException, IOException {
        Resource resource = new ClassPathResource(fileName);

        File file = resource.getFile();
        JAXBContext jaxbContext = JAXBContext.newInstance(Storage.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Storage storage = (Storage) jaxbUnmarshaller.unmarshal(file);
        log.debug(String.format("Storage parsed: %b", storage));
        return storage;
    }
}



