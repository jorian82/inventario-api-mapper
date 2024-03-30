package com.ssde.rest.inventoryapi.controllers;

import com.ssde.rest.inventoryapi.responses.CategoryDtoResponseRest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 17:57, inventory-api
 */
@ActiveProfiles("Tests")
@SpringBootTest
class CategoryRestControllerIT {
    @Autowired
    CategoryRestController categoryRestController;

    @Test
    public void testListCategories() {
        ResponseEntity<CategoryDtoResponseRest> response = categoryRestController.searchCategories();

        assertThat(response.getBody().getCategoryDTOResponse().getCategoryDtoList()).isNotNull();
        assertThat(response.getBody().getMetadata().getFirst().get("type")).isEqualTo("Response OK");
    }
}