package com.learning.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootAppliation - enable three things
* @EnableAutoConfiguration - Auto configuration
* @ComponentScan - Componenet Scanning (same level and sub packages i.e. com.learning.springcoredemo)
* 				 - explicitly we can mention which base packages to scan using comma separated delimited
* @Configuration - Additional Configuration
* */
/*@SpringBootApplication(
		scanBasePackages = {"com.learning.springcoredemo",
		"com.learningSpring.util"}
)
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		/*SpringApplication - bootstrap your application
		* Behind the scenes:
		* 	- it creates application context and register all beans
		* 	- strats the embedded tomcat server etc
		* */
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
