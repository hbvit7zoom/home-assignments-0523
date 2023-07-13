package ru.sberbank.jd.module10.spring.ab.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private String firstValue;
    private DatabaseProperties database;
    @Getter
    @Setter
    static public class DatabaseProperties {
        private String databaseUrl;
        private Boolean mock;
    }
}
