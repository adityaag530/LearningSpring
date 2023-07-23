package com.learning.springcoredemo.rest;

import com.learning.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author adityagupta
 * @date 10/07/23
 */
@RestController
public class DemoRestController {

    // define a field for dependency - if we use @Autowired here then it will be called field injection and is not recommended by spring
    private final Coach myCoach;
    private final Coach theAnotherCoach;

    // define constructor for dependency injection
    // @Autowired - tell the spring to inject the dependency
    // if you have only one constructor then @Autowired is optional
    /*Behind the scene of spring framework: - constructor injection
    * Coach theCoach = new CricketCoach();
    * DemoRestController demoRestController = new DemoRestController(theCoach);
    * */
    @Autowired
    public DemoRestController(@Qualifier("watery") Coach theCoach,
                              @Qualifier("baseballCoach") Coach theAnotherCoach){
        //@Qualifer("") is used to specify which implementation to inject.
        //@Primary can be used at the top of implementation class level to specify that this will be auto injected by
        //      spring if no qualifer is passed. e.g go to cricketcoach class

        this.myCoach = theCoach;
        this.theAnotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    String check(){
        return "Comparing beans: myCoach == theAnotherCoach, " + (myCoach == theAnotherCoach);
        // singleton - true, prototype - false
    }

    /*
    * setter injection - injection dependencies through autowiring setter methods
    * @Autowired
    * public void setCoach(Coach theCoach) {
    * myCoach = theCoach;
    * }
    *
    * behind the scenes of setter injection:-
    * Coach theCoach = new CricketCoach();
    * DemoController demoController = new DemoController();
    * demoController.setCoach(theCoach);
    *
    * constructor - when you have required dependency and generally used
    * setter - when dependency is not provided or external dependencies is used
    *
    * bean scopes : singleton(default) - look for chad's bean scopes video/resource
    *             - scope means lifecycle of bean
    *             - how long does the bean live
    *             - how many instances of bean
    *             - how bean is shared
    * explicitly change bean scope : @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    * common type of scopes: singleton, prototype, request, session, global-session
    *
    * Bean Life Cycle Methods - first define your method for init and destroy
    *                         - @PostConstruct and @PreDestroy
    *
    * java config bean - used when using third party objects which only jar is available - like amazon s3 client
    * create @Configuration class - @Bean - @Autowired
    *
    * ----------------------------------
    * HIBERNATE/orm - a framework for persisting/saving java objects in a database
    *               - handles all low-level sql
    *               - minimizes the amount of JDBC code you have to deploy
    *               - provides object-to-relational mapping(orm)  i.e. student class to student table in db
    *
    * JPA - Jakarta/java Persistence API
    *     - standard API for orm
    *     - vendor locking(when abc leave switch to xyz)
    * only a specification - defines set of interface and require implementaion to be usable
    * i.e. hibernate is an implementation of JPA
    *
    * Saving a java object with jpa:
    * //create java object
    * Student theStudent = new Student("a", "b", "ab@c.com")
    * //save it to database - entityManager is a special jpa helper object
    * entityManager.persist(theStudent)  -- data will be stored in database sql insert
    *
    * //retrieving java object with jpa
    * int theId = 1;
    * Student myStudent = entityManager.find(Student.class, theId);
    *
    * //hibernate/jpa and jdbc - both uses jdbc under their hood
    *
    * hibernate is the default implementation in spirng
    * dependencies required - MySQL Driver: mysql-connector-j
    *                       - Spring Data JPA: spring-boot-stater-data-jpa
    *
    * application.properties:
    * #No need to give JDBC driver class name Springboot will automatically detect it based on URL
    * spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
    * spring.datasource.username:springstudent
    * spring.datasource.password:springstudent
    *
    * run command line app - command line runner
    * */
}
