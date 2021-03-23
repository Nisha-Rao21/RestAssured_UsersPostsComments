# API Testing Using RestAssured

1.This project is done using Maven.

2.The testing is done through TestNG.

3.pom.xml file contains all the required dependencies.

4.The API testing is done for : https://jsonplaceholder.typicode.com

5.UsersPosts.java is the code which is present in src/test/java.

6.The code contains 3 functions - getUserDetails(), getPostDetails(), getComments(int postId).

7.getUserDetails() retrieves all the user informations in https://jsonplaceholder.typicode.com/users.

8.getPostDetails() retrieves all the posts present in https://jsonplaceholder.typicode.com/posts.

9.getComments(int postId) retrieves all the comments for the particular postId in https://jsonplaceholder.typicode.com/posts/{postId}/comments.

10.The Testing is done for checking the Status Code and Status Line.

Hope this was helpful 