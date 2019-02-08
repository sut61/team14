package sut.se.g14.backend;

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

    private Validator validator;


	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
/*
	@Test
    public void testFristNameNull() {
		MoneyEntity m = new MoneyEntity();
		m.setnameArtist(null);
		m.setnameDress("nameDress");
	    m.setpriceExpenses(1000000);
		m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    @Test
    public void testNameMin() {
		MoneyEntity m = new MoneyEntity();
		m.setnameArtist("");
		m.setnameDress("a");
	    m.setpriceExpenses(1000000);
		m.setpriceIncome(1000000);
        try {
            entityManager.persist(m);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    */


//========================================== test sprint2 contract =======================================
    @Test
        public void tesDataSuccessfully() {
        ContractArtistEntity c1 = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
        c1.setManager(m);
        c1.setnameArtist("abcd");
        c1.setHiremoney("1,000");
        c1.setTypecontract("abcd");
        c1.setnameManager("ab");

        entityManager.persist(c1);
        entityManager.flush();

    
        System.out.println("Save data successfully\n\n");
        
    }
    
    //======================== Null ====================================================

        @Test//ค่า null
        public void testNameArtistNull() { 
        ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist(null);//ผิด
            c.setHiremoney("100,000");
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
        public void tesHiremoneyNull() { 
        ContractArtistEntity c = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
        c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney(null);//ผิด
            c.setTypecontract("abcd");
            c.setnameManager("ab");

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println(">>>"+e+"<<<");
                System.out.println("=====Value hiremoney must not be null to be valid\n\n");
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
            c.setHiremoney("100,000");
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
            c.setHiremoney("100,000");
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
            c1.setHiremoney("1,000");
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

    //================================== Size=============================================
        //=====================manager test size===========================
            @Test//ยาวเกินไป nameManager
            public void testNameManagerMax() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("100,000");
            c.setTypecontract("abcd");
            c.setnameManager("aabcdefghijklnmop");//ผิด

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("nameManager must not be maximum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }

            @Test//สั้นเกินไป nameManager
            public void testNameManagerMin() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("100,000");
            c.setTypecontract("abcd");
            c.setnameManager("");//ผิด

            try {
                entityManager.persist(c);
                entityManager.flush();
                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("nameManager must not be minimum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }
        //=========================end manager test size================
         
        //=====================typecontract size ==============
            @Test//ยาวเกินไป Typecontract
            public void testTypecontractMax() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("1,000");
            c.setTypecontract("abcdefghijklnmop");//ผิด
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("Typecontract must not be maximum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }

            @Test//สั้นเกินไป Typecontract
            public void testTypecontractMin() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("1,000");
            c.setTypecontract("a");//ผิด
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("Typecontract must not be minimum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }
        //=========================end typecontract test size ==========
        
        //========================== hire test size ============== 
            @Test//สั้นเกินไป Hiremoney
            public void testHiremoneyMin() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("100");//ผิด
            c.setTypecontract("abcd &");
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("Hiremoney must not be minimum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }

            @Test//ยาวเกินไป Hiremoney
            public void testHiremoneyMax() {
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("abcd");
            c.setHiremoney("1000000000000000000000000000");//ผิด
            c.setTypecontract("abcd &");
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("Hiremoney must not be maximum digit to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }
        //====================== end hire test size ==============

        //======================== firstname size tset ===================
            @Test//ยาวเกินไป nameArtist
            public void testNameArtistMax() { 
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("aaaaaaaaaaaaaaaaaaaaaaa");//ผิด
            c.setHiremoney("100,000");
            c.setTypecontract("abcd");
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====nameArtist must not be maximum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }
            @Test//สั้นเกินไป nameArtist
            public void testNameArtistMin() { 
            ContractArtistEntity c = new ContractArtistEntity();
            Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
            c.setnameArtist("a");//ผิด
            c.setHiremoney("100,000");
            c.setTypecontract("abcd");
            c.setnameManager("ab");

            try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("=====nameArtist must not be minimum to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            }
            }
        //================end firstname test ======================================

    //========================== End test Size====================================
        

    //============================= pattern test =============================
        @Test//namesrtist ไม่ตรงตาม pattern 
        public void testNameArtistNotPattern() { 
        ContractArtistEntity c = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
        c.setManager(m);
        c.setnameArtist("aaฟหก");//ผิด
        c.setHiremoney("100,000");
        c.setTypecontract("abcd");
        c.setnameManager("ab");

        try {
        entityManager.persist(c);
        entityManager.flush();
        fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
        System.out.println(">>>"+e+"<<<");
        System.out.println("=====nameArtist must not be pattern to be valid\n\n");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        }
        }

        @Test//Hiremoney ไม่ตรงตาม pattern 
        public void testHiremoneyNotPattern() { 
        ContractArtistEntity c = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
        c.setManager(m);
        c.setnameArtist("abcd");
        c.setHiremoney("100,000 บาท");//ผิด
        c.setTypecontract("abcd");
        c.setnameManager("ab");

        try {
        entityManager.persist(c);
        entityManager.flush();
        fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
        System.out.println(">>>"+e+"<<<");
        System.out.println("=====Hiremoney must not be pattern to be valid\n\n");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        }
        }
    
    
        @Test//type ไม่ตรงตาม pattern 
        public void testTypeNotMatchPattern() { 
        ContractArtistEntity c = new ContractArtistEntity();
        Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c.setManager(m);
        c.setnameArtist("abcd");
        c.setHiremoney("100,000 baht");
        c.setTypecontract("ฟหกด");//ผิด
        c.setnameManager("ab");

        try {
            entityManager.persist(c);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println(">>>"+e+"<<<");
            System.out.println("Typecontract must not be pattern to be valid\n\n");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        }

        @Test//nameManager ไม่ตรงตาม pattern 
        public void testnameManagerNotPattern() { 
        ContractArtistEntity c = new ContractArtistEntity();
        Manager m = new Manager();
        m = managerRepository.findByUsername("mimi");
        c.setManager(m);
        c.setnameArtist("abcd");
        c.setHiremoney("100,000");
        c.setTypecontract("abcd");
        c.setnameManager("ศิลปิน");//ผิด

        try {
        entityManager.persist(c);
        entityManager.flush();
        fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
        System.out.println(">>>"+e+"<<<");
        System.out.println("=====nameManager must not be pattern to be valid\n\n");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        }
        }
    //================================ end pattern test =======================



        @Test(expected=javax.persistence.PersistenceException.class)
        public void testnameArtistMustBeUnique() {
        ContractArtistEntity c1 = new ContractArtistEntity();
        Manager m = new Manager();
            m = managerRepository.findByUsername("mimi");
            c1.setManager(m);
        c1.setnameArtist("abcd");//ซ้ำ
        c1.setHiremoney("9999");
        c1.setTypecontract("abcd");
        c1.setnameManager("ab");

        entityManager.persist(c1);
        entityManager.flush();

        ContractArtistEntity c2 = new ContractArtistEntity();
        
            m = managerRepository.findByUsername("mimi");
            c2.setManager(m);
            c2.setnameArtist("abcd");//ซ้ำ
            c2.setHiremoney("9999");
            c2.setTypecontract("abcd");
            c2.setnameManager("ab");

        
        System.out.println("Test nust be Unique\n\n");
        entityManager.persist(c2);
        entityManager.flush();

        fail("Should not pass to this line");
        
        }

        

        

//========================================== End test =====================================================


}

