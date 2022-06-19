package com.odeza.step_definitions;

import com.odeza.pages.HomePage;
import com.odeza.utilities.ConfigurationReader;
import com.odeza.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OdezaHomepageVerification {

    HomePage homePage = new HomePage();

    @When("user is on Odeza homepage")
    public void user_is_on_odeza_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("odezaURL"));

    }

    @Then("user sees Odeza in the URL")
    public void user_sees_odeza_in_the_URL() {

        String expectedURL = "https://odeza.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals("FAIL - HomePage URL does not contain Odeza", expectedURL, actualURL);

    }


    @When("user navigates to the Solutions tab")
    public void user_navigates_to_the_solutions_menu() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.solutionTab).perform();

        System.out.println("Navigation to the Solutions tab is done");

    }

    @When("user clicks Appointment Autofill from the drop-down menu")
    public void user_clicks_appointment_autofill_from_the_drop_down_menu() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.appointmentAutoFillTab)).click();

        System.out.println("Navigation to an Appointment Autofill is done");

    }

    @Then("user sees Appointment Autofill in the URL")
    public void user_sees_appointment_autofill_in_the_URL() {

        String expectedURL = "https://odeza.com/platform/#appointment-autofill";
        String actualURL = Driver.getDriver().getCurrentUrl();
        System.out.println("actualURL = " + actualURL);

        Assert.assertEquals("User does not see Appointment Autofill page", expectedURL, actualURL);

    }

    @When("user navigates to Contact in the footer")
    public void user_navigates_to_contact_in_the_footer() {


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,750)");

            System.out.println("Navigation to Contact in the footer is done");
        }

    }

    @Then("users should see address presented in the page")
    public void users_should_see_address_presented_in_the_page() {


        String expectedAddress = "117 N. Jefferson St., Ste. 306\nChicago, IL 60661";
        String actualAddress = homePage.addressInContactFooter.getText();

        Assert.assertEquals("User does not see correct address at the Contact", expectedAddress, actualAddress);

    }

}
