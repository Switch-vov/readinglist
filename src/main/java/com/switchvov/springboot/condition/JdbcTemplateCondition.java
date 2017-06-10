package com.switchvov.springboot.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Jdbc模板加载条件
 * Created by Switch on 2017/6/4.
 */
@Configuration
public class JdbcTemplateCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 满足条件才创建
     */
    @Conditional(JdbcTemplateCondition.class)
    @Bean
    public MyService myService() {
        return null;
    }

    class MyService {

    }

}
