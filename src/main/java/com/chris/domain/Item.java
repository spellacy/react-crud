package com.chris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Item {
    private int id;
    private String name;
    private String barcode;
    private Date purchaseDate;
    private Date expiration;
    private String url;
}