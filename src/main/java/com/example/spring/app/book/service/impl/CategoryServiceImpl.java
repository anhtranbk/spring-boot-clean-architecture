package com.example.spring.app.book.service.impl;

import com.example.spring.app.book.domain.Category;
import com.example.spring.app.book.dto.CategoryDTO;
import com.example.spring.app.book.respository.CategoryRepository;
import com.example.spring.app.book.service.CategoryService;
import com.example.spring.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(int categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        if (category == null) {
            throw new ResourceNotFoundException("Category ID " + categoryId + " not found");
        }
        return new CategoryDTO(category);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public int delete(int categoryId) {
        return 0;
    }
}
