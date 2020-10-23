package com.myproducts.controllers;


import com.myproducts.exceptions.NotProductFoundException;
import com.myproducts.model.Product;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @GetMapping("/product-discount")
    public Product productHasDiscount(@RequestParam(value="productName") String productName) {

            boolean isProductInCatalog = false;

            //This should be returned by a database but for now will be mocked
            Product product = new Product(productName, false);

            if (productName.equals("Blouse")) {
                product = new Product("Blouse", true);
                isProductInCatalog = true;
            }
            if (productName.equals("Jeans")) {
                product = new Product("Jeans", true);
                isProductInCatalog = true;
            }

            if (productName.equals("Phone")) {
                product = new Product("Phone", false);
                isProductInCatalog = true;
            }

            if (productName.equals("Table")) {
                product = new Product("Table", true);
                isProductInCatalog = true;
            }

            logger.info("Product: " + productName);
            logger.info("is Product in Catalog: " + isProductInCatalog);


            if (!isProductInCatalog) {
                logger.error("Product Not Found exception");
                throw new NotProductFoundException("Product Not Found");
            }

            return product;


    }
}
