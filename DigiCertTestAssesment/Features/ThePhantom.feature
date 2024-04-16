Feature: StarWars Page Tests


  Scenario: Assert that ‘Planets’ ‘Camino’ is not part of the movie ‘The Phantom Menace’
      Given User Launch browser
      And opens URL "http://localhost:3000/"
      When User Navigates to SatrWars page
      Then User should be on the page with the currentUrl
      When User Click on the movie The Phantom Menace
      Then User should not find Planets and Camino on that list
      And User Close the Browser