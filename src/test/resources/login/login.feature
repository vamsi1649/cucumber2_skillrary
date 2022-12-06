Feature:Test skillrary
1)valid case
2)invalid case
Background:
Given I should go to the login page
@PositiveTesting
Scenario:To Test login functionality with valid data
And Enter the username "<user>"
And Enter the password "<pass>"
And Click on the login button
Then I should see the username as "SkillRary Ecommerce" 
And Click on the username
And Click on the signout
Then I should go skillrary homepage as "SkillRary Courses"
Examples:
|user|pass|
|user|user|
|admin|admin|
@NegativeTesting
Scenario:To Test login functionality with invalid data
And Enter the username "Admin"
And Enter the password "Admin"
And Click on the login button
Then I should see the username as "SkillRary Ecommerce" 
And Click on the username
And Click on the signout
Then I should go skillrary homepage as "SkillRary Courses"