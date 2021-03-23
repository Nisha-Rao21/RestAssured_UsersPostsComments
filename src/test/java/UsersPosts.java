import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class UsersPosts {
    @Test
    void getUserDetails() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/users");
        //String responseBody=response.getBody().asString();
        //System.out.println("The users are :"+responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("Status code=" + statusCode);
        Assert.assertEquals(statusCode, 200);
        String statusLine = response.getStatusLine();
        System.out.println("Status Line=" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        JsonPath jsonpath = response.jsonPath();
        ArrayList curr = (ArrayList) jsonpath.get("$");
        System.out.println("USERS DETAILS :");
        System.out.println("*******************************************************");
        for (int j = 0; j < curr.size(); j++) {
            LinkedHashMap f = (LinkedHashMap) curr.get(j);
            System.out.println("Id:" + f.get("id"));
            System.out.println("Name:" + f.get("name"));
            System.out.println("User Name:" + f.get("username"));
            LinkedHashMap map = (LinkedHashMap) f.get("address");
            System.out.println("Street:" + map.get("street"));
            System.out.println("Suite:" + map.get("suite"));
            System.out.println("City:" + map.get("city"));
            System.out.println("Zipcode:" + map.get("zipcode"));
            LinkedHashMap map1 = (LinkedHashMap) map.get("geo");
            System.out.println("Latitude:" + map1.get("lat"));
            System.out.println("Longitude:" + map1.get("lng"));
            System.out.println("Phone number:" + f.get("phone"));
            System.out.println("Website:" + f.get("website"));
            LinkedHashMap map2 = (LinkedHashMap) f.get("company");
            System.out.println("Company Name:" + map2.get("name"));
            System.out.println("Catch Phrase:" + map2.get("catchPhrase"));
            System.out.println("BS:" + map2.get("bs"));
            System.out.println("*******************************************************");
        }
    }

    @Test
    void getPostDetails(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/posts");
        //String responseBody=response.getBody().asString();
        //System.out.println("The posts are :"+responseBody);
        int statusCode=response.getStatusCode();
        System.out.println("Status Code="+statusCode);
        Assert.assertEquals(statusCode,200);
        String statusLine=response.getStatusLine();
        System.out.println("Status Line="+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        JsonPath jsonpath=response.jsonPath();
        ArrayList curr=(ArrayList) jsonpath.get("$");
        System.out.println("POSTS: ");
        System.out.println("*******************************************************");
        for(int i=0;i< curr.size();i++)
        {
            System.out.println("User Id:"+jsonpath.getString("userId["+i+"]"));
            System.out.println("Id:"+jsonpath.getString("id["+i+"]"));
            System.out.println("Title:"+jsonpath.getString("title["+i+"]"));
            System.out.println("Body:"+jsonpath.getString("body["+i+"]"));
            System.out.println("************************************************************");

        }

    }

    @Test
    void getComments(int postId){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest= RestAssured.given();
        Response response=httpRequest.basePath("/posts").get("/{postId}/comments",postId);
        //String responseBody=response.getBody().asString();
        //System.out.println("The comments are :"+responseBody);
        int statusCode=response.getStatusCode();
        System.out.println("Status Code="+statusCode);
        Assert.assertEquals(statusCode,200);
        String statusLine=response.getStatusLine();
        System.out.println("Status Line="+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        JsonPath jsonpath=response.jsonPath();
        ArrayList curr=(ArrayList) jsonpath.get("$");
        System.out.println("COMMENTS : ");
        System.out.println("************************************************************");
        for(int i=0;i< curr.size();i++)
        {
            System.out.println("Post Id:"+jsonpath.getString("postId["+i+"]"));
            System.out.println("Id:"+jsonpath.getString("id["+i+"]"));
            System.out.println("Name:"+jsonpath.getString("name["+i+"]"));
            System.out.println("Email:"+jsonpath.getString("email["+i+"]"));
            System.out.println("Body:"+jsonpath.getString("body["+i+"]"));
            System.out.println("************************************************************");
        }
    }
    public static void main(String[] args){
        UsersPosts up=new UsersPosts();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Post Id:");
        int postId=sc.nextInt();
        up.getComments(postId);
    }
}
