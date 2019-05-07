package com.kgc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class IndexController {
	@Autowired
	private EurekaClient client;
	
	@RequestMapping("/hello")
	public String say() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
	@RequestMapping("/test")
    public String testClient() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("SERVICEAPP1", false);
        return instanceInfo.getHomePageUrl();
    }
}
