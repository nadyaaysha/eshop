package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    /**
    Cari Id, return null jika tidak ada
     */
    public Product findById(String productId) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    /**
     * Update/edit product dari repository berdasarkan Id.
     * Note: Asumsi product ada.
     */
    public void update(String productId, Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product product = productData.get(i);
            if (product.getProductId().equals(productId)) {
                product.setProductName(updatedProduct.getProductName());
                product.setProductQuantity(updatedProduct.getProductQuantity());
                break;
            }
        }
    }

    /**
     * Delete product dari repository berdasarkan Id.
     * Note: Asumsi product ada.
     */
    public void delete(String productId) {
        Product product = findById(productId);
        productData.remove(product);
    }
}