package com.job.portal.services.implementations;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.model.Category;
import com.job.portal.repo.CategoryRepo;
import com.job.portal.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo cRepo;

    private static java.util.Map<String, String> map = new java.util.HashMap<>();

    @Override
    public String createCategory(Category cat) {
        Category ct = new Category(cat.getTitle(), cat.getDescription());
        this.cRepo.save(ct);
        return cat.getTitle() + " Saved Successfully!!";
    }

    @Override
    public String deleteCategory(Long id) {
        Category cat = this.cRepo.findById(id).get();
        if (cat != null) {
            this.cRepo.deleteById(id);
            return cat.getTitle() + " Deleted Successfully";
        }
        return "Unable to Delete Category";
    }

    @Override
    public List<Category> getCategories() {
        return this.cRepo.findAll();
    }

    @Override
    public String updateCategory(Category cat, Long id) {
        Category ct = this.cRepo.findById(id).get();
        if (ct == null)
            return "Wrong Category !!";
        ct.setTitle(cat.getTitle());
        ct.setQuiz(cat.getQuiz());
        ct.setDescription(cat.getDescription());
        // ct.set(cat.get());
        return cat.getTitle() + " Updated Successfully !!!";
    }

}
