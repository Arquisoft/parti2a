package uo.asw.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;


public class SauceUtils {

	@Value("${local.server.port}")
	protected int port;
	
	private static Logger log = Logger.getLogger(SauceUtils.class);
	
	static public WebDriver getDriver(String test) {
		String sauceUser;
		String saucePassword;
		
		sauceUser = System.getenv("SAUCE_USERNAME");
		saucePassword = System.getenv("SAUCE_ACCESS_KEY");
		URL saucelabs = null;
		WebDriver driver;
		
		if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
			try {
				saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");
			} catch (MalformedURLException e) {
				log.debug("URL SauceLabs inválida");
			}

			DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
			capabilities1.setCapability("platform", "Windows 10");
			capabilities1.setCapability("version", "43.0");
			capabilities1.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
			capabilities1.setCapability("name", test);
			driver = new RemoteWebDriver(saucelabs, capabilities1);
			log.debug("Utilizando driver remoto");
		} else {
			driver = new HtmlUnitDriver();
			log.debug("Utilizando driver local");
		}
		
		return driver;
	}
}