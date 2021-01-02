package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "image", columnDefinition = "clob") // clob 文字型態的大資料, blob 二進位型態的大資料
    @Lob
    private String image; // 將圖像轉成 base64 後存入

}
