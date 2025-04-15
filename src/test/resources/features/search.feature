Feature: YouTube Search

  Scenario: Search for a product on YouTube
    Given I open YouTube homepage
    When I search for "handmade mug"
    Then I should see results related to "handmade mug"