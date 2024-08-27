package org.example.AcceptanceTest;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tt.ReportManager;

import tt.MyTest;


public class MonitoringandReporting {

    private ReportManager reportManager = new ReportManager();
    private String userRole;
    private String selectedStore;
    private String startDate;
    private String endDate;
    private String selectedCity;
    public MyTest obj;


    public MonitoringandReporting(MyTest iobj) {
        super();
        this.obj = iobj;


    }

    @When("I generate a financial report")
    public void iGenerateAFinancialReport() {

    }

    @Then("I should see the total profits")
    public void iShouldSeeTheTotalProfits() {

    }

    @When("I request a report of best-selling products")
    public void iRequestAReportOfBestSellingProducts() {

    }

    @Then("I should see the list of best-selling products in each store")
    public void iShouldSeeTheListOfBestSellingProductsInEachStore() {

    }

    @Then("the quantity sold for each product should be displayed")
    public void theQuantitySoldForEachProductShouldBeDisplayed() {

    }

    @When("I request statistics on registered users by city")
    public void iRequestStatisticsOnRegisteredUsersByCity() {

    }

    @Then("I should see the number of registered users in each city")
    public void iShouldSeeTheNumberOfRegisteredUsersInEachCity() {
    }
}