package com.example.spring.app.book.domain;

import com.example.spring.db.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review extends BaseDomain {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner", nullable = false, length = 11)
    private Integer ownerId;

    @Column(name = "book_id", nullable = false, length = 50)
    private Integer bookId;

    @Column(name = "content", nullable = false, length = 1023)
    private String content;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
