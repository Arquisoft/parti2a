package uo.asw.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RellenarFormularioLogin {
	
	 public void rellenaFormulario(WebDriver driver, String puser, String ppasword) throws InterruptedException
	   {
			WebElement user = driver.findElement(By.xpath("//*[@id='user']"));
			user.click();
			user.clear();
			user.sendKeys(puser);
			WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
			password.click();
			password.clear();
			password.sendKeys(ppasword);
			//Pulsar el boton de Login.
			By boton = By.xpath("//*[@id='login_form']/button");
			driver.findElement(boton).click();	   
			Thread.sleep(3000);
	   }

}
