package com.forezp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huxinglong on 2018/3/20.
 */
@FeignClient(value = "service-hello", fallback =SchedualServiceHi.HiError.class)
//@FeignClient(value = "consul-miya")
public interface SchedualServiceHi {
    //@HystrixCommand(fallbackMethod = "fallbackMethodTest")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/baidu",method = RequestMethod.GET)
    String getBaiduFromClientOne(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/qq",method = RequestMethod.GET)
    String getQQFromClientOne(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/163",method = RequestMethod.GET)
    String get163FromClientOne(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/imooc",method = RequestMethod.GET)
    String getImoocFromClientOne(@RequestParam(value = "name") String name);
    
    @RequestMapping(value = "/autohome",method = RequestMethod.GET)
    String getAutohomeFromClientOne(@RequestParam(value = "name") String name);

    @Component
    class HiError implements SchedualServiceHi{
        @Override
        public String sayHiFromClientOne(String name) {
            return "http://www.ifeng.com/";
        }

		@Override
		public String getBaiduFromClientOne(String name) {
			// TODO Auto-generated method stub
			return "http://www.ifeng.com/";
		}

		@Override
		public String getQQFromClientOne(String name) {
			// TODO Auto-generated method stub
			return "http://www.ifeng.com/";
		}

		@Override
		public String get163FromClientOne(String name) {
			// TODO Auto-generated method stub
			return "http://www.ifeng.com/";
		}

		@Override
		public String getImoocFromClientOne(String name) {
			// TODO Auto-generated method stub
			return "http://www.ifeng.com/";
		}

		@Override
		public String getAutohomeFromClientOne(String name) {
			// TODO Auto-generated method stub
			return "http://www.ifeng.com/";
		}
    }
}