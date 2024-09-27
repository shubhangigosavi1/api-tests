Feature: Booking
  Scenario:Get booking ids
    When "GetBookingIds" API is called with "GET" request
    Then Status code is 200
    And response body is not null
    And atleast one bookingId is present in the response body

  Scenario: Get booking with valid ID
    When "GetBooking" API is called with "GET" request
    Then Status code is 200
    And response body is not null

  Scenario:Create Booking
    When "CreateBooking" API is called with "POST" request
    Then Status code is 200
    And response body is not null

  Scenario:Update Booking
    When "UpdateBooking" API is called with "PUT" request
    Then Status code is 200
    And response body is not null

  Scenario:Partial Update Booking
    When "PartialUpdateBooking" API is called with "PATCH" request
    Then Status code is 200
    And response body is not null

  Scenario:Delete Booking
    When "DeleteBooking" API is called with "DELETE" request
    Then Status code is 201
    And response body is not null

  Scenario:HealthCheck
    When "HealthCheck" API is called with "GET" request
    Then Status code is 201
    And response body is not null


  #invalid booking ID
  Scenario: Get booking with invalid ID
    Given invalid booking ID
    When "GetBooking" API is called with "GET" request
    Then Status code is 404
    And response body is not null

  #invalid create booking payload
  Scenario: Create booking with invalid payload
    Given invalid create booking payload
    When "CreateBooking" API is called with "POST" request
    Then Status code is 500


  #Unauthorized request
  Scenario: Update booking without authentication
    When "UpdateBookingWithoutAuth" API is called with "PUT" request
    Then Status code is 403
    And response body should contain the message "Forbidden"


  #Failed scenario for report generation
  Scenario: Get booking with valid ID
   When "GetBooking" API is called with "GET" request
    Then Status code is 400
    And response body is not null
