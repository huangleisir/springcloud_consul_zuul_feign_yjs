package com.forezp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by huxinglong on 2018/3/20.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceHelloApplication {

	@RequestMapping("/hello")
	public String home() {
		return "hello ,i'm chinese";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceHelloApplication.class).web(true).run(args);
	}
}
