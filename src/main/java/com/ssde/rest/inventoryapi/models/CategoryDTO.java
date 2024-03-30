package com.ssde.rest.inventoryapi.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 14:47, inventory-api
 */
@Data
@Builder
public class CategoryDTO {
    private Long id;
    private Integer version;
    private String name;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
