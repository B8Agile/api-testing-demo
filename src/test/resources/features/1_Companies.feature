@regression
Feature: Testing Companies End Points

  Scenario: Happy Path Create Company (Company-Post EndPoint) -->POST
    Then User validates 'BookingLLC', 'book123@gmail.com', 'bay area' and '1212121212' from end-point Post

    #put endpoint ID before running as expected!
  Scenario: Happy Path Check Company (Company-Check EndPoint) -->GET
    Then User validates 'BookingLLC', 'book123@gmail.com', 'bay area' and '1212121212' from end-point Get

  Scenario: Happy Path Update Company (Company-Update EndPoint) -->Put
    Then User validates 'DeliveryLLC', 'deliver@gmail.com', 'atlantic' and '0000000000' from end-point Put

  Scenario: Happy Path Block Company (Company-Block EndPoint) -->Put
    Then User validates 'true' from end-point Put-Block

    #bug: expected true but actual false
  Scenario: Happy Path UnBlock Company (Company-UnBlock EndPoint) -->Put
    Then User validates 'true' from end-point Put-UnBlock

  Scenario: HappyPath Delete Company (Company-Delete EndPoint) -->Delete
    Then User validates 'DeliveryLLC', 'deliver@gmail.com', 'atlantic' and '0000000000' from end-point Delete

   #message is changeable!
  Scenario: Happy Path Checking the deleted Company from Get End point  -->Get
    Then User validates 'NOT FOUND' and 'Company with id 381 was not found' from end-point Get

   #bug: expected is true but actual is false
  Scenario: Happy Path Check All Company UnBlocked (Companies-Check EndPoint) -->GET
    Then User validates blocked 'true' from end-point Get








