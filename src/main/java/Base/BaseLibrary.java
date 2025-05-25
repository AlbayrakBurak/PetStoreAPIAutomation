package Base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class BaseLibrary extends Data {

    @Step("{urlPath} GET Istegi gönderilir")
    public Response Get(String urlPath) {
        Response response =  RestAssured.get(urlPath);
        System.out.println( "Response:" + response.getBody().asString());
        return response;
    }

    @Step("{urlPath} POST Istegi gönderilir")
    public Response Post(String urlPath, Map<String, Object> bodyPayload, Map<String, Object> headersPayload) {
        Response response  = RestAssured.given().body(bodyPayload).headers(headersPayload).when().post(urlPath);
        System.out.println( "Response:" + response.getBody().asString());
        return response;
    }

    @Step("{urlPath} PUT Istegi gönderilir")
    public Response Put(String urlPath, Map<String, Object> bodyPayload, Map<String, Object> headersPayload) {
        Response response =  RestAssured.given().body(bodyPayload).headers(headersPayload).when().put(urlPath);
        System.out.println( "Response:" + response.getBody().asString());
        return response;
    }

    @Step("{urlPath} DELETE Istegi gönderilir")
    public Response Delete(String urlPath) {
       Response response = RestAssured.delete(urlPath);
        System.out.println( "Response:" + response.getBody().asString());
        return response;
    }

    @Step("{urlPath} GET Istegi gönderilir")
    public Response Get(String urlPath, Map<String, Object> queryParamsPayload) {
        Response response = RestAssured.given().queryParams(queryParamsPayload).when().get(urlPath);
        System.out.println( "Response:" + response.getBody().asString());
        return response;
    }

    @Step("assert kontrolu saglanır")
    public void AssertEquals(String actual,String expected)
    {
        Assert.assertEquals(actual,expected);
    }
}
