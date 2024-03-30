package com.ssde.rest.inventoryapi.services;

import com.ssde.rest.inventoryapi.mappers.ICategoryMapper;
import com.ssde.rest.inventoryapi.models.CategoryDTO;
import com.ssde.rest.inventoryapi.repositories.ICategoryRepository;
import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 15:11, inventory-api
 */
@Profile({"prod","default"})
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;
    @Override
    public ResponseEntity<CategoryDtoResponseRest> search() {
        CategoryDtoResponseRest response = new CategoryDtoResponseRest();

        try {
            List<CategoryDTO> categoryDTOList = categoryRepository.findAll()
                    .stream()
                    .map(categoryMapper::categoryToCategoryDto)
                    .toList();

            response.getCategoryDTOResponse().setCategoryDtoList(categoryDTOList);
            response.setMetadata("Response OK", "00", "Response successful");
        } catch (Exception e) {
            response.setMetadata("Response fail", "-1", "Error getting the categories list");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
