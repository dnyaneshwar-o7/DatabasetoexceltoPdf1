package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "id")
    private String categoryId;

    @Column(name="category_title",length =60,nullable = false)
    private String title;

    @Column(name = "category_desc",length = 5000)
    private String description;

    private String coverimage;

    public Category() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrition() {
        return description;
    }

    public void setDescrition(String descrition) {
        this.description = descrition;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }
}
