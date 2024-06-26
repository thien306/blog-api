package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "text")
    private String content;

    @Column(name = "blogger_name")
    private String bloggerName;

    @Column(name = "day_write")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayWrite;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String name, String content, String bloggerName, Date dayWrite, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bloggerName = bloggerName;
        this.dayWrite = dayWrite;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }

    public Date getDayWrite() {
        return dayWrite;
    }

    public void setDayWrite(Date dayWrite) {
        this.dayWrite = dayWrite;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}