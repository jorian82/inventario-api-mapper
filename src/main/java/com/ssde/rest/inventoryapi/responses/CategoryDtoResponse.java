package com.ssde.rest.inventoryapi.responses;

import com.ssde.rest.inventoryapi.models.CategoryDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 14:51, inventory-api
 */
@Data
public class CategoryDtoResponse {
    private List<CategoryDTO> categoryDtoList;
}
