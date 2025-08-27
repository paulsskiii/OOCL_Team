# How to Run Your Spring Boot Code in VS Code

## Step 1: Set Up Your Environment

**Install the "Extension Pack for Java":**  
Open the Extensions view (`Ctrl+Shift+X`) and search for Extension Pack for Java. This is a crucial bundle that includes a Java compiler, a debugger, and the Spring Boot Extension Pack.  

**Restart VS Code:**  
Once the extensions are installed, it's a good idea to restart VS Code to make sure everything is properly loaded.  

---

## Step 2: Create a New Spring Boot Project
1
Open the Command Palette (`Ctrl+Shift+P`) and type **Spring Initializr**.  

Select **"Create a Maven Project"** or **"Create a Gradle Project."** Maven is the most common choice.  

Choose your desired Spring Boot version.  

Enter a project name and then choose the **"Spring Web"** dependency. This is the simplest dependency you need to start a Spring application.  

Select a location on your computer to save the project.  

VS Code will now generate a complete project folder for you.  

---

## Step 3: Place Your Code in the Project

Take the CoffeeService and CoffeeOrderManager code and put it into the new project.  

Open the project folder in VS Code.  

Navigate to the `src/main/java` folder. See a folder structure that matches the project's package name (e.g., `com.example.demo`).  

Inside this folder, find a file named after your project, `DemoApplication.java`. This is your main application file.  

Create two new Java files in this same folder: `CoffeeService.java` and `CoffeeOrderManager.java`.  

Copy the code for each class into its respective file. Make sure to update the package line at the top of each file to match the project's package name.  

---

## Step 4: Update the Main Application File

The generated `DemoApplication.java` file is the entry point for your application. It contains the main method that starts everything.  

Add the `@Autowired` annotation to the main application class to inject your `CoffeeOrderManager`.  

Modify the `run` method to call your `processOrder` method.  

`DemoApplication.java` will now look something like this:

```java
package com.example.demo; // Make sure this matches the project's package name

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // Spring will automatically inject the CoffeeOrderManager here
    @Autowired
    private CoffeeOrderManager orderManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // This method is called after the Spring application has started
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Application is running and calling the CoffeeOrderManager ---");
        orderManager.processOrder("Latte");
    }
}

---

## Step 5: Run the Application

In VS Code, open the main DemoApplication.java file.

Look for the green "Run" button that appears above the main method.

Click this button.

The Spring Boot application will start, and the output is shown in the VS Code terminal. The framework will read the annotations (@Service and @Component), create the necessary objects, and use the @Autowired annotation to perform the Dependency Injection automatically before running the code in the run method.