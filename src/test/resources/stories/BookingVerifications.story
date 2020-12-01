Meta:
@booking_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to ...

Given user opened 'Booking main page' by url: 'BOOKING_BASE_URL'
When user typed travel place, in search input field:
| city  |
| Milan |
And user choosed travel place in predictive search list
And user choosed travel date trip:
| day | monthYear     |
| 10  | березень 2021 |
!-- Then system is in a different state