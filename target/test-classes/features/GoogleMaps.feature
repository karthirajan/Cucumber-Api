#Author: your.email@your.domain.com
Feature: Google Maps

  Scenario: add place
    Given add place payload
    When user calls addPlaceApi with post http request
    Then user verify "addPlaceApi" status code 200

    
