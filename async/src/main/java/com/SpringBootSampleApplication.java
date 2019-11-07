package com;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 *
 * @ClassName: SpringBootSampleApplication
 * @Description: war包部署方式
 * @author lixl
 * @date 2019年4月11日 上午10:06:58
 */
public class SpringBootSampleApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

}