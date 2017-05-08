package uo.asw

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class NormalUserTest extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8090")
		.inferHtmlResources(BlackList(""".*firefox.com.*""", """.*cloudflare.com.*""", """.*jquery.com.*""", """.*bootstrapcdn.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")

	val headers_2 = Map("Accept" -> "*/*")



	val scn = scenario("NormalUserTest")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/login.css")
			.headers(headers_1),
            http("request_2")
			.get("/img/user.png")
			.headers(headers_2)))
		.pause(10)
		.exec(http("request_3")
			.post("/acceso")
			.headers(headers_0)
			.formParam("user", "user1")
			.formParam("password", "1234")
			.resources(http("request_4")
			.get("/css/participant.css")
			.headers(headers_1),
            http("request_5")
			.get("/img/user.png")
			.headers(headers_2)))
		.pause(12)
		.exec(http("request_6")
			.get("/changeInfo")
			.headers(headers_0))
		.pause(15)
		.exec(http("request_7")
			.post("/changeInfo")
			.headers(headers_0)
			.formParam("password", "1234")
			.formParam("newPassword", "1234")
			.formParam("updateInfo", "Actualizar")
			.resources(http("request_8")
			.get("/css/participant.css")
			.headers(headers_1),
            http("request_9")
			.get("/img/user.png")
			.headers(headers_2)))
		.pause(19)
		.exec(http("request_10")
			.post("/changeEmail")
			.headers(headers_0)
			.formParam("email", "user52@gmail.com")
			.formParam("updateEmial", "Editar")
			.resources(http("request_11")
			.get("/css/participant.css")
			.headers(headers_1),
            http("request_12")
			.get("/img/user.png")
			.headers(headers_2)))
		.pause(10)
		.exec(http("request_13")
			.get("/closeSession")
			.headers(headers_0)
			.resources(http("request_14")
			.get("/css/login.css")
			.headers(headers_1),
            http("request_15")
			.get("/img/user.png")
			.headers(headers_2)))

	setUp(scn.inject(rampUsers(50) over(60 seconds))).protocols(httpProtocol)
}
