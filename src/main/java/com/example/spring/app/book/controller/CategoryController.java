package com.example.spring.app.book.controller;

import com.example.spring.app.book.dto.CategoryDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getById(@PathVariable("categoryId") int categoryId) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public CategoryDTO create(CategoryDTO categoryDTO) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/{categoryId}")
    public CategoryDTO update(@PathVariable("categoryId") int categoryId) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{categoryId}")
    public int delete(@PathVariable("categoryId") int categoryId) {
        throw new UnsupportedOperationException();
    }
}
