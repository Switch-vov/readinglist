package com.switchvov.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * ReadingListServlet初始化器
 * Created by Switch on 2017/6/11.
 */
public class ReadingListApplicationBuilder extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReadingListApplication.class);
    }
}
