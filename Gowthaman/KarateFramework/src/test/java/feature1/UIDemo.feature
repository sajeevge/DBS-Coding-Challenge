Feature: UI example
  Background: 
    * configure driver = { type: 'chrome' }
    Scenario: Sign up
      Given driver "https://www.demoblaze.com/"
      When maximize()
      When click("//a[@id='signin2']")
      And delay(4000)
      And input("input[id='sign-username']",'John')
      And input("input[id='sign-password']",'Welcome123')
      Then click("button[onclick='register()']")
      And delay(2000)
      And close()
    
    



