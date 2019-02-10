package sut.se.g14.backend;
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

import java.text.ParseException;
import java.util.Set;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PracticeApplicationTests {
    @Autowired private TestEntityManager entityManager;
    @Autowired private GenderRepository genderRepository;
    @Autowired private PracticeRepository practiceRepository;
    @Autowired private TypeContactRepository typeContactRepository;
    @Autowired private ContactRepository contactRepository;

    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testPracticeAddData() throws ParseException {
        Time startTime = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Time endTime = new Time(Integer.parseInt("12"), Integer.parseInt("00"), Integer.parseInt("00"));

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-20");
        Practice practice = new Practice();
        practice.setTrainer("FristName Lastname");
        practice.setDate(date);
        practice.setStartTime(startTime);
        practice.setEndTime(endTime);
        practice.setDetail("abcdefghigk lmnop123");

        //entityManager.persist(practice);
        //entityManager.flush();


        try {
            entityManager.persist(practice);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Add Practice Complete\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeDateCannotBeNull() {
        Time startTime = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Time endTime = new Time(Integer.parseInt("12"), Integer.parseInt("00"), Integer.parseInt("00"));

        Practice practice = new Practice();
        practice.setTrainer("FristName Lastname");
        practice.setDate(null);
        practice.setStartTime(startTime);
        practice.setEndTime(endTime);
        practice.setDetail("abcdefghigk lmnop123");
        try {
            entityManager.persist(practice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Practice Date Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testDateCannotPast() throws ParseException {
        Time startTime = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Time endTime = new Time(Integer.parseInt("12"), Integer.parseInt("00"), Integer.parseInt("00"));

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-20");

        Practice practice = new Practice();
        practice.setTrainer("FristName Lastname");
        practice.setDate(date);
        practice.setStartTime(startTime);
        practice.setEndTime(endTime);
        practice.setDetail("abcdefghigk lmnop123");

        try {
            entityManager.persist(practice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Date Cannot Past\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeNameCannotMatchPattern() throws ParseException {
        Time startTime = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Time endTime = new Time(Integer.parseInt("12"), Integer.parseInt("00"), Integer.parseInt("00"));

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-20");

        Practice practice = new Practice();
        practice.setTrainer("FristName Lastname@#");
        practice.setDate(date);
        practice.setStartTime(startTime);
        practice.setEndTime(endTime);
        practice.setDetail("abcdefghigk lmnop123");
        try {
            entityManager.persist(practice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Practice Name Cannot Match Pattern\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeDetailSizeCannotLowerThanMin() throws ParseException {
        Time startTime = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Time endTime = new Time(Integer.parseInt("12"), Integer.parseInt("00"), Integer.parseInt("00"));

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-20");

        Practice practice = new Practice();
        practice.setTrainer("FristName Lastname");
        practice.setDate(date);
        practice.setStartTime(startTime);
        practice.setEndTime(endTime);
        practice.setDetail("abc");
        try {
            entityManager.persist(practice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Practice Detail Size Cannot Lower Than Min\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTypePracticeCannotBeNull() {
        TypePractice typePractice = new TypePractice();
        typePractice.setType(null);
        try {
            entityManager.persist(typePractice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("TypePractice Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTypeRoomPracticeCannotBeNull() {
        TypeRoomPractice typeroomPractice = new TypeRoomPractice();
        typeroomPractice.setType(null);
        try {
            entityManager.persist(typeroomPractice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("TypeRoomPractice Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomPracticeCannotBeNull() {
        RoomPractice roomPractice = new RoomPractice();
        roomPractice.setRoom(null);
        try {
            entityManager.persist(roomPractice);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("RoomPractice Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testBandCannotBeNull() {
        Band band = new Band();
        band.setBandname(null);
        try {
            entityManager.persist(band);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            System.out.println("Band Cannot Be Null\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
