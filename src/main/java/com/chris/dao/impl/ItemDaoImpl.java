package com.chris.dao.impl;

import com.chris.dao.ItemDao;
import com.chris.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by chris on 1/29/17.
 */
public class ItemDaoImpl implements ItemDao {

    private final JdbcTemplate template;

    @Autowired
    public ItemDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    //java 8 suggested using lambda expression here, it is cleaner looking
    @Override
    public Item getItem(int id) {
        return template.queryForObject("select id, name, barcode, purchase_date, expiration_date, url from ITEM where id = ?",
                new Object[] {id},
                (rs, rowNum) -> new Item(rs.getInt("id"),
                                         rs.getString("name"),
                                         rs.getString("barcode"),
                                         rs.getDate("purchase_date"),
                                         rs.getDate("expiration_date"),
                                         rs.getString("url")));
    }

    @Override
    public Item getItemByName(String name) {

        return template.queryForObject("SELECT id, name, barcode, purchase_date, expiration_date, url FROM ITEM WHERE upper(name) = upper(?)",
                new Object[]{name},
                (rs, rowNum) -> new Item(rs.getInt("id"),
                                         rs.getString("name"),
                                         rs.getString("barcode"),
                                         rs.getDate("purchase_date"),
                                         rs.getDate("expiration_date"),
                                         rs.getString("url")));
    }

    @Override
    public void insertItem(Item item) {

        template.update("insert into ITEM (name, barcode, purchase_date, expiration_date, url) values (?, ?, ?, ?, ?)",
                             new Object[] { item.getName(), item.getBarcode(), item.getPurchaseDate(), item.getExpiration(), item.getUrl()});
    }
}