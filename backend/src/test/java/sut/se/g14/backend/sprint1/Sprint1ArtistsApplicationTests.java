package sut.se.g14.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//==============================================
import sut.se.g14.entity.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.g14.repository.*;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Set;
import javax.validation.ConstraintViolation;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Sprint1ArtistsApplicationTests {

    @Autowired private TestEntityManager entityManager;
    @Autowired private GenderRepository genderRepository;
    @Autowired private  BandRepository bandRepository;
    @Autowired private  TypeMusicRepository typeMusicRepository;
    @Autowired private  ManagerRepository managerRepository;

    Gender gender = new Gender();
    Band band = new Band();
    TypeMusic typeMusic = new TypeMusic();
    Manager manager = new Manager();

    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        band.setBandname("IKON");
        entityManager.persist(band);
        entityManager.flush();

        gender.setGender("Female");
        entityManager.persist(gender);
        entityManager.flush();

        typeMusic.setTypemusics("HIPHOP");
        entityManager.persist(typeMusic);
        entityManager.flush();


   }

    @Test
    public void testMatchArtist() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname("Kim");
        artists.setNickname("BI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Complete testMatchArtists ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
  ////////////////////////////NULL///////////////////////////////////////////////////////
  @Test
  public void testFirstNameNull() throws ParseException {
      Artists artists = new Artists();

      artists.setFirstname(null);
      artists.setLastname("Kim");
      artists.setNickname("BI");
      LocalDate localD = LocalDate.parse("2541-01-01");
      java.sql.Date birthday = java.sql.Date.valueOf(localD);
      artists.setBirthday(birthday);
      artists.setGender(gender);
      artists.setPhone("0847323566");

      artists.setBand(band);
      artists.setTypeMusic(typeMusic);
      try {
          entityManager.persist(artists);
          entityManager.flush();
          System.out.println("\n\n================================  Error test FirstNameMinSize ================================\n");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
      }
  }

    @Test
    public void testLastNameNull() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname(null);
        artists.setNickname("BI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Error test FirstNameMinSize ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNickNameNull() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname("Kim");
        artists.setNickname(null);
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Error test FirstNameMinSize ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
  ////////////////////////////////////////////////SIZE/////////////////////////
    @Test
    public void testFirstNameMinSize() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("H");
        artists.setLastname("Kim");
        artists.setNickname("BI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Error test FirstNameMinSize ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNicknameMaxSize() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname("Kim");
        artists.setNickname("BIBIBIBIBIBIBIBIBIBI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Error test NicknameMaxSize ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
 ///////////////////////////////////////PATTERN////////////////////////////////
    @Test
    public void testPhoneCannotPattern() throws ParseException {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname("Kim");
        artists.setNickname("BI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("asd123456789");

        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists);
            entityManager.flush();
            System.out.println("\n\n================================  Error test PhoneCannotPattern ================================\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
////////////////////////////////////////UNIQUE/////////////////////////////////////////////////////
    @Test
    public void testPhoneMustBeUnique() {
        Artists artists = new Artists();

        artists.setFirstname("Hunbin");
        artists.setLastname("Kim");
        artists.setNickname("BI");
        LocalDate localD = LocalDate.parse("2541-01-01");
        java.sql.Date birthday = java.sql.Date.valueOf(localD);
        artists.setBirthday(birthday);
        artists.setGender(gender);
        artists.setPhone("0847323566");
        artists.setBand(band);
        artists.setTypeMusic(typeMusic);
        entityManager.persist(artists);
        entityManager.flush();

        Artists artists1 = new Artists();

        artists1.setFirstname("Hunbin");
        artists1.setLastname("Kim");
        artists1.setNickname("BI");
        LocalDate localD1 = LocalDate.parse("2541-01-01");
        java.sql.Date birthday1 = java.sql.Date.valueOf(localD1);
        artists1.setBirthday(birthday1);
        artists1.setGender(gender);
        artists1.setPhone("0847323566");
        artists1.setBand(band);
        artists1.setTypeMusic(typeMusic);
        try {
            entityManager.persist(artists1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println(e);
            System.out.println("Phone Must Be Unique\n\n");
        }
    }
}
