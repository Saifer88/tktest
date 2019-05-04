package it.pirris.tktest.tktestapp.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class LoggerLoader {

    public static Logger logger;

    @PostConstruct
    public void init()
    {
        logger = LoggerFactory.getLogger("TKTest");
    }

    @Bean
    public Logger logger()
    {
        return logger;
    }

}
