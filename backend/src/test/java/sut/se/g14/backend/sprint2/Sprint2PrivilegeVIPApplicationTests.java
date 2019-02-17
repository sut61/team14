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
public class Sprint2PrivilegeVIPApplicationTests {


	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	//Sprint2 PrivilegeVIP
	TypePrivilege typePrivilege = new TypePrivilege();
	Band band = new Band();
	DateExpMonth dateExpMonth = new DateExpMonth();
	DateExpYear dateExpYear = new DateExpYear();


	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();


		//Sprinnt2 PrivilegeVIP
		typePrivilege.setTypePrivilege("Special Concert");
		entityManager.persist(typePrivilege);
		entityManager.flush();

		band.setBandname("BLACKPING");
		entityManager.persist(band);
		entityManager.flush();

		dateExpMonth.setExpMonth("12");
		entityManager.persist(dateExpMonth);
		entityManager.flush();

		dateExpYear.setExpYear("2034");
		entityManager.persist(dateExpYear);
		entityManager.flush();

	}

//============================================== Sprint2 Test PrivilegeVIP ================================================

	@Test
	public void dataCompletePrivilegeVIP() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			System.out.println("\n\n================================  Complete testDataPrivilegeVIP ================================\n");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	//========= NULL =========

	@Test
	public void numCreditCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit(null);
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test CreditNum CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void numCvvCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv(null);
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test CvvNum CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void emailCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail(null);
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test Email CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


	@Test
	public void bandCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(null);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test Band CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void typePrivilegeCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(null);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test TypePrivilege CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void dateExpMonthCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(null);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test DateExpMonth CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void dateExpYearCannotBeNull() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(null);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test DateExpYear CannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


	// ========= Size =========

	@Test
	public void numCreditCannotLongerThanMax() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("12345678901234567890");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCredit CannotLongerThanMax ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void numCreditCannotLowerThanMin() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCredit CannotLowerThanMin ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void numCvvCannotLongerThanMax() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("12345");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCvv CannotLongerThanMax ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void numCvvCannotLowerThanMin() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("1");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCvv CannotLowerThanMin ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	// ============ Pattern ============

	@Test
	public void numCreditMustBePattern() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123Ab@");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCredit MustBePattern ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void numCvvMustBePattern() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("1A@");
		privilegeVIP.setEmail("Example@mail.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test NumCvv MustBePattern ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	// ======== Email =========
	@Test
	public void emailMustBeEmail() {
		PrivilegeVIP privilegeVIP = new PrivilegeVIP();

		privilegeVIP.setNumCredit("1234567890123456");
		privilegeVIP.setNumCvv("123");
		privilegeVIP.setEmail("Example.com");
		privilegeVIP.setBand(band);
		privilegeVIP.setTypePrivilege(typePrivilege);
		privilegeVIP.setDateExpMonth(dateExpMonth);
		privilegeVIP.setDateExpYear(dateExpYear);

		try {
			entityManager.persist(privilegeVIP);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test Email MustBeEmail ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
//============================================== END Test Sprint2 PrivilegeVIP ============================================



}

