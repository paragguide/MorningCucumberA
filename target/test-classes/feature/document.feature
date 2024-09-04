Feature: Amazon Document
  I want to use this template to test amazon.in
  
  @login @userid
  Scenario: Validate Userid
    Given i open browser "edge" and get url "https://www.amazon.in" and init report "LoginReport" for test "LoginTest"
    And i click signin
    When I enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then validate the outcomes
  
  @login @password1  
  Scenario: Validate Password
    Given userid is valid
    When i enter correct password "RMinfotech12#&&"  
    Then i should login
    
  @login @password2  
  Scenario: Validate Password
    Given userid is valid
    When i enter correct password "RMinfotech12#&&1"  
    Then i should login  
  
  @amazon @search  
  Scenario Outline: Search Products
    Given i am logged in
    When i search for <product> in price <price>
    Then get results
    
   @amazon @data1 
   Examples:
   | product | price |
   | Shirt | 500 |
   | pant | 1400 |
   | Coat | 4500 |
   
   @amazon @data2 
   Examples:
   | product | price |
   | LCD | 5500 |
   | Mobile | 9000 |
   | ipad | 45000 |
   
   @amazon @forget
   Scenario: Forget Password
     Given login is fail
     When i click forget link
     And enter recover userid
     Then email should go
     
   @amazon @forget2
   Scenario: forget password
    Given i launch "chrome" with url "https://www.amazon.in" add report "forgetreport" on testname "forget2"
    When clicked on signin link
    And clicked on forget pwd link
    And enter valid username
    Then send email to registered email 
    
   @close
   Scenario: close browser
    When close browser
  