import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTests extends BaseTest {

    @Test(description = "Get - /v2/user - User Info", dependsOnMethods = "CreateUser")
    public void GetUserInfo (){
        Get(URL+"/v2/user/ismailAydemir9");
    }

    @Test(description = "Post - /v2/user - User Create")
    public void CreateUser(){
        Map<String,Object> headersPayload = new HashMap<>();
        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String,Object> bodyPayload=new HashMap<>();
        bodyPayload.put("id","123444468888");
        bodyPayload.put("username","ismailAydemir9");
        bodyPayload.put("firstName","Alice");
        bodyPayload.put("lastName","aydemir2");
        bodyPayload.put("email","ismailaydemir2@gmail.com");
        bodyPayload.put("password","Deneme1");
        bodyPayload.put("phone","null");
        bodyPayload.put("userStatus","1");

        Post(URL+"/v2/user",bodyPayload,headersPayload);
    }

    @Test(description = "PUT - /v2/user/ - Update User", dependsOnMethods = "CreateUser")
    public  void UpdateUser(){
        Map<String,Object> headersPayload = new HashMap<>();
        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String,Object> bodyPayload=new HashMap<>();
        bodyPayload.put("id","123444468888");
        bodyPayload.put("username","ismailAydemir10");
        bodyPayload.put("firstName","Alice");
        bodyPayload.put("lastName","aydemir2");
        bodyPayload.put("email","ismailaydemir2@gmail.com");
        bodyPayload.put("password","Deneme1");
        bodyPayload.put("phone","null");
        bodyPayload.put("userStatus","1");

        Put(URL+"/v2/user/ismailAydemir9",bodyPayload,headersPayload);
    }

    @Test(description = "Delete - /v2/user/ - Delete User",dependsOnMethods = "CreateUser")
    public void DeleteUser(){

        Delete(URL+"/v2/user/ismailAydemir9");

    }

    @Test(description = "Get - /v2/user/login - Login")
    public void Login(){

        Map<String,Object> queryParamsPayload = new HashMap<>();
        queryParamsPayload.put("username","ismailAydemirrrrr");
        queryParamsPayload.put("password","ddd");

        Get(URL+"/v2/user/login",queryParamsPayload);
    }

    @Test(description = "Get - /v2/user/logout - Logout")
    public void Logout(){

        Get(URL+"/v2/user/logout");
    }
}
