package com.demo.alpha.repository;

import com.demo.alpha.domen.Box;
import com.demo.alpha.domen.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i where i.box.id =:id and i.color =:color")
    public List<Item> findByBoxIsAndColor(@Param("id") Integer id, @Param("color") String color);
}
