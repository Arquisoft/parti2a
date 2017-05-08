
package uo.asw

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DashboardTest extends Simulation {

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

	val headers_6 = Map(
		"Accept" -> "text/event-stream",
		"Pragma" -> "no-cache")



	val scn = scenario("RecordedSimulation")
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
			.formParam("user", "alcalde")
			.formParam("password", "1234")
			.resources(http("request_4")
			.get("/css/styles.css")
			.headers(headers_1),
            http("request_5")
			.get("/js/loadUpdates.js")
			.headers(headers_2),
            http("request_6")
			.get("/updates")
			.headers(headers_6),
            http("request_7")
			.get("/dashboard/suggestion/1")
			.headers(headers_0),
            http("request_8")
			.get("/css/styles.css")
			.headers(headers_1),
            http("request_9")
			.get("/js/detailSuggestion.js")
			.headers(headers_2)))
		.pause(13)
		.exec(http("request_10")
			.get("/dashboard/comment/1")
			.headers(headers_0)
			.resources(http("request_11")
			.get("/css/styles.css")
			.headers(headers_1),
            http("request_12")
			.get("/js/detailComment.js")
			.headers(headers_2)))

	setUp(scn.inject(rampUsers(50) over(60 seconds))).protocols(httpProtocol)
}
