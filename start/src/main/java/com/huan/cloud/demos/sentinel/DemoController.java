package com.huan.cloud.demos.sentinel;

import com.alibaba.cloud.demo.sentinel.api.FooService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DemoController {

    @DubboReference
    private FooService fooService;

    @Autowired
    private DemoService demoService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/hello")
    public String apiSayHello(@RequestParam String name) {
        return fooService.sayHello(name);
    }

    @GetMapping("/aa")
	@SentinelResource("aa")
	public String aa(int b, int a) {
		return "Hello test";
	}

    @GetMapping("/test")
	public String test1() {
		return "Hello test";
    }
    
    @GetMapping("/template")
    public String client() {
        return restTemplate.getForObject("http://www.taobao.com/test", String.class);
    }

    @GetMapping("/slow")
    public String slow() {
        return circuitBreakerFactory.create("slow").run(() -> {
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "slow";
        }, throwable -> "fallback");
    }

    @GetMapping("/bonjour/{name}")
    public String apiSayHelloLocal(@PathVariable String name) {
        return demoService.bonjour(name);
    }

    @GetMapping("/time")
    public long apiCurrentTime(@RequestParam(value = "slow", defaultValue = "false") Boolean slow) {
        return fooService.getCurrentTime(slow);
    }
}
