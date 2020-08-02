package com.georgebardas.onlineshopping;

import com.georgebardas.onlineshopping.objects.Category;
import com.georgebardas.onlineshopping.objects.Product;
import com.georgebardas.onlineshopping.repositories.CategoriesRepository;
import com.georgebardas.onlineshopping.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CategoriesRepository categoryRepository;

    @GetMapping(path = "/products")
    public Iterable<Product> getProducts() {
        return productsRepository.findAll();
    }

    @PostMapping(path = "/addProduct")
    public @ResponseBody Product addNewUser(@RequestBody Map<String, Object> payload) throws Exception {
        Product newProduct = new Product(
                payload.get("title").toString(),
                Float.parseFloat(payload.get("price").toString()),
                payload.get("description").toString(),
                Integer.parseInt(payload.get("categoryId").toString())
        );
        productsRepository.save(newProduct);
        return newProduct;
    }

    @PostMapping(path = "/addCategory")
    public @ResponseBody Category addNewCategory(@RequestBody Map<String, Object> payload) throws Exception {
        Category newCategory = new Category(
                payload.get("title").toString()
        );
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @GetMapping(path = "/categories")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
