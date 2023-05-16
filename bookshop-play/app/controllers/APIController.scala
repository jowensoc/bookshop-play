package controllers

import javax.inject._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import services.{DataServiceTrait, MockDataService}
import viewmodels._

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.util.Random


@Singleton
class APIController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    val outputStr = "API is ready to go!"

    Ok(Json.stringify(Json.toJson(outputStr))).as("application/json")
  }

  def listofbooks() = Action { implicit request: Request[AnyContent] =>
    //var bookObj = Book("Prince of Thorns Test", "Mark", "Lawrence")
    var bookService = new MockDataService();

    var booksObj: List[Book] = bookService.getAllBooks().toList

    Ok(Json.stringify(Json.toJson(booksObj))).as("application/json")
  }

  def listofauthors() = Action { implicit request: Request[AnyContent] =>

    var bookService = new MockDataService()

    var authorObj: List[Book] = bookService.getAllBooks().toList

    Ok(Json.stringify(Json.toJson(authorObj))).as("application/json")
  }

  def singlebook() = Action { implicit request: Request[AnyContent] =>
    var rnd = new Random()

    var bookService = new MockDataService()

    var totalBooks = bookService.getAllBooks().toList.length - 1
    var randomIndex = 0 + rnd.nextInt(totalBooks)

    var bookObj : Book = bookService.getAllBooks().toList(randomIndex)

    Ok(Json.stringify(Json.toJson(bookObj))).as("application/json")
  }

  def singleauthor() = Action { implicit request: Request[AnyContent] =>
    var rnd = new Random()

    var bookService = new MockDataService()

    var totalBooks = bookService.getAllBooks().toList.length - 1
    var randomIndex = 0 + rnd.nextInt(totalBooks)

    var authorObj: Author = bookService.getAllBooks().toList(randomIndex).author

    Ok(Json.stringify(Json.toJson(authorObj))).as("application/json")
  }

}
