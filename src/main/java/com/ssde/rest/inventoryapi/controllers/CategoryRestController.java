package com.ssde.rest.inventoryapi.controllers;

import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import com.ssde.rest.inventoryapi.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    public ResponseEntity<CategoryDtoResponseRest> searchCategories() {
        return categoryService.search();
    }
}
