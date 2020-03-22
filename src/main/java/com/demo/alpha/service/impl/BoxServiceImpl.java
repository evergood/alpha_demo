package com.demo.alpha.service.impl;

import com.demo.alpha.domen.Box;
import com.demo.alpha.repository.BoxRepository;
import com.demo.alpha.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoxServiceImpl implements BoxService {

    private BoxRepository boxRepository;

    @Autowired
    public BoxServiceImpl(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Override
    public Iterable<Box> saveAll(Iterable<Box> boxes) {
        return boxRepository.saveAll(boxes);
    }
}
