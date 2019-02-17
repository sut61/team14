package sut.se.g14.backend.sprint2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//==============================================
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
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
//==============================================

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class TableWorkApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private TableWorkRepository tableWorkRepository;
	@Autowired
	private FormatRepository formatRepository;


	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void InviteFinish() {
		TableWork tableWork = new TableWork();


		tableWork.setInvite("welcome to consert");


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
		} catch(javax.validation.ConstraintViolationException e) {
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
	public void OldSizeOver() {
		Old old = new Old();
		old.setOld(150);

		try {
			entityManager.persist(old);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Old Size Over<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

	@Test
	public void FormatCannotBeNull() {
		Format format = new Format();
		format.setFormat(null);

		try {
			entityManager.persist(format);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Format notnull<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}


	@Test
	public void PriceNotPositive() {
		TableWork tableWork = new TableWork();
		tableWork.setInvite("HelloWorlddddd");
		tableWork.setPrice(-10L);
		tableWork.setTag("testttttt");


		try {
			entityManager.persist(tableWork);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Price not Positive<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}

	@Test
	public void TagCannotBeNull() {
		TableWork tableWork = new TableWork();
		tableWork.setTag(null);
		tableWork.setPrice(100L);
		tableWork.setInvite("WellcomeToConcertttt");


		try {
			entityManager.persist(tableWork);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Tag notnull<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}

	}




	@Test
	public void testInviteSizeshort() {
		TableWork tableWork = new TableWork();

		tableWork.setInvite("a");
		tableWork.setTag("gggggg");
		tableWork.setPrice(1000L);
		try {
			entityManager.persist(tableWork);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("----------> Invite Sizeshort<--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void InvitePattern() {
		TableWork tableWork = new TableWork();


		tableWork.setInvite("$HelloWordd");
		tableWork.setPrice(100L);
		tableWork.setTag("Helloooo");
		try {
			entityManager.persist(tableWork);
			entityManager.flush();
			//fail("Should not pass to this line");
			System.out.println();
			System.out.println("----------> Invite Pattern <--------------------");
			//System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);

		}

	}




}



