package com.example.spring.app.book.service.impl;

import com.example.spring.app.book.domain.Category;
import com.example.spring.app.book.dto.CategoryDTO;
import com.example.spring.app.book.respository.CategoryRepository;
import com.example.spring.app.book.service.CategoryService;
import com.example.spring.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category = categoryRepository.save(category);

        return new CategoryDTO(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        if (!categoryRepository.exists(categoryDTO.getId())) {
            throw new ResourceNotFoundException("Category ID " + categoryDTO.getId() + " not found");
        }

        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category = categoryRepository.save(category);

        return new CategoryDTO(category);
    }

    @Override
    public void delete(int categoryId) {
        try {
            categoryRepository.delete(categoryId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(e);
        }
    }
}
