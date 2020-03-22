package com.demo.alpha.repository;

import com.demo.alpha.domen.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

}
