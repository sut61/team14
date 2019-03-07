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

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest

public class QueueApplicationTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private TypeWorkRepository typeWorkRepository;
    @Autowired
    private StatusRepository statusRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //===== Queue =====
    @Test
    public void testQueueAddData() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));

        TypeWork typeWork = typeWorkRepository.findByTypeworkId(1L);
        Quere quere = new Quere();
        Place newPlace = new Place();

        newPlace.setPlace("suranaree university");
        newPlace.setDate(date2);
        newPlace.setTime(time);
        newPlace.setHour(2);

        quere.setTypeworkQuere(typeWork);
        entityManager.persist(quere);
        entityManager.flush();
    }

    @Test
    public void PlaceCannotBeNull() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace(null);
        place.setDate(date2);
        place.setHour(5);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Place notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }


    @Test
    public void PlacePattern() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("#suranaree");
        place.setDate(date2);
        place.setHour(5);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Place Pattern<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void PlaceSize() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("s");
        place.setDate(date2);
        place.setHour(5);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Place Size<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void DateNotNull() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("suranaree university");
        place.setDate(null);
        place.setHour(5);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Date NotNull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void HourSize() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("suranaree university");
        place.setDate(date2);
        place.setHour(50);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Hour Size<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }


    @Test
    public void HourPositive() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("suranaree university");
        place.setDate(date2);
        place.setHour(-5);
        place.setTime(time);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Hour Positive<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }


    @Test
    public void TimeNotNull() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        place.setPlace("suranaree university");
        place.setDate(date2);
        place.setHour(5);
        place.setTime(null);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Time NotNull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void TypeWorkNotNull() {
        LocalDate local2 = LocalDate.parse("2562-12-11");
        java.sql.Date date2 = java.sql.Date.valueOf(local2);
        Time time = new Time(Integer.parseInt("10"), Integer.parseInt("00"), Integer.parseInt("00"));
        Place place = new Place();
        Quere quere = new Quere();
        TypeWork typeWork = typeWorkRepository.findByTypeworkId(1L);
        place.setPlace("suranaree university");
        place.setDate(date2);
        place.setHour(5);
        place.setTime(null);

        quere.setTypeworkQuere(null);
        try {
            entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> TypeWork NotNull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }

    }

    @Test
    public void InviteCannotBeNull() {
        TableWork tableWork = new TableWork();
        tableWork.setInvite(null);
        tableWork.setPrice(1300L);
        tableWork.setTag("Wowwww");
        try {
            entityManager.persist(tableWork);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Invite notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void StatusCannotBeNull() {
        Status status = new Status();
        status.setStatusQuere(null);
        try {
            entityManager.persist(status);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("----------> Status notnull<--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
        }
    }
}

