package api.qa.supplysync.stepdefinitions;

import api.qa.supplysync.endpoints.EP_Branches;
import io.cucumber.java.en.Then;

public class SD_Branches {

    EP_Branches branches = new EP_Branches();


    @Then("User validates {string}, {string}, {string}, {string}, {string} and {string} from end-point Post")
    public void user_validates_and(String name, String email, String address, String phone, String regionId, String companyId) {
        branches.createNewBranchData(name, email, address, phone, regionId, companyId);
    }


    @Then("User validates {string}, {string}, {string}, {string} and {string} from end-point Get")
    public void user_validates_and(String region, String companyName, String companyEmail, String companyAddress, String companyNumber) {
        branches.getBranchData(region, companyName, companyEmail, companyAddress, companyNumber);
    }


    @Then("User validates updated {string}, {string}, {string}, {string}, {string} and {string} from end-point Put")
    public void user_validates_updated_and(String name, String email, String address, String phone, String regionId, String companyId) {
        branches.updateBranchData(name, email, address, phone, regionId, companyId);
    }


    @Then("User validates {string} and {string} from end-point Put")
    public void user_validates_and(String block, String companyBlocked) {
        branches.blockBranchData(block, companyBlocked);
    }


    @Then("User validates blocked {string} and {string} from end-point Put")
    public void user_validates_blocked_and(String block, String companyBlocked) {
        branches.unBlockBranchData(block, companyBlocked);
    }


    @Then("User validates deleted {string}, {string}, {string}, {string}, {string} and {string} from end-point Delete")
    public void user_validates_deleted_and(String name, String email, String address, String phone, String regionId, String companyId) {
        branches.deleteBranchData(name, email, address, phone, regionId, companyId);
    }


    @Then("User validates Not Block {string} and {string} from end-point Get")
    public void user_validates_not_block_and_from_end_point_get(String block, String blocked) {
        branches.getAllUnBlockBranchData(block, blocked);
    }


}
