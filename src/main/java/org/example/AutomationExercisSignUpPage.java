package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationExercisSignUpPage {
    SHAFT.GUI.WebDriver driver;

    //locators
    private By loginbutton = By.linkText("Signup / Login");
    private By Name = By.name("name");
    private By Email= By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    private By Signupbutton= By.xpath("//button[@data-qa=\"signup-button\"]");

    public AutomationExercisSignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void navigateHomePageUrl(String HomePageUrl){
        driver.browser().navigateToURL(HomePageUrl);
        //  navigateHomePageUrl("https://automationexercise.com/");
    }

    public void ClickonSignupLoginbutton(){

        driver.element().click(loginbutton);
    }

    public void  Enternameandemailaddress(String username , String EmailN) {
        String emailNew = EmailN + System.currentTimeMillis();
        driver.element().click(Name);
        driver.element().type(Name, username);
        driver.element().type(Email, emailNew);
    }
    public void ClickOnSignupButton() {
        driver.element().click(Signupbutton);
    }
}
