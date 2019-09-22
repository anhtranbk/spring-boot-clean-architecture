package com.example.spring.app.book.controller;

import com.example.spring.app.book.dto.CategoryDTO;
import com.example.spring.app.book.service.CategoryService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@Setter
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getById(@PathVariable("categoryId") int categoryId) {
        return categoryService.getById(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO create(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.create(categoryDTO);
    }

    @PutMapping("/{categoryId}")
    public CategoryDTO update(@PathVariable("categoryId") int categoryId,
                              @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(categoryId);
        return categoryService.update(categoryDTO);
    }

    @DeleteMapping("/{categoryId}")
    public int delete(@PathVariable("categoryId") int categoryId) {
        return categoryService.delete(categoryId);
    }
}
