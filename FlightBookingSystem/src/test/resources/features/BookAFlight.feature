#Author: Zavha Hlungwani
#Keywords Summary : Automate a flight search process on https://euro.expedia.net/

Feature: Your task will be to automate a flight search process on https://euro.expedia.net/

Scenario: Flight is available on given date

Given browser is open
And user navigate to the homepage
When user enters required details
And clicks on search flight button
Then user select best time for the flight
Then close browser and quit operations
