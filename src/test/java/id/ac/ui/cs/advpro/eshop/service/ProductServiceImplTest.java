package id.ac.ui.cs.advpro.eshop.service;

import id.ac.ui.cs.advpro.eshop.model.Product;
import id.ac.ui.cs.advpro.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product result = productService.create(product);

        assertEquals(product, result);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    public void testFindAll() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> productList = Arrays.asList(product1, product2);
        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(productList, result);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Product product = new Product();
        when(productRepository.findById("1")).thenReturn(product);

        Product result = productService.findById("1");

        assertEquals(product, result);
        verify(productRepository, times(1)).findById("1");
    }

    @Test
    public void testUpdateProduct() {
        Product updatedProduct = new Product();
        when(productRepository.updateProduct(updatedProduct)).thenReturn(updatedProduct);

        Product result = productService.updateProduct(updatedProduct);

        assertEquals(updatedProduct, result);
        verify(productRepository, times(1)).updateProduct(updatedProduct);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        when(productRepository.deleteProduct("1")).thenReturn(product);

        Product result = productService.deleteProduct("1");

        assertEquals(product, result);
        verify(productRepository, times(1)).deleteProduct("1");
    }
}
