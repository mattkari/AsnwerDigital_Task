package com.tasks;

import com.pages.BasePage;
import com.utilities.ConfigurationReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class Task1 extends TestBase {

    BasePage basePage = new BasePage();
    @Test
    public void test1() throws InterruptedException {


        driver.get(ConfigurationReader.get("url") + "/automation-practice-form");
        basePage.firstName.sendKeys("Matt");
        basePage.lastName.sendKeys("Karimov");
        basePage.email.sendKeys("mattkarimov@outlook.com");
        basePage.getGendermale.click();
        basePage.mobilNumber.sendKeys("07803374001");

        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        WebElement month = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        WebElement year = driver.findElement(By.xpath("(//select[@class='react-datepicker__year-select'])"));
        Select select = new Select(month);
        select.selectByIndex(6);
        Select select2 = new Select(year);
        select2.selectByVisibleText("1990");

        WebElement day = driver.findElement(By.xpath("(//div[@tabindex='-1'])[12]"));
        day.click();
        Thread.sleep(3000);

        basePage.hobbiesSport.click();
        basePage.hobbiesReading.click();

        String picture = "/Users/karimov/Documents/Screenshot 2021-03-02 at 22.08.47.png";
        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys(picture);
        driver.findElement(By.xpath("(//textarea[@placeholder='Current Address'])")).sendKeys("20. Mill Chase Close, Wakefield, WF2 9SN");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement dropDown = driver.findElement(By.cssSelector("#state"));
        jse.executeScript("arguments[0].scrollIntoView(true)",dropDown);
        dropDown.click();
        WebElement state = driver.findElement(By.xpath("//*[text()='Uttar Pradesh']"));
        state.click();

        WebElement dropDown2 = driver.findElement(By.xpath("//*[text()='Select City']"));
        dropDown2.click();
        WebElement city2 = driver.findElement(By.xpath("//*[text()='Agra']"));
        city2.click();

        Thread.sleep(3500);
        basePage.submitButton.click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get(ConfigurationReader.get("url") +"/alerts");
        WebDriverWait wait = new WebDriverWait(driver,10);
        basePage.timerAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test
    public void test3() throws InterruptedException {
        driver.get(ConfigurationReader.get("url") + "/tool-tips");
        WebElement button = driver.findElement(By.cssSelector("#toolTipButton"));
        WebElement text = driver.findElement(By.cssSelector("#toolTipTextField"));

        Actions action = new Actions(driver);
        action.moveToElement(button).perform();
        Thread.sleep(800);
        action.moveToElement(text).perform();

    }

    @Test
    public void test4(){

        driver.get(ConfigurationReader.get("url") + "/droppable");
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).perform();

    }

    @Test
    public void test5() throws InterruptedException {
        driver.get(ConfigurationReader.get("url") + "/modal-dialogs");

        driver.findElement(By.cssSelector("#showSmallModal")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement closeSmallModal = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
        wait.until(ExpectedConditions.elementToBeClickable(closeSmallModal));
        closeSmallModal.click();

    }

    @Test
    public void test6(){

        driver.get(ConfigurationReader.get("url") + "/date-picker");

        driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
        WebElement element1 = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select select = new Select(element1);
        select.selectByIndex(3);
        driver.findElement(By.xpath("(//div[@role='option'])[9]")).click();


    }




    }



