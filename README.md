# README  - This is eGAR-Automation Test Framework for Front End Functional Testing on Public End-user journey Only#
** Version 1.0 **

** What is this repository for? **
### This repository is automation test repository which has automation framework ###

* The Build Tool is :- Maven
* The Framework implementation is :- Cucumber Java BDD( Behaviour Driven Development )
* Automation Tool :- Selenium
* Design Pattern :- Page Object Model

* This Framework has ability to run on any machine provided suitable environmental variables are set on the machine
## Prepare Your Machine 1st :-  Environment Variables required to Set on your machine
*                               1) Download & Install JDK 8 and Set up JDK_HOME variable on machine
*                               2) Download Maven 3.3.9  and Set up MAVEN_Home variable on machine
*                               3) Install Ide that supports JAVA. For E.g. Intellij and open project in it
*                               4) Make sure JDK path and POM.xml path is set up too for project

## How to read the framework ##
* This framework seating on Maven has 2 fundamental packages received as default from Maven in Source (src) and 1
* important file named as pom.xml

*    Package Directory - 1)   main - This package directory has all the configurations related to declaring and setting
*                                    Web Driver, Web Utils, Hooks

*                             - This package directory has sub folders namely
*                                        1) pages - This package has pages.java class and in each .java class contains
*                                                   html Web Elements declared using Page Factory for each/specific page
*                                                   and a complete re-usable / generic logic written in form of methods
*                                        2) stepDefinitions   - This package has stepDefinitions.java class which
*                                                               contains automatically generated stepDefinitions
*                                                               generated from BBD feature files(In Test Package)
*                                                             - The functional logic written in Pages.java classes are
*                                                               called in step definition's body
*                                        3) resources         - This package contains default.properties file in which
*                                                               static properties like url, browser can be declared

*    Package Directory - 2)   test - This directory contains
*                                        1) cucumber runner.java class which acts as main heart-line of the test framework
*                                        2)  resources which has sub folders like 1) Feature files, JSon and log4j.xml
*                                        In feature files package - We have all BDD feature files written in GWT format
*                                           (Gherkin format) which helps us to generate empty stepDefinitions


*    File              - 3)   pom.xml - This is an xml (extensive markup language) file in which we declare required
*                                        libraries and plugins for example selenium, cucumber, junit, testng etc etc


## How do I Run the test if everything is set as required ? ##

** Assumptions **
* Environments are well set and tested before running test
* User can enter the project root directory from command line
* Access to web application is available / allowed
* Although our framework supports 3 browsers like Chrome, Firefox and IE 11 latest, we have set default to run on Chrome
* Ensure latest Chrome Browser is installed on your machine

** Steps **
* in default.properties :- url is checked and relevant url is declared starting with http:// or https://
* Currently there is test user "new1@testingworld.com" with password "testing1234" was created manually. It is advised
    to create new test user for running in your own environment
* In each .feature file in Background section :- Change username to "(the user you have created)" and password
  ("the password you have given").
* Now open command line and enter the project root directory

                    #### COMMANDS FOR RUNNING THE TEST #####
 * - run this command from command line :- mvn clean install -Dcucumber.options=" --tags @automated"

 * - You can also run the test from IDE if you are using Intellij IDEA IDE.
 *          1) From Runner class
 *               1) Open Project
 *               2) Go to CucumberTest.java class which is cucumber runner class
 *               3) Hit Green / Red Arrow button visible next to class name

 *          2) From each Separate Feature File
 *               1) Go to featureFiles and choose any feature file.
 *               2) You will see Test Scenario written in Given When Then format.
 *               3) Now keep pointer next to any of these words "Scenario:" or "Feature"
 *               4) Right click and hit Green Arrow key as RUN


 ** EXPECTED RESULTS **
 *  Please note - Interactive Reports are generated only if you run this test as Maven test. I.e. Run this test from
 *                Command line or Terminal ##
 *  Test Reports will be Generated in an auto Generated package named as "target"
 *  Test reports only generates after the test has completed the test run.
 *  You will find the test reports in "cucumber-html-reports" folder and navigate to any .html file
 *  Open that html file in chrome browser
 *  You find an interactive cucumber html report with complete details
THIS FRAMEWORK DOES NOT RUN HEADLESS TEST ON ANY MACHINE OR SERVER
 ## ------------------------------------------------------------------------------------------------------------------##