package com.demo.alpha.service;

import com.demo.alpha.domen.Box;

public interface BoxService {
    Iterable<Box> saveAll(Iterable<Box> boxes);

    Box save(Box box);

}
