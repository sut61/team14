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
public class BackendApplicationTests {



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
    Band b = new Band();
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        d.setDress("dress");
        entityManager.persist(d);
        entityManager.flush();

        b.setBandname("bandname");
        entityManager.persistAndFlush(b);
        


       //q.setId(1);
       q.setBandQuere(entityManager.persistAndFlush(b));
       entityManager.persist(q);
       entityManager.flush();
        

        a.setFirstname("firstname");
        entityManager.persist(a);
        entityManager.flush();
        
    }
//==================================== Start test sprint1 ==============================================
    @Test//ผ่าน
        public void testDataSuccessSP1() {
        MoneyEntity m = new MoneyEntity();
        a = artistRepository.findByfirstname("firstname");

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
        a = artistRepository.findByfirstname("firstname");
    
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
        a = artistRepository.findByfirstname("firstname");
        
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
        a = artistRepository.findByfirstname("firstname");
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
        a = artistRepository.findByfirstname(null);
        m.setIdQueue(q);
        m.setIdDress(d);
        m.setIdArtist(a);//ผิด
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
        a = artistRepository.findByfirstname("firstname");
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
        a = artistRepository.findByfirstname("firstname");
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
        a = artistRepository.findByfirstname("firstname");
    
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
        a = artistRepository.findByfirstname("firstname");
    
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

//========================================== test sprint2 contract =======================================
    @Test
        public void tesDataSuccessfully() {
        ContractArtistEntity c1 = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
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
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
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
        Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
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
        Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
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
            Manager m = new Manager();
            m = managerRepository.findByUsername(null);
            c1.setManager(m);//ผิด
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
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
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
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
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
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
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

