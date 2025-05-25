import Base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTests extends BaseTest {

    @Test(description = "Get - /v2/user - User Info",priority = 2)
    public void GetUserInfo (){
        Get(URL+"/v2/user/ismailAydemir9");
    }

    @Test(description = "Post - /v2/user - User Create",priority = 1)
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

    @Test(description = "PUT - /v2/user/ - Update User", priority = 3)
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


    @Test(description = "Delete - /v2/user/ - Delete User",priority = 4)
    public void DeleteUser(){

        Delete(URL+"/v2/user/ismailAydemir10");
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

    @Test(description = "Get - UserInfoControl")
    public void UserInfoControl(){
        Map<String,Object> headersPayload = new HashMap<>();
        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String,Object> bodyPayload=new HashMap<>();
        bodyPayload.put("id","664852314");
        bodyPayload.put("username","yusufcokal");
        bodyPayload.put("firstName","yusuf");
        bodyPayload.put("lastName","cokal");
        bodyPayload.put("email","yusuf@gmail.com");
        bodyPayload.put("password","Deneme1");
        bodyPayload.put("phone","55547893");
        bodyPayload.put("userStatus","1");

        Post(URL+"/v2/user",bodyPayload,headersPayload);
        Response response = Get(URL +"/v2/user/yusufcokal");

        AssertEquals(response.jsonPath().getString("id"),"664852314");
        AssertEquals(response.jsonPath().getString("username"),"yusufcokal");
        AssertEquals(response.jsonPath().getString("firstName"),"yusuf");
        AssertEquals(response.jsonPath().getString("lastName"),"cokal");
        AssertEquals(response.jsonPath().getString("email"),"yusuf@gmail.com");
        AssertEquals(response.jsonPath().getString("password"),"Deneme1");
        AssertEquals(response.jsonPath().getString("phone"),"55547893");
        AssertEquals(response.jsonPath().getString("userStatus"),"1");
    }
}
