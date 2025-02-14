package id.ac.ui.cs.advpro.eshop.service;

import id.ac.ui.cs.advpro.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product findById(String productId);
    public void updateProduct(Product updatedProduct);
    public Product deleteProduct(String productId);
}
