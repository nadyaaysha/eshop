**Nadya Aysha [2206081635] ProLan B**

_Disclaimer: I wrote my Reflection in English, I hope that is okay :)!_

Link to my Deployed Web (Koyeb) : https://major-sharl-csui-814ce7e9.koyeb.app/

# Modul 3

Here are the SOLID Principles I've applied to my project. The advantages of applying them and disadvantages of not, complete with examples.

- **SRP**

    I've seperated each class to only have one purpose each, CarRepository for handling data persistence, CarServiceImpl for handling business logic, and CarController for handling HTTP requests. The advantage of this is, code will be easier to maintain and modify. Without SRP, imagine CarServiceImpl handling both business logic and HTTP requests. If I changed how the service validates car data, I'd be at risk breaking the controller too, making debugging harder (For Me).

- **OCP**

    I've applied OCP in CarService because entities should be open for extension but closed for modification. The advantage is I can add new features without modifying existing code. Without OCP, if I directly modified CarServiceImpl to add caching, every change would risk breaking existing functionality.

- **LSP**

    I've applied LSP because derived classes should be substitutable for their base classes. I fixed this by seperating CarController because it should not extend ProductController unless ProductController provides common logic related to all products. The advantageof this is I can replace derived classes without breaking the system. Without it, if ProductController had methods that did not apply to cars, CarController would inherit unnecessary methods, leading to unexpected behavior.

- **ISP**

    I've applied ISP by creating a seperate interface (CarService) and deleting unnecessary public modifiers. The clear advantage of this is that clients (classes) only depend on the methods they need. Without ISP, if CarService had too many methods, classes implementing it would have empty or useless method implementations.

- **DIP**
    
    I've applied this by implementing CarServiceImpl to depend on CarService interface rather than being its own concrete class. The advantage of this is, high-level modules don’t depend on low-level modules. Without it, changing the database would require modifying multiple files, increasing the risk of bugs.

# Modul 2

1. I removed unnecessary public modifiers in ProductService.

_Before_

![image](https://github.com/user-attachments/assets/3aec65de-8223-4570-a054-5eb7613a4f97)

_After_

![image](https://github.com/user-attachments/assets/c06177cc-eca1-40d2-b7b2-aa6e50b5d95d)

2. For this module, I've implemented and improved tests and code coverage and not to mention workflows for deployment. I've done the tutorial to automatically do an action everytime there's a push from local. I've also successfully deployed my simple website with Koyeb. So everytime there is changes commited, the website is auto-deployed without any manual checking. 

# Modul 1

### Exercise 1
For this module, I've applied descriptive and meaningful names for various variable, methods, and classes. I've also designed each classes and methods to handle a single responsibility. For example, the ProductService class manages product-related concerns and ProductController handles HTTP requests. I've done proper use of Spring Annotations like @Controller, @Test, and such to appropriately separate concerns. To be honest, I was stuck on the Delete Product feature for a while. I didn't understood why it didn't work. I knew that the source of the problem was that there was some hidden methods like DELETE that didn't went through but eventually I managed to fixed it on the HTML file of ListProduct.

### Exercise 2
1. To be perfectly honest, I feel a little tired, HAHA. See, I didn't know how much tests I needed so I just wrote however many I think it needs. I'm pretty sure I've covered the basics, though. I think how many unit tests should depend on how many methods are implemented, at least. And more-so if the methods can have many different outputs. Then a programmer should cover however many cases they believe they need. To make sure our unit tests are enough, I think we could also get an outsider opinion on our tests. Because someone who have little knowledge of our code can sometimes give an insightful opinion on it. But I'm sure there are programs that can judge how much is "enough" tests for our project. I think I might learn code coverage after this!
2. In my opinion, if there was new functional test that kind of is the same like another functional test, then it will appear like there were a lot of duplications on our test. I don't think it will look clean at all and perhaps even reduce the code quality. It will not be reusable too. My suggestion for improvement, perhaps build a Base Test class that can contain the variables and methods needed that are reusable. It will surely reduce unnecessary duplication of codes.
