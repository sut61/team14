package sut.se.g14.backend;

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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class SponserApplicationTests {

	@Autowired
    private SponserRepository   sponserrepository;

    @Autowired
    private TestEntityManager entityManager;


    private Validator validator;
    Statusdress statusdress = new Statusdress();
    Dress dress = new Dress();
    Artists artists = new Artists();
    Band  band = new Band();
     
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        statusdress.setStatusdress("using");
		entityManager.persist(statusdress);
        entityManager.flush();
        
        dress.setDress("White shirt");
		entityManager.persist(dress);
        entityManager.flush();

        band.setBandname("WINNER");
		entityManager.persistAndFlush(band);
        
        artists.setBand(entityManager.persistFlushFind(band));
		entityManager.persist(artists);
		entityManager.flush();
    }
    
    @Test//ค่า null
    public void testNameSponser() throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
        Sponser s= new Sponser();
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        
        s.setDatereturn(datereturn);

    }
    @Test//ค่า null
    public void testNameSponserNull() throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Sponser s= new Sponser();
        s.setSponser(null);//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testSponserCannotBeNull() ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   @Test//ค่า null
    public void testNameSponserMin() throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Sponser s= new Sponser();
        s.setSponser("a");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testSponserCannotMin4() ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test//null
    public void testStatusdressCannotBeNull() throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Sponser s= new Sponser();
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(null);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testStatusdressCannotBeNull ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test//ยาวเกินไป
    public void testNameSponserNotPatten() throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Sponser s= new Sponser();
        s.setSponser("ฟหกฟ");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testSponserCNotPatten ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test//null
    public void testDressCannotBeNull()throws ParseException{ 
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Sponser s= new Sponser();
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(null);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testDressCannotBeNull ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test//null
    public void testDateFutureOrPresent() throws ParseException{
        Sponser s= new Sponser();
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2560-05-05");
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testDateFutureOrPresent ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    } @Test//null
    public void testArtitsCannotBeNull() throws ParseException{
        Sponser s= new Sponser();
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-02-12");
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(null);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testArtistCannotBeNull ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test//null
    public void testDateReturnFutureOrPresent() throws ParseException{
        Sponser s= new Sponser();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2562-05-05");
        Date datereturn = new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-12");
        s.setSponser("aaaa");//ผิด
        s.setStatusdress(statusdress);
        s.setDress(dress);
        s.setArtists(artists);
        s.setDate(date);
        s.setDatereturn(datereturn);

        try {
            entityManager.persist(s);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("\n\n================================  Error testDatereturnFutureOrPresent ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
}

