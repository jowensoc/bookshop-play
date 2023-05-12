package controllers

import javax.inject._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import viewmodels._

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

  def singlebook() = Action { implicit request: Request[AnyContent] =>
    var bookObj = Book("Prince of Thorns Test", "Mark", "Lawrence")

    Ok(Json.stringify(Json.toJson(bookObj))).as("application/json")
  }

  def singleauthor() = Action { implicit request: Request[AnyContent] =>
    var authorObj = Author("Mark", "Lawerence")

    Ok(Json.stringify(Json.toJson(authorObj))).as("application/json")
  }

}
