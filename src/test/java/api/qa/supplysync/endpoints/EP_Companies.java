package api.qa.supplysync.endpoints;

import api.qa.supplysync.pojos.companies.PJ_Company;
import api.qa.supplysync.utils.APIJsonData;
import api.qa.supplysync.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class EP_Companies {

    // I AM USING FINAL KEYWORD IN MY AUTOMATION TO make variable IMMUTABLE and REUSABLE!
    final String json = "application/json";
    final String contentType = "Content-Type";
    final String authorization = "Authorization";

    public void validateCreateCompaniesData(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createCompany(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Company deserializeResponse = response.as(PJ_Company.class);
        Assert.assertEquals(deserializeResponse.getName(), expectedName);
        Assert.assertEquals(deserializeResponse.getEmail(), expectedEmail);
        Assert.assertEquals(deserializeResponse.getAddress(), expectedAddress);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), expectedPhoneNumber);
    }

    public void validateExistCompanyData(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getName(), expectedName);
        Assert.assertEquals(deserializeResponse.getEmail(), expectedEmail);
        Assert.assertEquals(deserializeResponse.getAddress(), expectedAddress);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), expectedPhoneNumber);
    }

    public void validateUpdateCompanyData(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createCompany(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber))
                .when().put().then().log().body().statusCode(200).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getName(), expectedName);
        Assert.assertEquals(deserializeResponse.getEmail(), expectedEmail);
        Assert.assertEquals(deserializeResponse.getAddress(), expectedAddress);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), expectedPhoneNumber);
    }


    public void validateBlockCompanyData(String expectedBlock) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("block_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getBlocked(), expectedBlock);
    }


    public void validateUnBlockCompanyData(String expectedUnBlock) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("unBlock_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getBlocked(), expectedUnBlock);
    }


    public void validateDeleteCompanyData(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("delete_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getName(), expectedName);
        Assert.assertEquals(deserializeResponse.getEmail(), expectedEmail);
        Assert.assertEquals(deserializeResponse.getAddress(), expectedAddress);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), expectedPhoneNumber);
    }


    public void validateGetCompanyData(String expectedReason, String expectedMessage) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(404).extract().response();
        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        Assert.assertEquals(deserializeResponse.getReason(), expectedReason);
        Assert.assertEquals(deserializeResponse.getMessage(), expectedMessage);
    }


    public void validateGetAllCompanyData(String expectedId) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        for (int i = deserializeResponse.getCompany().size() - 1; i > 0; i--) {
            Assert.assertEquals(expectedId, deserializeResponse.getCompany().get(i).getId());
        }
    }


    public void validateAllCompaniesUnblock(String expectedBlock) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_company");

        Response response = RestAssured.given().header(contentType, json)
                .accept(ContentType.JSON)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Company deserializeResponse = response.as(PJ_Company.class);

        for (int i = deserializeResponse.getCompany().size() - 1; i > 0; i--) {
            Assert.assertEquals(deserializeResponse.getCompany().get(i).getBlocked(), expectedBlock);
        }
    }


}
