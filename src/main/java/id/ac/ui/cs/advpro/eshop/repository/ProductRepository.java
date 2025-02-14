package id.ac.ui.cs.advpro.eshop.repository;

import id.ac.ui.cs.advpro.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(java.util.UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct(Product updatedProduct) {
        for (Product product : productData) {
            if (product.getProductId().equals(updatedProduct.getProductId())) {
                if (updatedProduct.getProductQuantity() <= 0) {
                    updatedProduct.setProductQuantity(0);
                }
                product.setProductName(updatedProduct.getProductName());
                product.setProductQuantity(updatedProduct.getProductQuantity());
            }
        }
        return updatedProduct;
    }

    public Product deleteProduct(String productId) {
        Product deletedProduct = findById(productId);
        if (deletedProduct != null) {
            productData.remove(deletedProduct);
        }
        return deletedProduct;
    }
}
