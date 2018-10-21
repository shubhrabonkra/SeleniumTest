package TestScripts;

import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AutomationScriptXero extends ReusableMethods{
	
	
	@Test
	private static void Test1A() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		//logger.log(Status.INFO,"xero page opened");
		
		//String userName=pro.getProperty("username");
		//String passWord=pro.getProperty("password");
		driver.get("https://login.xero.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("shubhrabonkra@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.clear();
		passWord.sendKeys("password123");
		WebElement logInBtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		logInBtn.click();
		//loginToXero(userName,passWord);
		XeroBaseClass.closeDriver();
	}
	
	@Test
	private static void Test1B() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1B");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		//logger.log(Status.INFO,"xero page opened");
		
		WebElement userName=driver.findElement(getLocator("xero.login.username",objPro));
		enterText(userName,"User Name",pro.getProperty("username"));
		WebElement passWord = driver.findElement(getLocator("xero.login.password",objPro));
		passWord.clear();
		enterText(passWord, "Password", pro.getProperty("invalidpassword"));
		WebElement logInBtn = driver.findElement(getLocator("xero.login.loginButton",objPro));
		clickElement(logInBtn, "Login");
		XeroBaseClass.closeDriver();
	}
	
	@Test
	private static void Test1C() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1B");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		//logger.log(Status.INFO,"xero page opened");
		
		WebElement userName=driver.findElement(getLocator("xero.login.username",objPro));
		enterText(userName,"User Name",pro.getProperty("invalidusername"));
		WebElement passWord = driver.findElement(getLocator("xero.login.password",objPro));
		passWord.clear();
		enterText(passWord, "Password", pro.getProperty("password"));
		WebElement logInBtn = driver.findElement(getLocator("xero.login.loginButton",objPro));
		clickElement(logInBtn, "Login");
		XeroBaseClass.closeDriver();
	}
	
	@Test
	private static void Test1D() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1B");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		//logger.log(Status.INFO,"xero page opened");
		
		WebElement forgetPassword = driver.findElement(By.xpath ("//a[@class='forgot-password-advert']"));
		clickElement(forgetPassword, "Login");
		
		WebElement textEmail  = driver.findElement(By.xpath("//input[@id='UserName']"));
		enterText(textEmail,"Enter Email",pro.getProperty("username"));
		
		WebElement sendBtn = driver.findElement(By.xpath("//span[@class='text']"));
		clickElement(sendBtn, "Login");
		
		XeroBaseClass.closeDriver();
	}
	
	
	@Test
	private static void Test2A() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("mainurl"));
		//logger.log(Status.INFO,"xero page opened");
		
		WebElement freeTrial=driver.findElement(By.xpath ("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freeTrial, "Login");
		WebElement firstName = driver.findElement(getLocator("xero.login.firstName",objPro));
		enterText(firstName, "firstName", pro.getProperty("firstname"));
		WebElement lastName = driver.findElement(getLocator("xero.login.lastName",objPro));
		enterText(lastName, "lastname", pro.getProperty("lastname"));
		WebElement email = driver.findElement(getLocator("xero.login.email",objPro));
		enterText(email, "email", pro.getProperty("email"));
		WebElement phnNo = driver.findElement(getLocator("xero.login.phNo",objPro));
		enterText(phnNo, "PhoneNo", pro.getProperty("phone"));
		WebElement countryList = driver.findElement(By.xpath("//select[@name='LocationCode']"));
		enterText(countryList, "countryList", pro.getProperty("country"));
		WebElement chkTerms = driver.findElement(By.xpath(" //input[@value='true']"));
		chkTerms.click();
		WebElement submitBtn = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
	    clickElement(submitBtn, "SubmitBtn");
		XeroBaseClass.closeDriver();
	}

	@Test
	private static void Test2B() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("mainurl"));
		//logger.log(Status.INFO,"xero page opened");
		
		WebElement freeTrial=driver.findElement(By.xpath ("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freeTrial, "Login");
		WebElement email = driver.findElement(getLocator("xero.login.email",objPro));
		enterText(email, "email", pro.getProperty("invalidEmail"));
		WebElement submitBtn = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
	    clickElement(submitBtn, "SubmitButton");
		XeroBaseClass.closeDriver();
	}
	
	@Test
	private static void Test2C() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("mainurl"));
		//logger.log(Status.INFO,"xero page opened");
		String winHandleBefore = driver.getWindowHandle();
		WebElement freeTrial=driver.findElement(By.xpath ("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freeTrial, "FreeTrial");
		WebElement terms = driver.findElement(By.xpath ("//a[contains(text(),'terms of use')]"));
		terms.click();
		//driver.close();
		driver.switchTo().window(winHandleBefore);
		
		WebElement policy = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		policy.click();
		driver.quit();
	}
	
	@Test
	private static void Test2D() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("mainurl"));
		//logger.log(Status.INFO,"xero page opened");
		String winHandleBefore = driver.getWindowHandle();
		WebElement freeTrial=driver.findElement(By.xpath ("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freeTrial, "FreeTrial");
		WebElement offerDetails = driver.findElement(By.xpath ("//a[contains(text(),'offer details')]"));
		offerDetails.click();
		driver.quit();
	}
	
	@Test
	private static void Test2E() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("mainurl"));
		//logger.log(Status.INFO,"xero page opened");
		String winHandleBefore = driver.getWindowHandle();
		WebElement freeTrial=driver.findElement(By.xpath ("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickElement(freeTrial, "FreeTrial");
		WebElement accountant = driver.findElement(By.xpath ("//a[contains(text(),'accountant or bookkeeper')]"));
		accountant.click();
		
		XeroBaseClass.closeDriver();
	}
	
	@Test
	private static void Test3A() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		//logger.log(Status.INFO,"xero page opened");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		loginToXero(username,password);
		WebElement dashBoard=driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"));
		clickElement(dashBoard, "dashBoard");
		WebElement accounts=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/a[1]"));
		clickElement(accounts, "accounts");
		WebElement report=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]"));
		clickElement(report, "report");
		WebElement contact=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[6]/a[1]"));
		clickElement(contact, "contact");
		WebElement setting=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[7]/a[1]"));
		clickElement(setting, "setting");
		//WebElement newTab=driver.findElement(By.xpath("//a[@id='quicklaunchTab']"));
		//clickElement(newTab, "newTab");
		//WebElement filetab=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/li[2]/a[1]"));
		//clickElement(filetab, "filetab");
		//Thread.sleep(4000);
		//WebElement notifications=driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a"));
		//clickElement(notifications,"NotificationsTab");
		/*WebElement searchTab=driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a"));
		clickElement(searchTab,"SearchTab");
		driver.switchTo().frame(3);
		try{
			WebElement SearchTabField=driver.findElement(By.xpath("//*[@id='dropdown-panel']/div[1]/div[1]"));
	        System.out.println("isElementFound SearchTabField: true");

	        }
		 catch(org.openqa.selenium.NoSuchElementException e){
	            System.out.println("isElementFound SearchTabField: false :");
	        }
		driver.switchTo().defaultContent();
		//help .//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a
		
		WebElement helpsTab=driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a"));
		clickElement(helpsTab,"HelpsTab");
		
		//verify help
		Thread.sleep(4000);
		try{
			WebElement helpsTabValue=driver.findElement(By.xpath("//*[@id='rt']/div[1]/h3"));
	        System.out.println("isElementFound helpsTabValue: true");

	        }
		 catch(org.openqa.selenium.NoSuchElementException e){
	            System.out.println("isElementFound helpsTabValue: false :");
	        }*/
		
		XeroBaseClass.closeDriver();
	}
	

	@Test
	private static void Test4A() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("shubhrabonkra@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.clear();
		passWord.sendKeys("password123");
		WebElement logInBtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		logInBtn.click();
		//logger.log(Status.INFO,"xero page opened");
		//String userName=pro.getProperty("username");
		//String passWord=pro.getProperty("password");
		//loginToXero(userName,passWord);
		logOut();
		XeroBaseClass.closeDriver();
		 
	}
	
	@Test
	private static void Test6A() throws Exception
	{
		String propertyPath="./src/test/resources/DataFile/config.properties";
		Properties pro= loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		//createTestScriptReport("Test1A");
		driver = XeroBaseClass.IntializeDriver("firefox");
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("shubhrabonkra@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.clear();
		passWord.sendKeys("password123");
		WebElement logInBtn = driver.findElement(By.xpath("//button[@id='submitButton']"));
		logInBtn.click();
		//logger.log(Status.INFO,"xero page opened");
		//String userName=pro.getProperty("username");
		//String passWord=pro.getProperty("password");
		//loginToXero(userName,passWord);
		goToProfileUploadImg();
		XeroBaseClass.closeDriver();
	}
	
	
}

