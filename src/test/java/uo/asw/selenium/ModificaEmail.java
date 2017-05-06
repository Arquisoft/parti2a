package uo.asw.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModificaEmail {

	
	 public void rellenaFormulario(WebDriver driver, String pemail) throws InterruptedException
	   {
			WebElement email = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div/div/div[2]/table/tbody/tr[5]/td[2]/input"));
			email.click();
			email.clear();
			email.sendKeys(pemail);
			
			//Pulsar el boton de email
			By boton = By.xpath("/html/body/div/div/div[2]/div/form/div/div/div[2]/table/tbody/tr[5]/td[3]/input");
			driver.findElement(boton).click();	   
			Thread.sleep(5000);
	   }
}
