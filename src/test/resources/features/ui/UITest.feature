Feature: Book travel on Blazedemo

  Scenario: Sequential Execution, Open BlazeDemo site
    Given Open https://www.blazedemo.com/

  Scenario: Select departure/destination city from the Home Page
    Given Open https://www.blazedemo.com/
    And the browser is on the Home Page
    And the departure city Paris from the dropdown is selected on the Home Page
    And the destination city Buenos Aires from the dropdown is selected on the Home Page
    And the Find Flights button is clicked on the Home Page
#    Then the heading should show "Flight from Paris to Buenos Aires:" on the Reservation Page.
#
#  Scenario: Select the flight with the appropriate fields
#    Given the flight is found in the reservation table on the Reservation Page:
#      | flight number | airline    | departs | arrives | price   |
#      | 9696          | Aer Lingus | 5:27 AM | 8:22 PM | $200.98 |
#    And the "Choose This Flight" button is clicked on the Reservation Page
#    Then the heading should show "Your flight from Paris to Buenos Aires has been reserved." on the Purchase Page
#    And the flight information is shown on the Purchase Page:
#      | flight number | airline    | price  | fee/taxes | total  |
#      | 9696          | Aer Lingus | 200.98 | 514.76    | 715.74 |
#
#  Scenario: Fill the form for flight purchase and confirm
#    Given the flyer information is entered in the Purchase Page:
#      | Name  | Address            | City        | State    | Zip Code | Card Type | Credit Card Number | Month | Year | Name on Card | Remember me |
#      | Duffy | 12345 Simpson Lane | Springfield | Illinois | 54321    | VISA      | 231467582910       | 01    | 2022 | Duffy Drinks | No          |
#    And the "Purchase Flight" button is clicked on the Purchase Page
#    Then the heading should show "Thank you for your purchase today!" on the Confirmation Page
#    And the purchase information is found in the purchase table on the Confirmation Page:
#      | Id         | Status         | Amount | Card Number  | Expiration | Auth Code | Date               |
#      | ${notNull} | PendingCapture | USD    | xxxxxxxxxxxx | 01/2022    | 888888    | ${currentDateTime} |
#    And the response should be shown in the response box on the Confirmation Page:
#      | id         | status         | amount | currency | authCode | cardNumber   | cardExpirationMonth | cardExpirationYear |
#      | ${notNull} | PendingCapture |        | USD      | 888888   | xxxxxxxxxxxx | 01                  | 2022               |
#
