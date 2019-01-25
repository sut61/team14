package sut.se.g14;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ArtistRepository artistRepository, ContactRepository contactRepository, GenderRepository genderRepository,
						   ManagerRepository managerRepository, TypeContactRepository typeContactRepository) {
		return args -> {
			Stream.of("Male", "Female").forEach(gender -> {
				Gender newGender = new Gender();
				newGender.setGender(gender);
				genderRepository.save(newGender);
			});

			Stream.of("Tel.", "Email", "Facebook", "Twitter", "Instagram", "Line").forEach(type -> {
				TypeContact newType = new TypeContact();
				newType.setType(type);
				typeContactRepository.save(newType);
			});

			Stream.of("mimi").forEach(username -> {
				Gender gender = genderRepository.findById(2L);
				Manager newManager = new Manager();
				newManager.setName("mini mimi");
				newManager.setGender(gender);
				newManager.setUsername(username);
				newManager.setPassword("12345678");
				managerRepository.save(newManager);

				Contact newContact = new Contact();
				Manager manager = managerRepository.findByUsername(username);
				TypeContact type = typeContactRepository.findById(4L);

				newContact.setContact("@mimini");
				newContact.setType(type);
				contactRepository.save(newContact);
				manager.getContactSet().add(newContact);
				managerRepository.save(manager);
			});

			artistRepository.findAll().forEach(System.out::println);
			genderRepository.findAll().forEach(System.out::println);
			typeContactRepository.findAll().forEach(System.out::println);
			contactRepository.findAll().forEach(System.out::println);
			managerRepository.findAll().forEach(System.out::println);

		};
	}

}

