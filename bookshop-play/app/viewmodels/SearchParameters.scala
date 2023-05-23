package viewmodels

class SearchParameters(val bookTitle: String, val authorFirstName: String, val authorLastName: String) {

}

object SearchParameters {
  def apply(title: String, authorFirstName: String, authorLastName: String): SearchParameters = {
    var searchParametersObj = new SearchParameters(title, authorFirstName, authorLastName)

    searchParametersObj
  }
}
