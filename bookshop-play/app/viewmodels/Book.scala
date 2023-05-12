package viewmodels

import play.api.libs.json._

class Book(var title: String, var authorFirstName: String, var authorLastName:String) {
  var author : Author = new Author(authorFirstName, authorFirstName)

  val authorFullName = author.fullName

}

object Book {

  def apply (title: String, authorFirstName: String, authorLastName:String): Book = {
    var bookObj = new Book(title, authorFirstName, authorLastName)

    bookObj
  }

  implicit val bookWrites = new Writes[Book] {
    def writes (bookObj: Book) = Json.obj (
      "title" -> bookObj.title,
      "author-firstname" -> bookObj.authorFirstName,
      "author-lastname" -> bookObj.authorLastName,
      "author-fullname" -> bookObj.authorFullName
    )
  }
}
