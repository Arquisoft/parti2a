package uo.asw.steps;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import uo.asw.Application;
import uo.asw.selenium.ModificaPassword;
import uo.asw.selenium.RellenarFormularioLogin;
import uo.asw.utils.SauceUtils;
import uo.asw.utils.SeleniumUtils;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class EditParticipantPasswordErrorSteps {
	
	private WebDriver driver;

	@Before
	public void run() {
		driver = SauceUtils.getDriver();
		driver.navigate().to("http://localhost:8090/");
	}
	
	@After
	public void end()
	{
		driver.quit();
	}
	
	@Dado("^que me logueo en la pagina de inicio como participante \"([^\"]*)\" con password \"([^\"]*)\"$")
	public void que_me_logueo_en_la_pagina_de_inicio_como_participante_con_password(String user, String password) throws Throwable {
		new RellenarFormularioLogin().rellenaFormulario(driver, user, password);
	}

	@Dado("^despues pulso en el boton de modificar datos \"([^\"]*)\"$")
	public void despues_pulso_en_el_boton_de_modificar_datos(String arg1) throws Throwable {
		By boton = By.id(arg1);
		driver.findElement(boton).click();	
		Thread.sleep(5000);
	}

	@Dado("^escribo mal mi password actual \"([^\"]*)\" y escribo mi password nueva \"([^\"]*)\"$")
	public void escribo_mal_mi_password_actual_y_escribo_mi_password_nueva(String anterior, String nueva) throws Throwable {
		 new ModificaPassword().rellenaFormulario(driver, anterior, nueva);
	}

	@Entonces("^voy a la pagina de error en la contrasenia$")
	public void voy_a_la_pagina_de_error_en_la_contrasenia() throws Throwable {
	   Thread.sleep(5000);
	   SeleniumUtils.textoPresentePagina(driver, "son incorrectos");
	   SeleniumUtils.textoPresentePagina(driver, "Pulsa para volver a la página de inicio");
	}


}
