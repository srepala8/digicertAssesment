Feature: StarWars Page Tests


  Scenario: Sort movies by ’Title’ and assert the last movie in the list is ‘The Phantom Menace’
      Given User Launch browser
      And opens URL "http://localhost:3000/"
      When User Navigates to SatrWars page
      Then User should be on the page with the currentUrl
      And User observes the list of Title of Movies
      And User sort the movies by title
      Then User should see the last movie in the list is "The Phantom Menace"
      And User Close the Browser

 




      
 