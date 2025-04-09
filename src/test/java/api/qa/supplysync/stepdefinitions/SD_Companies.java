package api.qa.supplysync.stepdefinitions;

import api.qa.supplysync.endpoints.EP_Companies;
import io.cucumber.java.en.Then;

public class SD_Companies {

    EP_Companies companies = new EP_Companies();


    @Then("User validates {string}, {string}, {string} and {string} from end-point Post")
    public void user_validates_and_from_end_point(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        companies.validateCreateCompaniesData(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber);
    }


    @Then("User validates {string}, {string}, {string} and {string} from end-point Get")
    public void user_validates_and_from_end_point_get(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        companies.validateExistCompanyData(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber);
    }


    @Then("User validates {string}, {string}, {string} and {string} from end-point Put")
    public void user_validates_and_from_end_point_put(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        companies.validateUpdateCompanyData(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber);
    }


    @Then("User validates {string} from end-point Put-Block")
    public void user_validates_from_end_point_put_block(String expectedBlock) {
        companies.validateBlockCompanyData(expectedBlock);
    }


    @Then("User validates {string} from end-point Put-UnBlock")
    public void user_validates_from_end_point_put_un_block(String expectedUnBlock) {
        companies.validateUnBlockCompanyData(expectedUnBlock);
    }


    @Then("User validates {string}, {string}, {string} and {string} from end-point Delete")
    public void user_validates_and_from_end_point_delete(String expectedName, String expectedEmail, String expectedAddress, String expectedPhoneNumber) {
        companies.validateDeleteCompanyData(expectedName, expectedEmail, expectedAddress, expectedPhoneNumber);
    }


    @Then("User validates {string} and {string} from end-point Get")
    public void user_validates_and_from_end_point_get(String expectedReason, String expectedMessage) {
        companies.validateGetCompanyData(expectedReason, expectedMessage);
    }


    @Then("User validates id {string} from end-point Get")
    public void user_validates_id_from_end_point_get(String expectedID) {
        companies.validateGetAllCompanyData(expectedID);
    }


    @Then("User validates blocked {string} from end-point Get")
    public void user_validates_blocked_from_end_point_get(String expectedBlock) {
      companies.validateAllCompaniesUnblock(expectedBlock);
    }

}
