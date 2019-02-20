package sut.se.g14.backend.sprint2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Sprint2ContractApplicationTests {



	@Autowired
    private  MoneyRepository moneyRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private  ContractArtistRepository contractArtistRepository;

    @Autowired
    private  ManagerRepository managerRepository;

    @Autowired
    private  DressRepository dressRepository;

    @Autowired
    private  QuereRepository quereRepository;

    @Autowired
    private  ArtistRepository artistRepository;



    private Validator validator;
    Artists a = new Artists();
    Dress d = new Dress();
    Quere q = new Quere();
    Manager m = new Manager();

    Event event = new Event();
    Sizes size = new Sizes();
    Type type = new Type();
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        event.setEvent("Event");
        entityManager.persist(event);
        entityManager.flush();

        type.setType("Receive");
        entityManager.persist(type);
        entityManager.flush();

        size.setSize("X");
        entityManager.persist(size);
        entityManager.flush();



        q = quereRepository.findById(1);
       entityManager.persist(q);
       entityManager.flush();


        a = artistRepository.findByartistsID(1);
        entityManager.persist(a);
        entityManager.flush();


        m = managerRepository.findByUsername("mimi");
        entityManager.persist(m);
        entityManager.flush();

        d.setArtist(a);
        d.setDress("aaaa");
        d.setEvent(event);
        d.setSize(size);
        d.setType(type);
        entityManager.persist(d);
        entityManager.flush();

        
    }
//========================================== test sprint2 contract =======================================
    @Test
        public void tesDataSuccessfully() {
        ContractArtistEntity c1 = new ContractArtistEntity();

        c1.setManager(m);
        c1.setnameArtist("abcd");
        c1.setHiremoney(1000);
        c1.setTypecontract("abcd");
        c1.setnameManager("ab");

        entityManager.persist(c1);
        entityManager.flush();

    
        System.out.println("Save data SP 2successfully\n\n");
        
    }
    
    //======================== Null ====================================================

        @Test//ค่า null
        public void testNameArtistNull() { 
        ContractArtistEntity c = new ContractArtistEntity();


            c.setManager(m);
            c.setnameArtist(null);//ผิด
            c.setHiremoney(1000);
            c.setTypecontract("abcd");
            c.setnameManager("ab");

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println(">>>"+e+"<<<");
                System.out.println("=====nameArtist must not be null to be valid\n\n");
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }
        }

        @Test//ค่า null
        public void testTypecontractNull() { 
        ContractArtistEntity c = new ContractArtistEntity();

            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney(1000);
            c.setTypecontract(null);//ผิด
            c.setnameManager("ab");

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println(">>>"+e+"<<<");
                System.out.println("=====Typecontract must not be null to be valid\n\n");
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }
        }
        @Test//ค่า null
        public void testnameManagerNull() { 
        ContractArtistEntity c = new ContractArtistEntity();

            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney(1000);
            c.setTypecontract("abcd");
            c.setnameManager(null);//ผิด

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println(">>>"+e+"<<<");
                System.out.println("=====nameManager must not be null to be valid\n\n");
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }
        }

        @Test//ID manager null ManyToOne
            public void testIDmanagerNull() {
            ContractArtistEntity c1 = new ContractArtistEntity();

            c1.setManager(null);//ผิด
            c1.setnameArtist("abcd");
            c1.setHiremoney(1000);
            c1.setTypecontract("abcd");
            c1.setnameManager("ab");
            

            try {
                entityManager.persist(c1);
                entityManager.flush();
    
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println(">>>"+e+"<<<");
                System.out.println("IDmanager must not be null to be valid\n\n");
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);
            }
        }
    //======================End TEST Null =================================================

    //Size
    @Test//ค่า max
    public void testhiremoneyMax() {
        ContractArtistEntity c = new ContractArtistEntity();

        c.setManager(m);
        c.setnameArtist("abcd");
        c.setHiremoney(10000001);//ผิด
        c.setTypecontract("abcd");
        c.setnameManager("abcd");

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====Hiremoney must not be maximum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test//ค่า min
    public void testhiremoneyMin() {
        ContractArtistEntity c = new ContractArtistEntity();

        c.setManager(m);
        c.setnameArtist("abcd");
        c.setHiremoney(100);//ผิด
        c.setTypecontract("abcd");
        c.setnameManager("abcd");

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====Hiremoney must not be minimum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }



    //Unique
        @Test(expected=javax.persistence.PersistenceException.class)
            public void testnameArtistMustBeUnique() {
            ContractArtistEntity c1 = new ContractArtistEntity();

            c1.setManager(m);
            c1.setnameArtist("abcd");//ซ้ำ
            c1.setHiremoney(9999);
            c1.setTypecontract("abcd");
            c1.setnameManager("ab");

            entityManager.persist(c1);
            entityManager.flush();

            ContractArtistEntity c2 = new ContractArtistEntity();
        
            m = managerRepository.findByUsername("mimi");
            c2.setManager(m);
            c2.setnameArtist("abcd");//ซ้ำ
            c2.setHiremoney(9999);
            c2.setTypecontract("abcd");
            c2.setnameManager("ab");

        
            System.out.println("Test nust be Unique\n\n");
            entityManager.persist(c2);
            entityManager.flush();

            fail("Should not pass to this line");
        
        }
//========================================== End test =====================================================


}

