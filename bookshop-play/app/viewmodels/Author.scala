package viewmodels

import play.api.libs.json._

class Author(var firstName: String, var lastName: String) {
  val fullName = firstName + " " + lastName
}

object Author {

  def apply(firstName: String, lastName: String): Author = {
    var authorObj = new Author(firstName, lastName)

    authorObj
  }

  implicit val authorWrites = new Writes[Author] {
    def writes (authorObj: Author) = Json.obj (
      "author-firstname" -> authorObj.firstName,
      "author-lastname" -> authorObj.lastName,
      "author-fullname" -> authorObj.fullName
    )
  }

}
