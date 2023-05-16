package services

trait DataServiceTrait {

  def GetSingleBook() : Unit
  def GetListOfBooks() : Unit
  def GetSingleAuthor(): Unit
  def GetListOfAuthors(): Unit

}
