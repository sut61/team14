package sut.se.g14.backend.sprint1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.sql.Date;
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
public class DressApplicationTests {

	@Autowired
    private SponserRepository   sponserrepository;

    @Autowired
    private TestEntityManager entityManager;


    private Validator validator;
   
    Event event = new Event();
    Sizes size = new Sizes();
    Type type = new Type();
    Artists a = new Artists(); 

    
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        LocalDate localD = LocalDate.parse("2019-05-05");
        Date b = Date.valueOf(localD);

        a.setFirstname("aaa");
        a.setLastname("aaaa");
        a.setNickname("aaaa");
        a.setPhone("1234567890");
        a.setBirthday(b);
        entityManager.persist(a);
        entityManager.flush();


        event.setEvent("Event");
        entityManager.persist(event);
        entityManager.flush();

        type.setType("Receive");
        entityManager.persist(type);
        entityManager.flush();
        
        size.setSize("X");
        entityManager.persist(size);
        entityManager.flush();

        
    }


    @Test
    public void testDress() { 
        Dress d= new Dress();
        d.setDress("aaaaaA");//ผิด
        d.setSize(size);
        d.setEvent(event);
        d.setType(type);
        d.setArtist(a);
    }


    @Test
    public void testDressNull() { 
        Dress d= new Dress();
        d.setDress(null);//ผิด
        d.setSize(size);
        d.setEvent(event);
        d.setType(type);
        d.setArtist(a);
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(
                    "\n\n================================  Error testDressCannotBeNull() ================================\n\n");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }}

        @Test
        public void testDressPattern() { 
            Dress d= new Dress();
            d.setDress("ฟฟฟฟฟฟ");//ผิด
            d.setSize(size);
            d.setEvent(event);
            d.setType(type);
            d.setArtist(a);
            try {
                entityManager.persist(d);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch (javax.validation.ConstraintViolationException e) {
                System.out.println(
                        "\n\n================================  Error testDressCannotPattern() ================================\n\n");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }}


            @Test
            public void testDressMin() { 
                Dress d= new Dress();
                d.setDress("a");//ผิด
                d.setSize(size);
                d.setEvent(event);
                d.setType(type);
                d.setArtist(a);
                try {
                    entityManager.persist(d);
                    entityManager.flush();
                    fail("Should not pass to this line");
                } catch (javax.validation.ConstraintViolationException e) {
                    System.out.println(
                            "\n\n================================  Error testDressCannotMin() ================================\n\n");
                    System.out.println(e);
                    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                    assertEquals(violations.isEmpty(), false);
                    assertEquals(violations.size(), 1);
                }}

                @Test
            public void testDressMax() { 
                Dress d= new Dress();
                d.setDress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");//ผิด
                d.setSize(size);
                d.setEvent(event);
                d.setType(type);
                d.setArtist(a);
                try {
                    entityManager.persist(d);
                    entityManager.flush();
                    fail("Should not pass to this line");
                } catch (javax.validation.ConstraintViolationException e) {
                    System.out.println(
                            "\n\n================================  Error testDressCannotMax() ================================\n\n");
                    System.out.println(e);
                    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                    assertEquals(violations.isEmpty(), false);
                    assertEquals(violations.size(), 1);
                }}


                @Test
                public void testSizenull() { 
                    Dress d= new Dress();
                    d.setDress("aaaaaaaaaaa");//ผิด
                    d.setSize(null);
                    d.setEvent(event);
                    d.setType(type);
                    d.setArtist(a);
                    try {
                        entityManager.persist(d);
                        entityManager.flush();
                        fail("Should not pass to this line");
                    } catch (javax.validation.ConstraintViolationException e) {
                        System.out.println(
                                "\n\n================================  Error testSizeCannotBeNull() ================================\n\n");
                        System.out.println(e);
                        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                        assertEquals(violations.isEmpty(), false);
                        assertEquals(violations.size(), 1);
                    }}


                    @Test
                public void testEventnull() { 
                    Dress d= new Dress();
                    d.setDress("aaaaaaaaaaa");//ผิด
                    d.setSize(size);
                    d.setEvent(null);
                    d.setType(type);
                    d.setArtist(a);
                    try {
                        entityManager.persist(d);
                        entityManager.flush();
                        fail("Should not pass to this line");
                    } catch (javax.validation.ConstraintViolationException e) {
                        System.out.println(
                                "\n\n================================  Error testEventCannotBeNull() ================================\n\n");
                        System.out.println(e);
                        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                        assertEquals(violations.isEmpty(), false);
                        assertEquals(violations.size(), 1);
                    }}

                    @Test
                    public void testTypenull() { 
                        Dress d= new Dress();
                        d.setDress("aaaaaaaaaaa");//ผิด
                        d.setSize(size);
                        d.setEvent(event);
                        d.setType(null);
                        d.setArtist(a);
                        try {
                            entityManager.persist(d);
                            entityManager.flush();
                            fail("Should not pass to this line");
                        } catch (javax.validation.ConstraintViolationException e) {
                            System.out.println(
                                    "\n\n================================  Error testTypeCannotBeNull() ================================\n\n");
                            System.out.println(e);
                            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                            assertEquals(violations.isEmpty(), false);
                            assertEquals(violations.size(), 1);
                        }}


                        @Test
                    public void testArtistsnull() { 
                        Dress d= new Dress();
                        d.setDress("aaaaaaaaaaa");//ผิด
                        d.setSize(size);
                        d.setEvent(event);
                        d.setType(type);
                        d.setArtist(null);
                        try {
                            entityManager.persist(d);
                            entityManager.flush();
                            fail("Should not pass to this line");
                        } catch (javax.validation.ConstraintViolationException e) {
                            System.out.println(
                                    "\n\n================================  Error testArtistsCannotBeNull() ================================\n\n");
                            System.out.println(e);
                            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                            assertEquals(violations.isEmpty(), false);
                            assertEquals(violations.size(), 1);
                        }}
    

                        
                        @Test(expected = javax.persistence.PersistenceException.class)
                        public void testSizeUnique() { 

                        Sizes size1 = new Sizes();
                        Sizes size2 = new Sizes();
                        size1.setSize("X");
                        entityManager.persist(size1);
                        entityManager.flush();

                        size2.setSize("X");
                        entityManager.persist(size2);


                        System.out.println();
                        System.out.println("----------> SizesBeUnique <--------------------");
                        System.out.println();
                        System.out.println();
                  
                        entityManager.flush();
                        fail("Should not pass to this line");
                    }
                  
            
}