package com.ssde.rest.inventoryapi.repositories;

import com.ssde.rest.inventoryapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jorian, SSDE Inc
 * on Fri, Mar 29 2024
 * at 14:57, inventory-api
 */
public interface ICategoryRepository extends JpaRepository<Category, Long> {}
