package id.ac.ui.cs.advpro.eshop.service;

import id.ac.ui.cs.advpro.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> findAll();
    Product findById(String productId);
    Product updateProduct(Product updatedProduct);
    Product deleteProduct(String productId);
}
