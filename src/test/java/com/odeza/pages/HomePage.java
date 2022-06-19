package com.odeza.pages;

import com.odeza.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public HomePage(){

     PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(xpath = "//span[text()='SOLUTIONS']")
    public WebElement solutionTab;

    @FindBy(xpath = "//span[contains(text(), 'Appointment Autofill')]")
    public WebElement appointmentAutoFillTab;

    @FindBy(xpath = "//a[text()='117 N. Jefferson St., Ste. 306']")
    public WebElement addressInContactFooter;
}
