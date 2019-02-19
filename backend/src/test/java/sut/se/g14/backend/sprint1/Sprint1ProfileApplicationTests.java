package sut.se.g14.backend.sprint1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;
import javax.persistence.Column;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Sprint1ProfileApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    //Sprint1 Register
    Gender gender = new Gender();
    Country country = new Country();

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();


        //Sprint1 Register
        country.setCountryName("Thailand");
        entityManager.persist(country);
        entityManager.flush();

        gender.setGender("Male");
        entityManager.persist(gender);
        entityManager.flush();
    }

    //============================================== Sprint1 Test Register ====================================================

    @Test
    public void dataCompleteProfile() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            System.out.println("\n\n================================  Complete testDataProfile ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    //========= NULL =========
    @Test
    public void NameCannotBeNull() {
        Profile profile = new Profile();

        profile.setName(null);
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test Name CannotBeNull ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void addressDetailCannotBeNull() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail(null);
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test addressDetail CannotBeNull ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void pastalCodeCannotBeNull() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(null);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test pastalCode CannotBeNull ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void GenderCannotBeNull() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(null);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test Gender CannotBeNull ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void CountryCannotBeNull() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(null);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test Country CannotBeNull ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //========= Pattern =========
    @Test
    public void bomilePhoneMustBePattern() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("091234###Q");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test Phone MustBePattern ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void NameMustBePattern() {
        Profile profile = new Profile();

        profile.setName("Thanyana# @#@");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test Name MustBePattern ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void addressDetailMustBePattern() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912345678");
        profile.setAddressDetail("335 @#$^&*()+ Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test addressDetail MustBePattern ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    //========= Size =========

    @Test
    public void mobilePhoneCannotLowerThanMin() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("0912");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test mobilePhone CannotLowerThanMin ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void mobilePhoneCannotLongerThanMax() {
        Profile profile = new Profile();

        profile.setName("Thanyanan Phonrotchaiphak");
        profile.setMobilePhone("00112233445566778899");
        profile.setAddressDetail("335 Ratchadumnoen Korat");
        profile.setPastalCade(12345L);
        profile.setGender(gender);
        profile.setCountry(country);

        try {
            entityManager.persist(profile);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error test mobilePhone CannotLongerThanMax ================================\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //========= Unique =========

    @Test
    public void testProfileNameMustBeUnique() {

        Profile profile1 = new Profile();

        profile1.setName("Thanyanan Phonrotchaiphak");
        profile1.setMobilePhone("0912345678");
        profile1.setAddressDetail("335 Ratchadumnoen Korat");
        profile1.setPastalCade(12345L);
        profile1.setGender(gender);
        profile1.setCountry(country);
        entityManager.persist(profile1);
        entityManager.flush();

        Profile profile2 = new Profile();

        profile2.setName("Thanyanan Phonrotchaiphak");
        profile2.setMobilePhone("0912345670");
        profile2.setAddressDetail("335 Ratchadumnoen Korot");
        profile2.setPastalCade(12345L);
        profile2.setGender(gender);
        profile2.setCountry(country);

        try {
            entityManager.persist(profile2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\n\n================================  Error test Name MustBeUnique ================================\n");
            System.out.println(e);

        }
    }

//============================================== END Test Sprint1 Register ================================================

}
