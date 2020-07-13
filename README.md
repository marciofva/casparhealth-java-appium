# Mobile Automation (Android)
---

Caspar-Health app E2E testing project

## Pre-requisites:

- NodeJS
- Java 8
- Appium 
- Appium Doctor
- Maven


---

### Why decided to build in Appium?

First of all, Appium is an automation framework for mobile applications.

- Support many programming languages.
- It is free and open-source.
- Allows to write the same Page Object Model for Android and iOS.


### Conventions and Design Pattern

Now, Let’s thinking about the E2E test layer which consist of covering the major functionalities. Following that, I built a project in which has some automated scenarios. Below follows some important considerations:

- Important to define the Acceptance Criteria first.
- Follows the design pattern which is Page Object Model to organize the code. 
- Thinking about how well refactor the code is
- Code should be manageable.
- Keeping in mind that the code has to be easy to understand. 
- Easy to change.


### Install Appium

```
npm install -g appium@1.7.1
```

### Install Android SDK

Visit the page: [Android download](https://developer.android.com/studio#command-tools)


### Set up the environment variables:

Open `.bash_profile`

```
vim ~/.bash_profile
```

Add the following lines inside the opened file:

```
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$PATH:$JAVA_HOME
export PATH=$PATH:$JAVA_HOME/bin
export ANDROID_HOME=/Users/.../Library/Android/sdk
export ANDROID_SDK=$ANDROID_HOME
PATH=$PATH:$ANDROID_HOME/build-tools
PATH=$PATH:$ANDROID_HOME/tools
PATH=$PATH:$ANDROID_HOME/platform-tools
PATH=$PATH:$ANDROID_HOME/emulator/emulator
PATH=$PATH:$ANDROID_HOME/lib/
PATH=$PATH:$ANDROID_HOME/tools/lib
export PATH
```

Save and run `source` to apply the changes to your current session

```
source ~/.bash_profile
```


### Verifying the Installation

Install Appium doctor

```
npm install -g appium-doctor
```


Run in terminal:

```
appium-doctor --android
```

The output should contain something like this:

```
info AppiumDoctor Appium Doctor v.1.6.0
info AppiumDoctor ### Diagnostic starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
info AppiumDoctor  ✔ Node version is 11.14.0
info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/.../Library/Android/sdk
info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home
info AppiumDoctor  ✔ adb exists at: /Users/.../Library/Android/sdk/platform-tools/adb
info AppiumDoctor  ✔ android exists at: /Users/.../Library/Android/sdk/tools/android
info AppiumDoctor  ✔ emulator exists at: /Users/.../Library/Android/sdk/tools/emulator
info AppiumDoctor  ✔ Bin directory of $JAVA_HOME is set
info AppiumDoctor ### Diagnostic completed, no fix needed. ###
info AppiumDoctor
info AppiumDoctor Everything looks good, bye!
info AppiumDoctor
```


### Starting android device

- Connect a real device via USB or launch an android emulator. 

*Note: For real devices, you have to ensure that Developer mode is turned on for the device.*

To make sure that this device is ready. Run in terminal the following command:

```
adb devices
```

The output should display all devices:

```
List of devices attached
emulator-5554	device
```


### Starting the Appium server

Run in terminal:

```
appium
```


### Running android test suite


```
mvn clean test -DsuiteXmlFile=test-suites/suite.xml
```


### SonarQube _(Code Analysis)_

Visit the page to download **SonarQube 7.1**: [SonarQube download](https://www.sonarqube.org/downloads/)

After downloading, open the downloaded file and access the file regarding your Operation System and start the server in terminal:<br><br/>


- Start Sonar server

```
./sonar.sh start
```

By default will be launch in port **9000**. Launch in browser: `http://localhost:9000`<br><br/>


- Source-code analysis with maven command. Run in terminal:

```
mvn clean
mvn sonar:sonar
```

The output will be like this:

```
[INFO] Analysis report generated in 258ms, dir size=70 KB
[INFO] Analysis reports compressed in 79ms, zip size=28 KB
[INFO] Analysis report uploaded in 118ms
[INFO] ANALYSIS SUCCESSFUL, you can browse http://localhost:9000/dashboard/index/com.casparhealth:casparhealth-mobile-automation
[INFO] Note that you will be able to access the updated dashboard once the server has processed the submitted analysis report
[INFO] More about the report processing at http://localhost:9000/api/ce/task?id=AXNDYdI-okWxERcul7i1
[INFO] Task total time: 9.087 s
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.962 s
[INFO] Finished at: 2020-07-12T11:15:51-03:00
[INFO] ------------------------------------------------------------------------
```



- Access the sonarqube dashboard to view the project’s overview page.<br><br/><br><br/>

- Stop Sonar server

```
./sonar.sh stop
```

