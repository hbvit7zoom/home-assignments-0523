package ru.sberbank.jd.module10.spring.ab.service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module10.spring.ab.config.AppProperties;

@Service
public class FightingService implements InitializingBean {
    private Logger logger = LoggerFactory.getLogger(FightingService.class);
//    @Autowired
//    @Qualifier(value = "friendlyService")
    private FriendlyService friendlyService;

    private AppProperties properties;

    @Value("${app.prop1}")
    private Integer myPropValue;

    public FightingService(FriendlyService friendlyService, AppProperties properties) {
        this.friendlyService = friendlyService;
        this.properties = properties;
    }

    public void makeFight() {
        System.out.println("We are fighting now.");
    }

    @PostConstruct
    public void test() {
        friendlyService.makeFriend();
        logger.info("myPropValue={}", myPropValue);
        logger.info("myFirstValue={}", properties.getFirstValue());
        logger.info("databaseUrl={}", properties.getDatabase().getDatabaseUrl());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
