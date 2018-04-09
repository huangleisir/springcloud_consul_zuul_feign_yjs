package com.forezp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by huanglei on 2018/3/20.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceHelloApplication {

	@RequestMapping("/hello")
	public String home() {
		return "hello ,i'm chinese";
	}
	@RequestMapping("/baidu")
	public String baidu() {
		return "https://www.baidu.com";
	}
	@RequestMapping("/qq")
	public String qq() {
		return "http://www.qq.com";
	}
	@RequestMapping("/163")
	public String wangyi() {
		return "http://www.163.com";
	}
	@RequestMapping("/autohome")
	public String autohome() {
		return "https://www.autohome.com.cn";
	}
	@RequestMapping("/imooc")
	public String imooc() {
		return "https://www.imooc.com/";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceHelloApplication.class).web(true).run(args);
	}
}
