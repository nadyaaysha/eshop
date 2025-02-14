package id.ac.ui.cs.advpro.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createProduct_isSuccessful(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        driver.executeScript("document.getElementById('nameInput').value='Test Product'");
        driver.executeScript("document.getElementById('quantityInput').value='10'");
        driver.executeScript("document.querySelector('button[type=submit]').click()");

        driver.get(baseUrl + "/product/list");
        boolean productExists = (boolean) driver.executeScript(
                "return Array.from(document.querySelectorAll('td')).some(td => td.innerText.includes('Test Product'));");

        assertTrue(productExists);
    }
}