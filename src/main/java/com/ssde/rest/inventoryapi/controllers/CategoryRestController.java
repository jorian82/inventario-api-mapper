package com.ssde.rest.inventoryapi.controllers;

import com.ssde.rest.inventoryapi.entities.Category;
import com.ssde.rest.inventoryapi.models.CategoryDTO;
import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import com.ssde.rest.inventoryapi.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 16:41, inventory-api
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryRestController {
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<CategoryDtoResponseRest> searchCategories() {
        return categoryService.search();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDtoResponseRest> searchCategoryById(@PathVariable Long id) {
        return categoryService.searchById(id);
    }

    @PostMapping("")
    public ResponseEntity<CategoryDtoResponseRest> saveCategory(@RequestBody CategoryDTO dto) {
        Category cat = Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        return categoryService.save(cat);
    }
}
