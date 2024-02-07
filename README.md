# Reflection 1

## **_Clean Code Principles_**

### 1. Meaningful Names
Variable dan method names harus deskriptif and mengikuti standard conventions dan memiliki makna yang jelas akan fungsi atau kegunaannya. Contoh penerapan Meaningful Names yang saya lakukan yaitu, createProductPage, createProductPost, findAll, etc.

### 2. Function
Setiap fungsi (methods) memiliki tugasnya masing-masing. Saya mencoba untuk membuat fungsi-fungsinya sesingkat dan sepadat mungkin. Berikut contoh-contohnya:

-  `createProductPage(Model model)`: Fungsi untuk me-render halaman create product, memisahkan antara tampilan halaman dari business logic-nya.

-  `createProductPost(Product product, Model model)`: Fungsi meng-handle HTTP POST request untuk membuat product. Merepresentasi pembuatan product ke bagian service (ProductService).

-  `productListPage(Model model)`: Fungsi me-retrieve semua product dari database dan menampilkannya di halaman product list page.

-  `editProductPage(String productId, Model model)`: Fungsi mengambil product dari ID dan menampilkannya di halaman edit product dengan Name dan Quantity yang telah diisi di form sebelumnya.

-  `editProductPost(String productId, Product updatedProduct)`: Fungsi meng-handle HTTP POST request untuk meng-update product. Merepresentasi update product ke bagian service.

-  `deleteProduct(String productId)`: Fungsi menghapus product berdasarkan ID.

### Comments
Saya berusaha membuat Comment sesingkat dan seinformatif mungkin, berikut salah satu contohnya untuk method update pada productRepository.java

    `/**
     * Update/edit product dari repository berdasarkan Id.
     * Note: Asumsi product ada.
     */`
     
### Objects and Data Structure
Perlu adanya separasi antara objects dan data structures.

-  Objects: Product class berisi pembuatan product ID yang unik dan data (product name, quantity).

-  Data Structures: ProductRepository class berguna untuk menyimpan dan mengakses data product. Ada sekumpulan method seperti Create, Update, dan Delete tanpa mengekspos in-memory list.

### 5. Error Handling
Saya belum menerapkan Error Handling yang terlalu kompleks, namun saya memiliki method findById yang akan me-return null jika product tidak ditemukan.

## **_Secure Code Principles_**

### Pada tutorial 1 exercise 1 belum memerlukan Secure Coding karena belum menerapkan pembuatan akun yang berpotensial dapat diretas.

# Reflection 2

## 1. Unit Test

Sejujurnya, aku merasa canggih. Pada tahun pertama saya mengoding, saya hanya memerdulikan hasil outputnya saja. Namun, sekarang saya diperluas wawasan-nya dan belajar untuk membuat test-test yang berguna untuk fungsionalitas dan jalan programnya agar dapat diintegrasi dengan pondasi yang lebih kokoh.

### a. _How many unit tests should be made in a class?_ 

:    Menurut saya, setiap method memerlukan setidaknya satu unit test. Sehingga banyak unit test bergantung dengan banyaknya method dalam class itu.

### b. _How to make sure that our unit tests are enough to verify our program?_

:    Kita perlu mencoba macam-macam scenario, edge cases, dan kombinasi input. Menulis test case untuk meng-cover positive dan negative scenario, termasuk boundary cases and kondisi error.

### c. _It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?_

:    Menurut saya belum tentu. Bahkan dengan 100% code coverage pun, masih terdapat kemungkinan gap-gap di test coverage, seperti untested error atau environmental dependencies. Code coverage juga tidak menjamin kualitas test-testnya, seperti mendeteksi corner cases.

## 2. Functional Test
