package com.getoze.task.management;

import com.getoze.task.management.service.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ServiceConfig.class})
@SpringBootApplication(scanBasePackages ={"com.getoze.task.management.web"} )
public class OzeTaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OzeTaskManagementApplication.class, args);
	}

}
