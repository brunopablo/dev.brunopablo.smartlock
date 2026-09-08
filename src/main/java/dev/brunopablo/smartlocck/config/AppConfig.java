package dev.brunopablo.smartlocck.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value(value = "${app.config.id}")
    private String id;

    @Value(value = "${app.config.secret}")
    private String secret;

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

}