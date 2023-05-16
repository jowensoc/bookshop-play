package services

import viewmodels.Book

import scala.collection.mutable.ListBuffer


class MockDataService {
  var listOfBooks: ListBuffer[Book] = {
    var tempList = new ListBuffer[Book]

    tempList += Book("Prince of Thorns", "Mark", "Lawrence")
    tempList += Book("IT", "Stephen", "King")
    tempList += Book("Chums", "Simon", "Kupur")
    tempList += Book("A League of Extraordinary Gentlmen", "Kevin", "O'Neil")
    tempList += Book("Bad \"quotes\"", "JOe", "Bloggs")

    tempList
  }

/*
  def initialiseBooks() {
    var tempList = new ListBuffer[Book]

    tempList += Book("Prince of Thorns", "Mark", "Lawrence")
    tempList += Book("IT", "Stephen", "King")
    tempList += Book("Chums", "Simon", "Kupur")
    tempList += Book("A League of Extraordinary Gentlmen", "Kevin", "O'Neil")
    tempList += Book("Bad \"quotes\"", "JOe", "Bloggs")

    tempList
  }
 */

  def getAllBooks() = listOfBooks

  def getAllAuthors() = listOfBooks
}
