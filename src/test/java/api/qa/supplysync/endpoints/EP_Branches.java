package api.qa.supplysync.endpoints;

import api.qa.supplysync.pojos.branches.PJ_Branches;
import api.qa.supplysync.utils.APIJsonData;
import api.qa.supplysync.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;

public class EP_Branches {

    final String json = "application/json";
    final String contentType = "Content-Type";
    final String accept = "Accept";
    final String authorization = "Authorization";

    public void createNewBranchData(String name, String email, String address, String number, String regionId, String companyId) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("create_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createBranch(name, email, address, number, regionId, companyId))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);
    }

    public void getBranchData(String region, String companyName, String companyEmail, String companyAddress, String companyNumber) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getRegion().getRegion(), region);
        Assert.assertEquals(deserializeResponse.getCompany().getName(), companyName);
        Assert.assertEquals(deserializeResponse.getCompany().getEmail(), companyEmail);
        Assert.assertEquals(deserializeResponse.getCompany().getAddress(), companyAddress);
        Assert.assertEquals(deserializeResponse.getCompany().getPhoneNumber(), companyNumber);
    }

    public void updateBranchData(String name, String email, String address, String number, String regionId, String companyId) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createBranch(name, email, address, number, regionId, companyId))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);
    }

    public void blockBranchData(String block, String companyBlocked) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("block_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getBlock(), block);
        Assert.assertEquals(deserializeResponse.getCompany().getBlocked(), companyBlocked);
    }

    public void unBlockBranchData(String block, String companyBlocked) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("unBlock_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getBlock(), block);
        Assert.assertEquals(deserializeResponse.getCompany().getBlocked(), companyBlocked);
    }


    public void deleteBranchData(String name, String email, String address, String number, String regionId, String companyId) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);
    }


    public void getAllUnBlockBranchData(String block, String companyBlocked) {
        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("notBlock_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        //Merged Pojo with TypeRef! to store my pojo into list of all Json objects.
        List<PJ_Branches> deserialization = response.as(new TypeRef<List<PJ_Branches>>() {});
        for (PJ_Branches pjBranches : deserialization) {
            Assert.assertEquals(pjBranches.getBlock(), block);
            Assert.assertEquals(pjBranches.getCompany().getBlocked(), companyBlocked);
        }
    }


}
