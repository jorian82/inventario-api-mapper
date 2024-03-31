package com.ssde.rest.inventoryapi.services;

import com.ssde.rest.inventoryapi.entities.Category;
import com.ssde.rest.inventoryapi.models.CategoryDTO;
import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 19:51, inventory-api
 */
@Profile("Tests")
@Service
public class CategoryServiceTest implements ICategoryService{
    @Override
    public ResponseEntity<CategoryDtoResponseRest> search() {
        CategoryDtoResponseRest response = new CategoryDtoResponseRest();

        try {
            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            categoryDTOList.add(
                    CategoryDTO.builder()
                            .name("cat1")
                            .description("category 1").build()
            );
            categoryDTOList.add(
                    CategoryDTO.builder()
                            .name("cat2")
                            .description("category 2").build()
            );

            response.getCategoryDTOResponse().setCategoryDtoList(categoryDTOList);
            response.setMetadata("Response OK", "00", "Response successful");
            return new ResponseEntity<>(response,HttpStatus.OK);

        } catch (Exception e) {
            response.setMetadata("Response fail", "-1", "Error getting the categories list");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<CategoryDtoResponseRest> searchById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDtoResponseRest> save(Category cat) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryDtoResponseRest> update(Category cat, Long id) {
        return null;
    }
}
