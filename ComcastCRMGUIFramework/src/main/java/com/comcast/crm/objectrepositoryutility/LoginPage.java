package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


/**
 * @author saikiranmedisetti
 *  Contains Login Page elements & business lib like login()
 * 
 * 
 * 
 */

public class LoginPage extends WebDriverUtility{
	


	 WebDriver w=null;
	      

	    @FindBy(name = "user_name")
	    private WebElement usernameEdt;

	    @FindBy(name = "user_password")
	    private WebElement passwordEdt;

	    @FindAll({
	        @FindBy(id = "submitButton"),
	        @FindBy(css = "input[type='submit'][value='Login']")
	    })
	    private WebElement loginBtn;

	    public LoginPage(WebDriver w) {
	    	this.w=w;
	       
	        PageFactory.initElements(w, this); // ✅ ONLY this
	    }

	    /**
	     * 
	     * Credentials
	     * @param user
	     * @param pass
	     */
	    public void login(String user, String pass) {
	    	 waitToLoad(w,15);
	        usernameEdt.sendKeys(user);
	        passwordEdt.sendKeys(pass);
	        loginBtn.click();
	    }

		 

		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

		 
	}



