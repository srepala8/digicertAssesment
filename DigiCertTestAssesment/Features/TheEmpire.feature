Feature: Empire Page Tests


  Scenario: View the movie ‘The Empire Strikes Back’ and check if the ‘Species’ list has ‘Wookie’
      Given User Launch browser
      And opens URL "http://localhost:3000/"
      When User Navigates to SatrWars page
      Then User should be on the page with the currentUrl
      When User Click on the movie The Empire Strikes Back 
      Then User should find wookie on the species list
      And User Close the Browser