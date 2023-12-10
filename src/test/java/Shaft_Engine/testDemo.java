package Shaft_Engine;

import com.shaft.driver.SHAFT;
//import engine.DriverFactory;
//import engine.JsonFileManager;
//import engine.PropertiesReader;
import org.example.AutomationExercisSignUpPage;
import org.example.AutomationExerciseInfoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testDemo {

    SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();
   // SHAFT.TestData.JSON testData;
    private org.example.AutomationExercisSignUpPage AutomationExercisSignUpPage;
    private org.example.AutomationExerciseInfoPage AutomationExerciseInfoPage;
    //JsonFileManager testData;
   // engine.testProperties testProperties ;
     //    @BeforeClass
         /**public void beforeClass(){
             engine.testProperties testProperties = new engine.testProperties(driver);
             PropertiesReader.loadProperties();
             testProperties.initDriver();
             AutomationExercisSignUpPage = new org.example.AutomationExercisSignUpPage(driver);
             AutomationExerciseInfoPage = new org.example.AutomationExerciseInfoPage(driver);
        }*/
        @BeforeMethod
        public void openUrl () {
//            testProperties = new engine.testProperties(driver);
           // PropertiesReader.loadProperties();
           // driver = DriverFactory.initDriver();
            AutomationExercisSignUpPage = new AutomationExercisSignUpPage(driver);
            AutomationExerciseInfoPage = new AutomationExerciseInfoPage(driver);
            //driver.navigate().to("https://www.google.com.eg/?hl=ar");
           AutomationExercisSignUpPage.navigateHomePageUrl("https://automationexercise.com/");
        }


        @Test
        public void register1 () {
            AutomationExercisSignUpPage.ClickonSignupLoginbutton();
            AutomationExercisSignUpPage.Enternameandemailaddress("SayedMuhammad", "ssayedmsuhammad@gmail.com");
            AutomationExercisSignUpPage.ClickOnSignupButton();
            AutomationExerciseInfoPage.assertOnValidationMsg("ENTER ACCOUNT INFORMATION");
            AutomationExerciseInfoPage.FullInformationDetails("123654879",
                    "26", "April", "1998");
            AutomationExerciseInfoPage.SelectCheckboxSignup();
            AutomationExerciseInfoPage.SelectCheckboxReceivespecialoffers();
            AutomationExerciseInfoPage.FillUserDetails("Sayed", "Muhammad",
                    "GizaSystems",
                    "Cairo", "Cairo",
                    "United States",
                    "Khalifa", "ElMokattam", "11311",
                    "0115584848");
            AutomationExerciseInfoPage.ClickCreateAccountbutton();
            AutomationExerciseInfoPage.AssertSuccessMsg("ACCOUNT CREATED!");

        }

        @AfterMethod
        public void closeBrowser () {
            driver.quit();
        }


    }

    /*
    WebDriver driver;
    By loginButton = By.linkText("Signup / Login");
    By Name = By.name("name");
    By Email= By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    By SignupButton= By.xpath("//button[@data-qa=\"signup-button\"]");
    By ValidationMessage= By.xpath("//b[contains(text(),'Enter Account Information')]");
    By GenderType= By.id("id_gender1");
    By password= By.id("password");
    By days= By.id("days");
    By months= By.id("months");
    By years= By.id("years");
    By newsletterCheckbox=By.id("newsletter");
    By checkboxReceiveSpecialOffers=By.id("optin");
    By FirstName= By.id("first_name");
    By LastName= By.id("last_name");
    By CompanyName= By.id("company");
    By Address1= By.name("address1");
    By Address2= By.name("address2");
    By Country= By.name("country");
    By State= By.id("state");
    By City= By.id("city");
    By ZipCode= By.id("zipcode");
    By MobileNumber= By.id("mobile_number");
    By CreateAccountButton= By.xpath("//button[@data-qa=\"create-account\"]");
    By SucMsg= By.xpath("//b[contains(text(),'Account Created!')]");

    @BeforeMethod
    public void openUrl() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        navigateHomePageUrl("https://automationexercise.com/");
    }

    @Test
    public void register1() {
        ClickOnSignupLoginButton();
        EnterNameAndEmailAddress("Siko","Aboelseed@gmail.com");
        ClickOnSignupButton();
        assertOnValidationMsg("ENTER ACCOUNT INFORMATION");
        FullInformationDetails("123654879",
                "26", "April", "1998");
        SelectCheckboxSignup();
        SelectCheckboxReceiveSpecialOffers();
        FillUserDetails("Sayed", "Muhammad",
                "GizaSystems",
                "Cairo", "Cairo",
                "Canada",
                "Boston","ElMokattam","11311",
                "0147863835");
        ClickCreateAccountButton();
        AssertSuccessMsg("ACCOUNT CREATED!");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateHomePageUrl(String HomePageUrl){

        driver.navigate().to(HomePageUrl);
    }
    public void ClickOnSignupLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void  EnterNameAndEmailAddress(String username , String EmailN) {
        driver.findElement(Name).click();
        driver.findElement(Name).sendKeys(username);
        driver.findElement(Email).sendKeys(EmailN);
    }
    public void ClickOnSignupButton() {
        driver.findElement(SignupButton).click();
    }
    public void assertOnValidationMsg(String ValidationMsg) {
        String Account = driver.findElement(ValidationMessage).getText();
        Assert.assertTrue(Account.contains(ValidationMsg));

    }
    public void FullInformationDetails(String PleaseEnterYourPassword, String ChooseYourBirthday , String ChooseBirthMonth , String ChooseBirthYear){
        driver.findElement(GenderType).click();
        driver.findElement(password).sendKeys(PleaseEnterYourPassword);
        Select drpCountry = new Select(driver.findElement(days));
        drpCountry.selectByVisibleText(ChooseYourBirthday);
        Select drpCo = new Select(driver.findElement(months));
        drpCo.selectByVisibleText(ChooseBirthMonth);
        Select drpCou = new Select(driver.findElement(years));
        drpCou.selectByVisibleText(ChooseBirthYear);
    }

    public void SelectCheckboxSignup(){
        driver.findElement(newsletterCheckbox).click();

    }
    public void SelectCheckboxReceiveSpecialOffers(){
        driver.findElement(checkboxReceiveSpecialOffers).click();

    }

    public void FillUserDetails(String First_Name, String last_name , String Company ,String address1, String address2 , String country , String state, String city , String zipcode , String mobileNumber){

        driver.findElement(FirstName).sendKeys(First_Name);
        driver.findElement(LastName).sendKeys(last_name);
        driver.findElement(CompanyName).sendKeys(Company);
        driver.findElement(Address1).sendKeys(address1);
        driver.findElement(Address2).sendKeys(address2);
        Select drpCoo = new Select(driver.findElement(Country));
        drpCoo.selectByVisibleText(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(City).sendKeys(city);
        driver.findElement(ZipCode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(mobileNumber);


    }
    public void ClickCreateAccountButton(){
        driver.findElement(CreateAccountButton).click();

    }
    public void AssertSuccessMsg(String Msg) {

        String Suc = driver.findElement(SucMsg).getText();
        Assert.assertTrue(Suc.contains(Msg));
    }
}
*/
/* @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
    }
    @BeforeClass
    public void beforeClass(){



public class testNgSteps {
    WebDriver driver;


    By loginButton = By.linkText("Signup / Login");
    By Name = By.name("name");
    By Email= By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]");
    By SignupButton= By.xpath("//button[@data-qa=\"signup-button\"]");
    By ValidationMessage= By.xpath("//b[contains(text(),'Enter Account Information')]");
    By GenderType= By.id("id_gender1");
    By password= By.id("password");
    By days= By.id("days");
    By months= By.id("months");
    By years= By.id("years");
    By newsletterCheckbox=By.id("newsletter");
    By checkboxReceiveSpecialOffers=By.id("optin");
    By FirstName= By.id("first_name");
    By LastName= By.id("last_name");
    By CompanyName= By.id("company");
     By Address1= By.name("address1");
    By Address2= By.name("address2");
    By Country= By.name("country");
    By State= By.id("state");
    By City= By.id("city");
    By ZipCode= By.id("zipcode");
    By MobileNumber= By.id("mobile_number");
    By CreateAccountButton= By.xpath("//button[@data-qa=\"create-account\"]");
    By SucMsg= By.xpath("//b[contains(text(),'Account Created!')]");


    @BeforeMethod
    public void openUrl() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        navigateHomePageUrl("https://automationexercise.com/");
    }

driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("name")).sendKeys("Sayed");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("sayedd@gmai.co", Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("name")).sendKeys("Sayed Muhammad");
        driver.findElement(By.id("password")).sendKeys("Messi2012");
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[27]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[25]")).click();
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Sayed");
        driver.findElement(By.id("last_name")).sendKeys("Muhammad");
        driver.findElement(By.id("company")).sendKeys("Giza Systems");
        driver.findElement(By.id("address1")).sendKeys("El Mokattam");
        driver.findElement(By.id("address2")).sendKeys("Maadi");
        driver.findElement(By.xpath("//*[@id=\"country\"]/option[3]")).click();
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("zipcode")).sendKeys("11311");
        driver.findElement(By.id("mobile_number")).sendKeys("01148736385", Keys.ENTER);

    @Test
    public void register1() {
        ClickOnSignupLoginButton();
        EnterNameAndEmailAddress("Abdelraahman","foodAa52@gmail.com");
        ClickOnSignupButton();
        assertOnValidationMsg("ENTER ACCOUNT INFORMATION");
        FullInformationDetails("55454454545",
                       "19", "March", "2020");
        SelectCheckboxSignup();
        SelectCheckboxReceiveSpecialOffers();
        FillUserDetails("Abdelrahman", "Foda",
                        "GizaSystems",
                        "Cairo", "Cairo",
                        "United States",
                        "www","nasrcity","818",
                        "0115584848");
        ClickCreateAccountButton();
        AssertSuccessMsg("ACCOUNT CREATED!");

    }

   @AfterMethod
public void closeBrowser() {
     driver.quit();
  }
    public void navigateHomePageUrl(String HomePageUrl){

        driver.navigate().to(HomePageUrl);
    }
    public void ClickOnSignupLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void  EnterNameAndEmailAddress(String username , String EmailN) {
        driver.findElement(Name).click();
        driver.findElement(Name).sendKeys(username);
        driver.findElement(Email).sendKeys(EmailN);
    }
    public void ClickOnSignupButton() {
        driver.findElement(SignupButton).click();
    }
    public void assertOnValidationMsg(String ValidationMsg) {
        String Account = driver.findElement(ValidationMessage).getText();
        Assert.assertTrue(Account.contains(ValidationMsg));

    }
    public void FullInformationDetails(String PleaseEnterYourPassword, String ChooseYourBirthday , String ChooseBirthMonth , String ChooseBirthYear){
        driver.findElement(GenderType).click();
        driver.findElement(password).sendKeys(PleaseEnterYourPassword);
        Select drpCountry = new Select(driver.findElement(days));
        drpCountry.selectByVisibleText(ChooseYourBirthday);
        Select drpCo = new Select(driver.findElement(months));
        drpCo.selectByVisibleText(ChooseBirthMonth);
        Select drpCou = new Select(driver.findElement(years));
        drpCou.selectByVisibleText(ChooseBirthYear);
    }

    public void SelectCheckboxSignup(){
        driver.findElement(newsletterCheckbox).click();

    }
    public void SelectCheckboxReceiveSpecialOffers(){
        driver.findElement(checkboxReceiveSpecialOffers).click();

    }

    public void FillUserDetails(String First_Name, String last_name , String Company ,String address1, String address2 , String country , String state, String city , String zipcode , String mobilenumber){

        driver.findElement(FirstName).sendKeys(First_Name);
        driver.findElement(LastName).sendKeys(last_name);
        driver.findElement(CompanyName).sendKeys(Company);
        driver.findElement(Address1).sendKeys(address1);
        driver.findElement(Address2).sendKeys(address2);
        Select drpCoo = new Select(driver.findElement(Country));
        drpCoo.selectByVisibleText(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(City).sendKeys(city);
        driver.findElement(ZipCode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(mobileNumber);


    }
    public void ClickCreateAccountButton(){
        driver.findElement(CreateAccountButton).click();

    }
    public void AssertSuccessMsg(String Msg) {

        String Suc = driver.findElement(SucMsg).getText();
        Assert.assertTrue(Suc.contains(Msg));
    }
}
    }*/