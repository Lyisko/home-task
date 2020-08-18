
Environment setup
--------
1. Install java 1.8
2. Download required WebDrivers: 
 * [Firefox](https://github.com/mozilla/geckodriver/releases)  
 * [Chrome](http://chromedriver.chromium.org)  
 * [Internet Explorer](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver)

Test Execution
--------
1. Clone this project
2. Navigate to project dir
3. Execute `mvn clean verify -Dwebdriver.driver=<driver_name> -Dwebdriver.<driver_name>.driver=<path_to_deriver>` command <br/> (e.g.: `mvn clean verify -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=src/main/resources/chromedriver.exe`)
4. Find test run report in `target/site/serenity/index.html`
