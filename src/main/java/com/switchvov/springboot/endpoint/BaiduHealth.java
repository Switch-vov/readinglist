package com.switchvov.springboot.endpoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义健康端点--Baidu健康指示器
 * Created by Switch on 2017/6/11.
 */
@Component
public class BaiduHealth implements HealthIndicator {
    @Override
    public Health health() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://www.baidu.com", String.class);
            return Health.up().build();
        } catch (Exception e) {
            return Health.down().withDetail("reason", e.getMessage()).build();
        }
    }
}
