package com.demo.alpha.service.impl;

import com.demo.alpha.domen.Item;
import com.demo.alpha.repository.ItemRepository;
import com.demo.alpha.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private EntityManager entityManager;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, EntityManager entityManager) {
        this.itemRepository = itemRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<Item> saveAll(Iterable<Item> items) {
        return itemRepository.saveAll(items);
    }

    @Override
    public List<Item> findByBoxIsAndColor(Integer id, String color) {
        Query query = entityManager.createNativeQuery("WITH dh\n" +
                "     (id)\n" +
                "AS\n" +
                "(\n" +
                "SELECT d.ID\n" +
                "       FROM BOX d\n" +
                "       WHERE d.ID = ?\n" +
                "UNION ALL\n" +
                "SELECT d.ID\n" +
                "       FROM BOX d\n" +
                "            INNER JOIN dh\n" +
                "                       ON dh.id = d.CONTAINED_IN\n" +
                ")\n" +
                "SELECT e.ID,\n" +
                "       e.COLOR,\n" +
                "       dh.id\n" +
                "       FROM dh\n" +
                "            LEFT JOIN ITEM e\n" +
                "                      ON e.CONTAINED_IN = dh.id\n" +
                "WHERE color = ?;", "ItemResults");
        query.setParameter(1, id);
        query.setParameter(2, color);
        List<Item> items = query.getResultList();
        return items;
    }
}
