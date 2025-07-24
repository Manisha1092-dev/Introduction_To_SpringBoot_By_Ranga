# Introduction_To_SpringBoot_By_Ranga


The challenges faced in application development before Spring Boot:

1.  Dependency Management: Developers had to manually manage various dependencies like the Spring framework and testing libraries, often requiring detailed configuration in a POM XML file.

2.  Configuration Requirements: The necessity for a web.xml file to configure web applications, including setting up dispatcher servlets, component scanning, view resolvers, and data sources for databases.

3.  Non-Functional Requirements: The importance of manually implementing logging, error handling, and monitoring, which added complexity to the project setup.

4.  Time Consumption: Setting up a project could take several days, with ongoing maintenance requiring significant additional work.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Q:  What were the two major types of configurations required in a Spring project before Spring Boot?

A:  The configurations required in a Spring project before Spring Boot:

XML Configuration: Before Spring Boot, developers had to set up a web.xml file for defining servlets and application context configurations, which could become complex and cumbersome. This meant detailing every configuration manually.

Java Configuration: Additionally, Java-based configurations were also required to set up aspects like component scanning, view resolvers, and data sources. Developers often needed to create multiple configuration classes and utilize annotations to set up the environment.

These two types of configurations made the process of developing Spring applications more time-consuming and complicated.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Q:  Explain how springboot achieve automatic configuration with example in details?

A:  Spring Boot’s automatic configuration is one of its most powerful and magical features. It dramatically simplifies the development of Spring-based applications by minimizing the amount of configuration you need to do manually. Let's break it down clearly and thoroughly.

🌱 What Is Automatic Configuration?
Spring Boot uses a mechanism called Auto Configuration to set up your application based on the dependencies you add in your pom.xml or build.gradle file. It works hand-in-hand with Spring's @Configuration classes and the Spring Environment.

At startup, Spring Boot scans the classpath and attempts to guess what configurations your application needs—then automatically wires them up.

⚙️ How It Works (Step-by-Step)
Here's how Spring Boot achieves automatic configuration internally:

1.  @EnableAutoConfiguration Annotation

This annotation is typically present in your main class via @SpringBootApplication, which is a combo of three annotations:

java

@SpringBootApplication

// Internally includes:

@EnableAutoConfiguration

@ComponentScan

@Configuration

This tells Spring Boot to start looking for auto-configuration classes.

2.  spring.factories File

Inside spring-boot-autoconfigure.jar, there’s a file located at:
META-INF/spring.factories

This file lists all available auto-configuration classes like:
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration

These classes are conditionally applied based on the presence or absence of certain classes or properties.

3.  @Conditional Annotations

Auto-config classes use @ConditionalOnClass, @ConditionalOnMissingBean, and similar annotations to ensure configuration is only applied when appropriate.



🧪 Example: Auto-configuring a Web Application
Let’s say you want to build a simple web app with embedded Tomcat and Spring MVC.

🔧 Step 1: Add Dependencies
In pom.xml:

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
Spring Boot sees this and detects:

>  You want a web server

>  You want Spring MVC

So it automatically configures:

>  Embedded Tomcat

>  DispatcherServlet

>  Default MVC configuration (view resolvers, message converters, etc.)

🎯 Step 2: Create the Application Class

@SpringBootApplication

public class MyWebApp {

public static void main(String[] args) {

SpringApplication.run(MyWebApp.class, args);

}

}

You don’t have to manually configure DispatcherServlet or Tomcat. It just works!

🎉 Result
You can create a controller like this and start serving web pages:


@RestController

public class HelloController {

@GetMapping("/hello")

public String greet() {

return "Hello, Spring Boot!";

}

}


Hit /hello in your browser, and you'll get a working response—with zero XML config!


🛠️ Customizing Auto Configuration

If Spring Boot’s default setup doesn't match your needs:

You can override it by defining your own beans.

Use @ConditionalOnMissingBean to allow fallback logic.

Disable specific auto configs using:

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
