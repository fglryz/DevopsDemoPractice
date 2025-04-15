Feature: Etsy Search

  Scenario: Search for a product on Etsy
    Given I open Etsy homepage
    When I search for "handmade mug"
    Then I should see results related to "handmade mug"