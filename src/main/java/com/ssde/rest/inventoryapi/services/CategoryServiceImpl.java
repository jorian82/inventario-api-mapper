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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryDtoResponseRest> search() {
        CategoryDtoResponseRest response = new CategoryDtoResponseRest();

        try {
            List<CategoryDTO> categoryDTOList = categoryRepository.findAll()
                    .stream()
                    .map(categoryMapper::categoryToCategoryDto)
                    .toList();

            response.getCategoryDTOResponse().setCategoryDtoList(categoryDTOList);
            response.setMetadata(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.name());
        } catch (Exception e) {
            response.setMetadata(HttpStatus.INTERNAL_SERVER_ERROR.toString(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.name());
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryDtoResponseRest> searchById(Long id) {
        CategoryDtoResponseRest response = new CategoryDtoResponseRest();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        try {
            categoryRepository.findById(id).ifPresentOrElse(
                    category -> {
                        categoryDTOList.add(categoryMapper.categoryToCategoryDto(category));
                        response.getCategoryDTOResponse().setCategoryDtoList(categoryDTOList);
                        response.setMetadata(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.name());
                    },
                    () ->
                        response.setMetadata(HttpStatus.NOT_FOUND.toString(), String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND.name())
                    );

        } catch (Exception e) {
            response.setMetadata("Response fail", "-1", String.format("Error getting the category: %d", id));
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response,HttpStatus.valueOf(response.getMetadata().getFirst().get("data")));
    }
}
