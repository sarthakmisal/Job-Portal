package com.job.portal.services;

import org.springframework.stereotype.Service;

import com.job.portal.model.Category;

public interface CategoryService {
    String createCategory(Category cat);

    String deleteCategory(Long id);

    java.util.List<Category> getCategories();

    String updateCategory(Category cat,Long id);
}
