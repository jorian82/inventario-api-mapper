package com.ssde.rest.inventoryapi.responses;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 14:53, inventory-api
 */
@Getter
@Setter
public class CategoryDtoResponseRest extends ResponseRest{
    private CategoryDtoResponse categoryDTOResponse = new CategoryDtoResponse();
}
