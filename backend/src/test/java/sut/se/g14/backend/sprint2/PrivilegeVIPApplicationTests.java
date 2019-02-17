package sut.se.g14.backend.sprint2;

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
public class PrivilegeVIPApplicationTests {


	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;


	TypePrivilege typePrivilege = new TypePrivilege();
	Band band = new Band();
	DateExpMonth dateExpMonth = new DateExpMonth();
	DateExpYear dateExpYear = new DateExpYear();



	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();


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


	@Test
	public void dataPrivilegeVIP() {
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
			System.out.println("\n\n================================  Error testCreditNumCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testCvvNumCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testEmailCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testBandCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testTypePrivilegeCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testDateExpMonthannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testDateExpYearCannotBeNull ================================\n");
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
			System.out.println("\n\n================================  Error testNumCreditCannotLongerThanMax ================================\n");
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
			System.out.println("\n\n================================  Error testCreditCannotLowerThanMin ================================\n");
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
			System.out.println("\n\n================================  Error testNumCvvCannotLongerThanMax ================================\n");
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
			System.out.println("\n\n================================  Error testCvvCannotLowerThanMin ================================\n");
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
			System.out.println("\n\n================================  Error testNumCreditMustBePattern ================================\n");
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
			System.out.println("\n\n================================  Error testNumCvvMustBePattern ================================\n");
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
			System.out.println("\n\n================================  Error testEmailMustBeEmail ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}




}

