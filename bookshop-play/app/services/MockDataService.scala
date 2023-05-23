package services

import viewmodels.{Book, SearchParameters}

import scala.collection.mutable.ListBuffer


class MockDataService {
  var listOfBooks: ListBuffer[Book] = {
    var tempList = new ListBuffer[Book]

    tempList += Book("Prince of Thorns", "Mark", "Lawrence")
    tempList += Book("IT", "Stephen", "King")
    tempList += Book("Misery", "Stephen", "King")
    tempList += Book("Random Book", "David", "King")
    tempList += Book("Chums", "Simon", "Kupur")
    tempList += Book("A League of Extraordinary Gentlemen", "Kevin", "O'Neil")
    tempList += Book("Nickel Boys", "Colson", "Whitehead")
    tempList += Book("Neverwhere", "Neil", "Gaiman")

    tempList
  }

  def searchBooks(searchParameters: SearchParameters) = {
    var tempList = listOfBooks.toList

    if (!searchParameters.bookTitle.isEmpty) {
      tempList = tempList.filter(book => book.title == searchParameters.bookTitle)
    }

    if (!searchParameters.authorLastName.isEmpty) {
      tempList = tempList.filter(book => book.authorLastName == searchParameters.authorLastName)
    }

    if (!searchParameters.authorFirstName.isEmpty) {
      tempList = tempList.filter(book => book.authorFirstName == searchParameters.authorFirstName)
    }

    tempList = tempList.sortBy(x => x.title)

    tempList
  }

  def getAllBooks(): List[Book] = {
    val searchParameters = SearchParameters("", "", "")
    val searchResults = searchBooks(searchParameters)

    searchResults
  }

  def getAllAuthors() = {
    val tempList = listOfBooks.map(book => book.author)

    val sortedList = tempList.distinctBy(_.fullName).sortBy(_.lastName)

    sortedList
  }
}
