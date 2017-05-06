# language: es
Característica: Editar password error

Escenario: Editar password como participante error

	Dado que me logueo en la pagina de inicio como participante "user3" con password "1234"
	Y despues pulso en el boton de modificar datos "modificaDatos"
	Y escribo mal mi password actual "abcdfgh" y escribo mi password nueva "5678"
	Entonces voy a la pagina de error en la contrasenia

