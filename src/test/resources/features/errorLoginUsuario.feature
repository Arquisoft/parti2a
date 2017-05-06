# language: es
Característica: Error en login como usuario

Escenario: Login como usuario error

	Dado un formulario de login de inicio en que escribo mis datos
	Cuando me logueo como el usuario "user124" con la password "123478"
	Entonces voy a la pagina de error de login
