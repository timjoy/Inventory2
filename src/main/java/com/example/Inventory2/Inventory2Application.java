package com.example.Inventory2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Optional;

@SpringBootApplication
public class Inventory2Application {

	private static final Logger log = LoggerFactory.getLogger(Inventory2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Inventory2Application.class);
	}

	@Bean
	public CommandLineRunner demo(ItemRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Item("muffler", "1a"));
			repository.save(new Item("windshield wiper", "3g"));
			repository.save(new Item("hub cap", "9q"));
			repository.save(new Item("squeegee", "2c"));
			repository.save(new Item("catalytic converter", "4t"));

			// fetch all items
			log.info("Items found with findAll():");
			log.info("-------------------------------");
			for (Item item : repository.findAll()) {
				log.info(item.toString());
			}
			log.info("");

			// fetch an individual item by ID
//			Item item = repository.findById(1L);
			Optional<Item> item = repository.findById(1L);
			log.info("Item found with findById(1L):");
			log.info("--------------------------------");
			log.info(item.toString());
			log.info("");

			// fetch items by last name
			log.info("Item found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("muffler").forEach(muffler -> {
				log.info(muffler.toString());
			});

			log.info("");
		};
	}

}

