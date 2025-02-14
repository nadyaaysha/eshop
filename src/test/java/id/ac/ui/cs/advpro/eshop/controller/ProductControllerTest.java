package id.ac.ui.cs.advpro.eshop.controller;

import id.ac.ui.cs.advpro.eshop.model.Product;
import id.ac.ui.cs.advpro.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    public ProductControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
        assertEquals("CreateProduct", viewName);
    }

    @Test
    public void testCreateProductPost() {
        Product product = new Product();
        String viewName = productController.createProductPost(product, model);
        verify(productService, times(1)).create(product);
        assertEquals("redirect:list", viewName);
    }

    @Test
    public void testProductListPage() {
        List<Product> products = new ArrayList<>();
        when(productService.findAll()).thenReturn(products);
        String viewName = productController.productListPage(model);
        verify(productService, times(1)).findAll();
        verify(model, times(1)).addAttribute("products", products);
        assertEquals("ProductList", viewName);
    }

    @Test
    public void testEditProductPage() {
        String productId = "123";
        Product product = new Product();
        when(productService.findById(productId)).thenReturn(product);
        String viewName = productController.editProductPage(productId, model);
        verify(productService, times(1)).findById(productId);
        verify(model, times(1)).addAttribute("product", product);
        assertEquals("EditProduct", viewName);
    }

    @Test
    public void testEditProductPost() {
        Product product = new Product();
        String viewName = productController.editProductPost(product);
        verify(productService, times(1)).updateProduct(product);
        assertEquals("redirect:list", viewName);
    }

    @Test
    public void testDeleteProduct() {
        String productId = "123";
        String viewName = productController.deleteProduct(productId);
        verify(productService, times(1)).deleteProduct(productId);
        assertEquals("redirect:../list", viewName);
    }
}
