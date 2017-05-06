# language: es
Característica: Editar password

Escenario: Editar password como participanete

	Dado que me logueo en la pagina como participante "user2" con password "1234"
	Y pulso en el boton de modificar datos "/html/body/div/div/div[1]/a[1]"
	Y escribo mi password actual "1234" y escribo mi password nueva "5678"
	Y vuelvo al inicio
	Y me vuelvo a loguear como participante "user2" con la nueva password "5678"
	Entonces estoy en la pagina principal de usuario

