package com.job.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.model.Category;
import com.job.portal.services.CategoryService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
// @CrossOrigin("http://[::1]:4200/")
@CrossOrigin("*")
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService cService;

    @GetMapping("get")
    public List<Category> getCategories() {
        return this.cService.getCategories();
    }

    @PostMapping("create")
    public String saveCategory(@RequestBody Category category) {
        return this.cService.createCategory(category);
    }

    @PutMapping("update/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody Category cat) {
        return this.cService.updateCategory(cat, id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return this.cService.deleteCategory(id);
    }

}
