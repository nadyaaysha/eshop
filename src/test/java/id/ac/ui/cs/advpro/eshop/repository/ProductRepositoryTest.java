package id.ac.ui.cs.advpro.eshop.repository;

import id.ac.ui.cs.advpro.eshop.model.Product;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindByIdProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product productFound = productRepository.findById(product.getProductId());
        assertEquals(product.getProductId(), productFound.getProductId());
        assertEquals(product.getProductName(), productFound.getProductName());
        assertEquals(product.getProductQuantity(), productFound.getProductQuantity());
    }

    @Test
    void testFindByIdProductIfNotFound() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product createdProduct = productRepository.create(product);

        Product productUpdated = new Product();
        productUpdated.setProductId(createdProduct.getProductId());
        productUpdated.setProductName("Sampo Cap Budi");
        productUpdated.setProductQuantity(200);
        productRepository.updateProduct(productUpdated);

        Product editedProduct = productRepository.findById(createdProduct.getProductId());
        assertNotNull(editedProduct);
        assertEquals("Sampo Cap Budi", editedProduct.getProductName());
        assertEquals(200, editedProduct.getProductQuantity());
    }

    @Test
    void testEditProductIfQuantityPositive() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product createdProduct = productRepository.create(product);

        Product productFindById = productRepository.findById(createdProduct.getProductId());
        assertEquals(createdProduct.getProductId(), productFindById.getProductId());
        assertEquals(createdProduct.getProductName(), productFindById.getProductName());
        assertEquals(createdProduct.getProductQuantity(), productFindById.getProductQuantity());

        Product productUpdated = new Product();
        productUpdated.setProductId(createdProduct.getProductId());
        productUpdated.setProductName("Sampo Cap Budi");
        productUpdated.setProductQuantity(50);
        productRepository.updateProduct(productUpdated);

        Product editedProduct = productRepository.findById(productUpdated.getProductId());
        assertEquals(productUpdated.getProductId(), editedProduct.getProductId());
        assertEquals("Sampo Cap Budi", editedProduct.getProductName());
        assertEquals(50, editedProduct.getProductQuantity());
    }

    @Test
    void testEditProductIfQuantityNegative() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product createdProduct = productRepository.create(product);

        Product productFindById = productRepository.findById(createdProduct.getProductId());
        assertEquals(createdProduct.getProductId(), productFindById.getProductId());
        assertEquals(createdProduct.getProductName(), productFindById.getProductName());
        assertEquals(createdProduct.getProductQuantity(), productFindById.getProductQuantity());

        Product productUpdated = new Product();
        productUpdated.setProductId(createdProduct.getProductId());
        productUpdated.setProductName("Sampo Cap Budi");
        productUpdated.setProductQuantity(-50);
        productRepository.updateProduct(productUpdated);

        Product editedProduct = productRepository.findById(productUpdated.getProductId());
        assertEquals(productUpdated.getProductId(), editedProduct.getProductId());
        assertEquals("Sampo Cap Budi", editedProduct.getProductName());
        assertEquals(0, editedProduct.getProductQuantity());
    }

    @Test
    void testEditProductIfProductNotFound() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Product createdProduct = productRepository.create(product);
    }

    @Test
    void testEditProductWithNonValidId() {
        Product productUpdated = new Product();
        productUpdated.setProductId("non-existent-id");
        productUpdated.setProductName("Sampo Cap Budi");
        productUpdated.setProductQuantity(50);

        productRepository.updateProduct(productUpdated);

        Product editedProduct = productRepository.findById("non-existent-id");
        assertNull(editedProduct);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product productDeleted = productRepository.findById(product.getProductId());
        assertEquals(product.getProductId(), productDeleted.getProductId());
        assertEquals(product.getProductName(), productDeleted.getProductName());
        assertEquals(product.getProductQuantity(), productDeleted.getProductQuantity());
    }
}