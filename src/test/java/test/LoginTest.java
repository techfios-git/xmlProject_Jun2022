package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"userName", "password", "dashboardHeaderText"})
	public void validUserShouldBeAbleToLogin(String userName, String password, String dashboardValidationText) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassWord(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		
		BrowserFactory.tearDown();
		
	}

}
