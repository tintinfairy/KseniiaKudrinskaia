Feature: All scenarios for HW6

  Background:
    Given I open page by URL
    And I login as 'epam'/'1234'


  @Ex1
  Scenario: Home Page and different elements Page test
    Then 'Home Page' page is opened
    And User name should be 'PITER CHAILOVSKII'
    And There are should be '4' pictures on Home Page
    And There are should be '4' texts under pictures on Home Page
    And There are should be '2' texts above pictures on Home Page
    When I click on "Service" subcategory in the header
    Then Dropdown list should be displayed
    And Dropdown list should have items
      | SUPPORT | DATES | COMPLEX TABLE | SIMPLE TABLE | USER TABLE | TABLE WITH PAGES | DIFFERENT ELEMENTS | PERFORMANCE |
    When I click on "Service" subcategory in the left section
    Then Dropdown list on the left should be displayed
    And Dropdown list on the left should have items
      | Support | Dates | Complex Table | Simple Table | User Table | Tables with pages | Different elements | Performance |
    When I click on "Service" subcategory in the header
    And I click on 'DIFFERENT ELEMENTS'
    Then Different elements page contains elements '4' checkboxes, '4' radio boxes
    And Different elements page contains elements '1' dropdowns, '2' buttons
    And There is Right Section on Different Elements Page
    And There is Left Section on Different Elements Page
    When I select checkboxes 'Water'/'Wind'
    Then Appropriate log row for this checkboxes should appear
    When I select radio 'Selen'
    Then Appropriate log row for this radio should appear
    When I select 'Yellow' in dropdown
    Then Appropriate log row for this dropdown should appear
    When I select checkboxes 'Water'/'Wind'
    Then Appropriate log row for this unselected checkboxes should appear

  @Ex2
  Scenario: User Table Page test
    When I click on "Service" subcategory in the header
    And I click on 'USER TABLE'
    Then 'User Table' page is opened
    And '6' NumberType Dropdowns are displayed on Users Table on User Table Page
    And '6' User names are displayed on Users Table on User Table Page
    And '6' Description images are displayed on Users Table on User Table Page
    And '6' Description texts under images are displayed on Users Table on User Table Page
    And '6' checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select vip checkbox for 'SERGEY_IVAN'
    Then log row has 'Vip': condition changed to 'true' text in log section
    When I click on dropdown in column Type for user 'ROMAN'
    Then droplist for 'ROMAN' contains values
      | Admin   |
      | User    |
      | Manager |

