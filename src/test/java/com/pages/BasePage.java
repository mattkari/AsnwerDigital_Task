package com.pages;


import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement email;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    public WebElement getGendermale;

    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement mobilNumber;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//label[normalize-space()='Sports']")
    public WebElement hobbiesSport;

    @FindBy(xpath = "//label[normalize-space()='Reading']")
    public WebElement hobbiesReading;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    public WebElement timerAlertButton;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


}