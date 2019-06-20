package com.example.cosmostravel.configuration;

import com.example.cosmostravel.data.Tourist;
import com.example.cosmostravel.repositories.TouristRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(TouristRepository repository) {
        return args -> {
            Tourist tourist = new Tourist();
            tourist.setFirstName("Bob");
            tourist.setLastName("Saggot");
          log.info("Preloading  " + repository.save(tourist));
            Tourist secondTourist = new Tourist();
            secondTourist.setFirstName("John");
            secondTourist.setLastName("Doe");
          log.info("Preloading  " + repository.save(secondTourist));
        };
    }
}
