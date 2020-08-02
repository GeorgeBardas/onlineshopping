package com.georgebardas.onlineshopping.repositories;

import com.georgebardas.onlineshopping.objects.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Category, Integer> {
}
