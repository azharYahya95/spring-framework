## Spring MVC

1. Developing Spring Controller and View
   1. ### Development process to create Spring Controller and View
      1. Create Controller Class
        - Annotate class from @Controller
        - @Controller inherits from @Component, then it supports scanning
         ```java
            @Controller
            public class HomeController{
            }  
         ```
      2. Define Controller Method
         ```java
         @Controller
         public class HomeController{
            private String showMyPage(){
                //...
            }
         }
         ```
      3. Add Request Mapping to Controller Method
         ```java
         @Controller
         public class HomeController{
            @RequestMapping("/")
            private String showMyPage(){
                //...
            }
         }
         ```
      4. Return View Name
         ```java
         @Controller
         public class HomeController{
            @RequestMapping("/")
             private String showMyPage(){
                return "main-menu";
            }
         }
         ```
         - the full name of view page will become like this ``/WEB-INF/view/main-menu.jsp``
      5. Develop View Page
         File:_/WEB-INF/view/main-menu.jsp_
         ```html
            <html>
                <body>
                    <h2>Spring MVC DEMO - Home Page</h2>
                </body>
            </html>
         ```
    2. 