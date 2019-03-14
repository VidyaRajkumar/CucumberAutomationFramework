###### Project Title ###### 
ITV

###### Technology Used ###### 
Java, Selenium webDriver, Maven,TestNG, log4j

###### Framework Used ###### 
Cucumber BDD Framework

###### Site Reference ###### 
https://www.itv.com/


###### Features ###### 
Feature: Documentaries are available
As a user of ITV Hub
I want to see a list of Factual programmes
So that I can view the latest available documentaries
	
###### Installation ###### 
* Maven 3.5.4(or any other version) and Java 8 ,Eclipse with any latest version needs to be installed 
* System variables needs to be set as below
* JAVA_HOME-local path where jdk is installed 
Example: C:\Program Files\Java\jdk1.8.0_181
* Maven_HOME - local path where maven is installed 
Example: C:\Users\Deepan\apache-maven-3.5.4-bin\apache-maven-3.5.4
* PATH - append the paths for the bin files of both java and maven
Examples: C:\Users\Vidya\apache-maven-3.5.4-bin\apache-maven-3.5.4\bin;C:\Program Files\Java\jdk1.8.0_181\bin;
* Download this project and save it locally.
* Import this project to the eclipse by following below steps,
- Go to Eclipse -> click on File -> Import -> Maven -> Existing Maven Project -> browse and select this Project -> click on Finish
- Right click on pom.xml -> Run As-> Maven install(if any complilation/build error please ignore)
- Right Click on Project(ITV)->Maven->Update Project which resolves any error faced in the above step
* All the necessary JARs will be automatically installed from MAVEN framework using the dependencies added in pom.xml
* Currently Chromedriver and geckodriver is present in drivers folder of the Project

###### Implementation approach ###### 
* In this framework maven is used as a build management tool and there are two main folders namely src/main/java and src/test/resources
* In src/main/java there are seperate packages to maintain enums,helper classes, page Object classes,stepDefinitions,TestRunner class and testBase classes.
* In enums package there are 2 enums for maintaining the browser names and operating system names namely Browsers and Os
* In helper folder there is a class for generating the logs named LoggerHelper
* In pageObjects there are three page object classes one for home page and one for the Categories and one for the SignIn namely HomePage, CategoriesPage and SignInPage which has all the locators and the methods to access the locators
* In steDefinitions package there are three classes for all the stepdefinitions required for the page objects .
* And also there is a ServiceHooks class which has before and after hooks for performing testBase class initialization and for generating screenshots and logs for the failed test cases(on test exit).For now in @Before method the browser value is set to CHROME and can be changed to FIREFOX if required to run the tests on firefox browser.
* Logs are generated for the passed test cases also at "ITV->automation.out"
* In testBase package there is a TestBase class in which all the browser initializations are maintained.
* In testRunner package there is a TestRunner class which runs all the cucumber features.
* In src/test/resources there are different folders to maintain feature files and driver .exe files  
* In drivers folder there are chromedriver and geckodriver .exe files are present which works fine for WINDOWS environment
* In features folder there is a single feature file , documentariesAreAvailable.feature which has 3 scenarios with the Background has some common navigation steps
* HTML Reports are generated at "ITV/target/cucumber-reports/advanced-reports/cucumber-html-reports"
* Kindly refer overview-failures.html,overview-features.html,overview-steps.html,overview-tags.html reports in the above path mentioned.
* Failed tests screenshots are generated in the path "ITV\target\cucumber-reports\advanced-reports\cucumber-html-reports\embeddings"
* TestNG is used as Unit Testing tool for the Test suite execution
* In testNG xml there is a Suite by name BDD Test Suite and Test by name Test which has the TestRunner class added in it 
* pom.xml is present at the project level which has all the dependencies for the jars required for the execution and also has maven surefire plugin for the test executions and cucumber reporting plugins for report generations and testNg.xml is also linked in the same

###### License ###### 
I have used open source softwares.

###### Instructions for Test execution in windows ###### 
* Go to Eclipse,Right click on pom.xml present at the project level ->Run As -> Maven install 
* If the build is failed then please update the maven project from eclipse as i mentioned before in this document and repeat the above step
* Check for the test reports and screenshots for failed tests cases(if any) in the mentioned paths
* Currently all the test cases are passing and hence cannot see the failed test screenshots.
* Alternatively can run the tests from command prompt as below
* Go to command prompt and navigate to the ITV folder where it is saved on your local machine (Please make sure you are at the project level where it has pom.xml in it)
* Run the command "mvn test" for executing the tests and output will be displayed
*If the build is failed then please update the maven project from eclipse as i mentioned before in this document and re run command "mvn test" and observe the results


###### Enhancements to make framework better ######
* Excel integration if needed
* Jenkins for continuous integration


###### Note ######
* Please logout if ITVHub website is open in any of the browsers where you have already logged in with valid credentials.Just to make sure the saved credentials will not disturb the automation execution.