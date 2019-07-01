package com.iinaq.springboot.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("my")
public class MyHealthIndicator implements HealthIndicator {

    private static final String VERSION="v0.0.9";

    @Override
    public Health health(){
        int code = check();
        if (code!=0){
            Health.down().withDetail("code",code).withDetail("version",VERSION).build();
        }
        return Health.up().withDetail("code",code).withDetail("version",VERSION).up().build();
    }

    private int check(){
        return 0;
    }
}
