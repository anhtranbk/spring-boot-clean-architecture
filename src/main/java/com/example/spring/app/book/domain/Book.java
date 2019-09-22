package com.example.spring.app.book.domain;

import com.example.spring.db.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "events")
public class Book extends BaseDomain {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 11)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1023)
    private String description;

    @Column(name = "isbn", nullable = false, length = 5)
    private String isbn;

    @Column(name = "author", nullable = false, length = 5)
    private String author;

    @Column(name = "price", precision = 11, scale = 0)
    private float price;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "deleted", nullable = false)
    private Boolean isDeleted;
}
