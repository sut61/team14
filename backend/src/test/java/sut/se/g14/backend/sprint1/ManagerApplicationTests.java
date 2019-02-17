package sut.se.g14.backend.sprint1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import sut.se.g14.entity.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.g14.repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ManagerApplicationTests {
    @Autowired private TestEntityManager entityManager;
    @Autowired private GenderRepository genderRepository;
    @Autowired private TypeContactRepository typeContactRepository;
    @Autowired private ContactRepository contactRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //===== Manager =====
    @Test
    public void testManagerAddData() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("PasswordTest");
        manager.setName("Firstname LastName");
        manager.setGender(gender);
        entityManager.persist(manager);
        entityManager.flush();
    }

    @Test
    public void testManagerPasswordCannotMatchPattern() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("Password123@");
        manager.setName("Firstname LastName");
        manager.setGender(gender);
        try {
            entityManager.persist(manager);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Manager Password Cannot Match Pattern\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testManagerUsernameCannotBeNull() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername(null);
        manager.setPassword("PasswordTest");
        manager.setName("Firstname Lastname");
        manager.setGender(gender);
        try {
            entityManager.persist(manager);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Manager Username Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testManagerPasswordSizeCannotLowerThanMin() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("abc");
        manager.setName("Firstname Lastname");
        manager.setGender(gender);
        try {
            entityManager.persist(manager);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Manager Password Size Cannot Lower Than Min\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testManagerNameCannotMatchPattern() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("Password123");
        manager.setName("Firstname LastName@");
        manager.setGender(gender);
        try {
            entityManager.persist(manager);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Manager Name Cannot Match Pattern\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testManagerUsernameMustBeUnique() {
        Gender gender = genderRepository.findById(1L);

        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("Password123");
        manager.setName("hana mana");
        manager.setGender(gender);
        entityManager.persist(manager);
        entityManager.flush();

        Manager manager1 = new Manager();
        manager1.setUsername("UsernameTest");
        manager1.setPassword("Password");
        manager1.setName("sun shine");
        manager1.setGender(gender);

        try {
            entityManager.persist(manager1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println(e);
            System.out.println("Manager Username Must Be Unique\n\n");
        }
    }

    @Test
    public void testManagerGenderCannotBeNull() {
        Manager manager = new Manager();
        manager.setUsername("UsernameTest");
        manager.setPassword("Password123");
        manager.setName("Firstname LastName");
        manager.setGender(null);
        try {
            entityManager.persist(manager);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Gender Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //===== Contact =====
    @Test
    public void testContactSizeCannotLowerThanMin() {
        TypeContact typeContact = typeContactRepository.findById(2);
        Contact contact = new Contact();
        contact.setContact("1");
        contact.setType(typeContact);
        try {
            entityManager.persist(contact);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Contact Size Cannot Lower Than Min\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //===== TypeContact =====
    @Test
    public void testTypeContactCannotBeNull() {
        TypeContact typeContact = new TypeContact();
        typeContact.setType(null);
        try {
            entityManager.persist(typeContact);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("TypeContact Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //===== Gender =====
    @Test
    public void testGenderCannotBeNull() {
        Gender gender = new Gender();
        gender.setGender(null);
        try {
            entityManager.persist(gender);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Gender Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
