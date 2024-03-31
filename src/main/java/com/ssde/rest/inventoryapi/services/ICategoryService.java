package com.ssde.rest.inventoryapi.services;

import com.ssde.rest.inventoryapi.entities.Category;
import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 15:09, inventory-api
 */
public interface ICategoryService {
    public ResponseEntity<CategoryDtoResponseRest> search();

    public ResponseEntity<CategoryDtoResponseRest> searchById(Long id);

    public ResponseEntity<CategoryDtoResponseRest> save(Category cat);

    public ResponseEntity<CategoryDtoResponseRest> update(Category cat, Long id);

    public ResponseEntity<CategoryDtoResponseRest> deleteById(Long id);
}
