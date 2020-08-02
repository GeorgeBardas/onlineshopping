package com.georgebardas.onlineshopping.repositories;

import com.georgebardas.onlineshopping.objects.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
