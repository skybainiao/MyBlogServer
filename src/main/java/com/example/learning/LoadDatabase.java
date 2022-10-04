package com.example.learning;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            User bob = new User("Bob Buffalo", "Software Engineer");
            User alice = new User("Alice Anaconda", "Product Owner");
            User chen = new User("Junjie Chen", "Scrum Master");
            log.info("Preloading " + userRepository.save(bob));
            log.info("Preloading " + userRepository.save(alice));
            log.info("Preloading " + userRepository.save(chen));
        };
    }
}