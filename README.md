**Nadya Aysha [2206081635] ProLan B**

_Disclaimer: I wrote my Reflection in English, I hope that is okay :)!_

Link to my Deployed Web (Koyeb) : https://major-sharl-csui-814ce7e9.koyeb.app/

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
