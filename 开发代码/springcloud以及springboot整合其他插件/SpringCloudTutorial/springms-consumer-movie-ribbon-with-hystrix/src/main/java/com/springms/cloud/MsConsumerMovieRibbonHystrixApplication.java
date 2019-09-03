package com.springms.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 电影 Ribbon 微服务集成 Hystrix 断路器实现失败快速响应，达到熔断效果。
 *
 * 注解 EnableCircuitBreaker 表明需要集成断路器模块；
 *
 * @author hmilyylimh
 *
 * @version 0.0.1
 *
 * @date 2017/9/21
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MsConsumerMovieRibbonHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerMovieRibbonHystrixApplication.class, args);
		System.out.println("【【【【【【 电影微服务-Hystrix 】】】】】】已启动.");
	}
}




/****************************************************************************************
 一、电影 Ribbon 微服务集成 Hystrix 断路器实现失败快速响应，达到熔断效果：

 1、注解：EnableCircuitBreaker、HystrixCommand 的编写；
 2、启动 springms-provider-user 模块服务，启动1个端口；
 3、启动 springms-consumer-movie-ribbon-with-hystrix 模块服务；
 4、在浏览器输入地址http://localhost:8070/movie/1，然后页面的信息是否有打印出来用户的Id=0的情况，正常情况下是没有用户Id=0的情况信息打印的；

 5、杀死 springms-provider-user 模块服务，停止提供服务；
 6、在浏览器输入地址http://localhost:8070/movie/1，然后页面的信息是否有打印出来用户的Id=0的情况，等了1秒中后有用户Id=0的情况信息打印出来；

 7、等一会儿在启动 springms-provider-user 模块服务，启动1个端口；
 8、在浏览器输入地址http://localhost:8070/movie/1，然后页面的信息又有Id!=0的用户信息打印出来；

 总结：当远端微服务宕机或者不可用时，Hystrix已经达到快速响应快速失败，起到了熔断机制的效果。
 ****************************************************************************************/





