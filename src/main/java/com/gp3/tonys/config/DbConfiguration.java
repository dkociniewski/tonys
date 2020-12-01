package com.gp3.tonys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gp3.tonys.db.DaoFacade;
import com.gp3.tonys.db.InMemoryDaoFacade;
import com.gp3.tonys.db.MongoDbDaoFacade;

import dev.morphia.Datastore;

@Configuration
public class DbConfiguration {

    @Bean
    @Profile("memorydb")
    DaoFacade inMemoryDaoFacade() {
        return new InMemoryDaoFacade();
    }

    @Bean
    @Profile("mongodb")
    DaoFacade mongoDbDaoFacade(Datastore datastore) {
        return new MongoDbDaoFacade(datastore);
    }
}
