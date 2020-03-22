package com.demo.alpha.repository;

import com.demo.alpha.domen.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "WITH RECURSIVE r AS (\n" +
            "   SELECT ID, COLOR, CONTAINED_IN\n" +
            "   FROM ITEM\n" +
            "   WHERE ID =:id AND COLOR =:color\n" +
            "\n" +
            "   UNION\n" +
            "\n" +
            "   SELECT r.ID, r.COLOR, BOX.ID" +
            "   FROM BOX\n" +
            "      JOIN r\n" +
            "          ON BOX.CONTAINED_IN = r.CONTAINED_IN\n" +
            ")\n" +
            "SELECT ID FROM r;",
            nativeQuery = true)
    public List<Integer> findByBoxIsAndColor(@Param("id") Integer id, @Param("color") String color);
}
