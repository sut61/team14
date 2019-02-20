package sut.se.g14.backend.sprint1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class MoneyApplicationTests {
    @Autowired
    private MoneyRepository moneyRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContractArtistRepository contractArtistRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DressRepository dressRepository;

    @Autowired
    private QuereRepository quereRepository;

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
    //==================================== Start test sprint1 ==============================================
    @Test//ผ่าน
    public void testDataSuccessSP1() {
        MoneyEntity m = new MoneyEntity();


        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("abcd");
        m.setnameDress("nameDress");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);

        entityManager.persist(m);
        entityManager.flush();


        System.out.println("Save data SP1 successfully\n\n");


    }


    //============================positive
    @Test//เช็คค่าติดลบ
    public void testpriceIncomeNotPossitive() {
        MoneyEntity m = new MoneyEntity();


        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("null");
        m.setnameDress("nameDress");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(-1);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====priceIncome must not be possitive to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //===================================================
    //===========================test Null
    @Test
    public void testfirstnameNull() {
        MoneyEntity m = new MoneyEntity();


        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist(null);//ผิด
        m.setnameDress("nameDress");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
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

    @Test
    public void testnameDressNull() {
        MoneyEntity m = new MoneyEntity();

        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("abcd");
        m.setnameDress(null);//ผิด
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====nameDress must not be null to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIDartistNull() {
        MoneyEntity m = new MoneyEntity();

        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(null);//ผิด
        m.setnameArtist("abcd");
        m.setnameDress("abcd");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====IDartist must not be null to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIDdressNull() {
        MoneyEntity m = new MoneyEntity();

        m.setIdQueue(q);
        m.setIdDress(null);//ผิด
        m.setIdArtist(a);
        m.setnameArtist("abcd");
        m.setnameDress("abcd");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====IDdress must not be null to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testIDquereNull() {
        MoneyEntity m = new MoneyEntity();

        m.setIdQueue(null);//ผิด
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("abcd");
        m.setnameDress("abcd");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====IDquere must not be null to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    //========================end test null==============================
    //===========================test size


    @Test//เช็คminสุด
    public void testpriceExpensesmin() {
        MoneyEntity m = new MoneyEntity();


        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("null");
        m.setnameDress("nameDress");
        m.setpriceExpenses(0);//ผิด
        m.setpriceIncome(100000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====priceExpenses must not be minimum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test//เช็คmaxสุด
    public void testpriceIncomemax() {
        MoneyEntity m = new MoneyEntity();


        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);
        m.setnameArtist("null");
        m.setnameDress("nameDress");
        m.setpriceExpenses(1000000);
        m.setpriceIncome(1000000000);//ผิด
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====priceIncome must not be maximmum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    //========================end test size ===============================


//======================================end test sprint 1 ==============================================

}

