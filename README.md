# UserInterfaceProject

### Overview

 Maven Selenium testing framework in Java using Page Object Pattern
 
### Motivation
````
Update:

* Update the report to a more extended report using Extent Report and is found under ExtentReport folder
* Screenshots and charts are integrated directly inside the HTML report 
* Retry function two times for failed tests in order to avoid issues that could appear first time
* Added a TestNG.xml with listeners - suite test can be added and run individual (tests should be run through TestNG.xml for the extended report)
````
* For browser automation, I’ve decided to go with Selenium WebDriver because is the go-to standard for browser automation. Most important benefits are Advanced Browser Interactions, Mouse and Keyboard simulation, Cross Browser compability, Cross Device compability, easy to extend with personalized extensions.
* I choose to create as Maven project because is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation, no need to install any other dependencies.
* IntelliJ because is a programming environment largely meant for Java and integrates great with Maven, Selenium and TestNG.
* For running tests and performing assertions, I decided to go with TestNG and it integrates very nicely with IntelliJ and is an automation testing framework in which NG stands for "Next Generation". TestNG is inspired from JUnit which uses the annotations (@).

### Environment Setup

1. Global Dependencies
     * chromeDriver.exe which must be downloaded and insert the path of the folder where the executable inside System Variables Path

2. Setup
    * Clone the repo
	  * Open the uitest project
	  * Build the solution
    * Run UI tests through TestNG.xml suite (all tests are declared but individual tests can be run by commenting the other tests)
    * After the tests execution finished, check the report inside ExtentReports/ExtentReportResults.html
