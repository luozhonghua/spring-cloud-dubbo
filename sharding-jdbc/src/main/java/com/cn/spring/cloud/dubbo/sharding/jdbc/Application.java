package com.cn.spring.cloud.dubbo.sharding.jdbc;

import com.cn.spring.cloud.dubbo.sharding.jdbc.druid.DruidStatsFilter;
import com.cn.spring.cloud.dubbo.sharding.jdbc.druid.DruidStatsServlet;
import com.cn.spring.cloud.dubbo.sharding.jdbc.druid.DruidStatsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 *
 * @author luozhonghua
 * @since 0.0.1
 */
@SpringBootApplication
/**
 * 使用注解@ServletComponentScan
 * 如果不是使用配置的方式，注解@WebServlet/@WebFilter添加Servlet或Filter，需要添加这个注解启用Servlet扫描
 * @see DruidStatsConfig
 * @see DruidStatsServlet
 * @see DruidStatsFilter
 */
public class Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		Thread.sleep(Long.MAX_VALUE);
	}
}
