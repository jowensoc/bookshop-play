package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class APIControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "APIController GET" should {

    "render the index page from a new instance of controller" in {
      val controller = new APIController(stubControllerComponents())
      val api = controller.index().apply(FakeRequest(GET, "/"))

      status(api) mustBe OK
      contentType(api) mustBe Some("application/json")
      contentAsString(api) must include ("API is ready to go!")
    }

    "Find a specific book" in {
      val bookTitle = "Misery"
      val authorFirstName = "Stephen"
      val authorLastName = "King"

      val controller = new APIController(stubControllerComponents())
      val api = controller.searchBooks(bookTitle,"","").apply(FakeRequest(GET, "/api/search/Misery"))

      status(api) mustBe OK
      contentType(api) mustBe Some("application/json")
      contentAsString(api) must include(bookTitle)
      contentAsString(api) must include(authorFirstName)
      contentAsString(api) must include(authorLastName)

    }


    "Find a specific book with JSON results" in {
      val bookTitle = "Neverwhere"
      val authorFirstName = "Neil"
      val authorLastName = "Gaiman"

      val controller = new APIController(stubControllerComponents())
      val api = controller.searchBooks(bookTitle, "", "").apply(FakeRequest(GET, "/api/search/Misery"))

      status(api) mustBe OK
      contentType(api) mustBe Some("application/json")
      val jsonData = contentAsJson(api)

      (jsonData(0) \"title").as[String] must include(bookTitle)
      (jsonData(0) \"author-firstname").as[String] must include(authorFirstName)
      (jsonData(0) \"author-lastname").as[String] must include(authorLastName)

    }

  }
}
