package ru.sberbank.jd.module10.spring.ab.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import ru.sberbank.jd.module10.spring.ab.repository.DbTaskRepository;
import ru.sberbank.jd.module10.spring.ab.repository.MockTaskRepository;
import ru.sberbank.jd.module10.spring.ab.repository.TaskRepository;
import ru.sberbank.jd.module10.spring.ab.service.FightingService;
import ru.sberbank.jd.module10.spring.ab.service.FriendlyService;

@Configuration
@EnableConfigurationProperties(value = AppProperties.class)
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "app.database.mock", havingValue = "true")
    public TaskRepository mockTaskRepository() {
        return new MockTaskRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    public TaskRepository dbTaskRepository() {
        return new DbTaskRepository();
    }



//    @Bean(name = "myBean")
//    @Bean
////    @Primary
//    public FriendlyService friendlyService() {
//        return new FriendlyService();
//    }

//    @Bean
//    public FriendlyService friendlyService2() {
//        return new FriendlyService();
//    }

//    @Bean
//    public FightingService fightingService(FriendlyService friendlyService) {
//        return new FightingService(friendlyService);
//    }

}
