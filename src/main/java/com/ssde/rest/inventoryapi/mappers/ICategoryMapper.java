package com.ssde.rest.inventoryapi.mappers;

import com.ssde.rest.inventoryapi.entities.Category;
import com.ssde.rest.inventoryapi.models.CategoryDTO;
import org.mapstruct.Mapper;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 15:00, inventory-api
 */
@Mapper
public interface ICategoryMapper {
    Category categoryDtoToCategory(CategoryDTO dto);
    CategoryDTO categoryToCategoryDto(Category category);
}
