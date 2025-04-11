@regression
Feature: Testing Branches End Points

  Scenario: Happy Path Creating a new Branch to the Existing Company (Branch-Post Endpoint) -->POST
    Then User validates 'Chicago Branch', 'chicago@gmail.com', 'Devon Ave', '8888888888', '11' and '88' from end-point Post

  Scenario: Happy Path Checking Branch is created (Branch-Get Endpoint) --> GET
    Then User validates 'Hawaii', 'Test Company', 'test@example.com', '1234 Test St, Testing' and '+1 111 111 1111' from end-point Get

  Scenario: Happy Path Updating Branch (Branch-Put Endpoint) --> PUT
    Then User validates updated 'Yorker Branch', 'yorker@gmail.com', 'Atlantic Ave', '7777777777', '1' and '77' from end-point Put

     #bug: expected is true actual is false!
  Scenario: Happy Path Blocking Branch (Branch-Put Endpoint) --> PUT
    Then User validates 'true' and 'true' from end-point Put

  Scenario: Happy Path UnBlocking Branch (Branch-Put Endpoint) --> PUT
    Then User validates blocked 'false' and 'false' from end-point Put

  Scenario: Happy Path Delete Branch (Branch-Delete Endpoint) --> DELETE
    Then User validates deleted 'Yorker Branch', 'yorker@gmail.com', 'Atlantic Ave', '7777777777', '1' and '77' from end-point Delete

    #bug: expected is true actual is false!
  Scenario: Happy Path Get All Branches are Unblock(Branch-Get Endpoint) --> GET
    Then User validates Not Block 'true' and 'true' from end-point Get







