package uo.asw.steps;

import cucumber.api.java.Before;

import org.junit.After;
import org.openqa.selenium.WebDriver;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import uo.asw.Application;
import uo.asw.selenium.RellenarFormularioLogin;
import uo.asw.utils.SauceUtils;
import uo.asw.utils.SeleniumUtils;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class LoginUserErrorSteps {

	private WebDriver driver;

	@Before
	public void run() {
		driver = SauceUtils.getDriver();
		driver.navigate().to("http://localhost:8090/");
	}

	@After
	public void end() {
		driver.quit();
	}

	@Dado("^un formulario de login de inicio en que escribo mis datos$")
	public void un_formulario_de_login_de_inicio_en_que_escribo_mis_datos() throws Throwable {
		SeleniumUtils.textoPresentePagina(driver, "Inicio de sesion");
	}

	@Cuando("^me logueo como el usuario \"([^\"]*)\" con la password \"([^\"]*)\"$")
	public void me_logueo_como_el_usuario_con_la_password(String user, String password) throws Throwable {
		new RellenarFormularioLogin().rellenaFormulario(driver, user, password);
	}

	@Entonces("^voy a la pagina de error de login$")
	public void voy_a_la_pagina_de_error_de_login() throws Throwable {
		SeleniumUtils.textoPresentePagina(driver, "El usuario no se encuentra registrado");
		SeleniumUtils.textoPresentePagina(driver, "Pulsa para volver a la página de inicio");
	}

}
