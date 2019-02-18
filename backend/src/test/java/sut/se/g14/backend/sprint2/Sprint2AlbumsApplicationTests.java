package sut.se.g14.backend.sprint2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//==============================================
import sut.se.g14.entity.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.g14.repository.*;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Time;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Set;
import javax.validation.ConstraintViolation;




//==============================================

@RunWith(SpringRunner.class)
@DataJpaTest

public class Sprint2AlbumsApplicationTests {

	@Autowired private TestEntityManager entityManager;
	@Autowired private  BandRepository bandRepository;
	@Autowired private  ProducerRepository producerRepository;
	@Autowired private  SongRepository songRepository;


	Band band = new Band();
	Producer producer = new Producer();
	Song song = new Song();

	private Validator validator;
	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		band.setBandname("IKON");
		entityManager.persist(band);
		entityManager.flush();

		producer.setName("Mozart");
		entityManager.persist(producer);
		entityManager.flush();

		song.setName("Lovelove");
		entityManager.persist(song);
		entityManager.flush();
	}

	///////////////////////////Match/////////////////////////////////////////////////

	@Test
	public void testMatchAlbums() throws ParseException {
		Albums albums = new Albums();

		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("LoveLove");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();
			System.out.println("\n\n================================  Complete testMatchAlbums ================================\n");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testMatchSong() {
		Song song = new Song();
		song.setName("Youyuo");
		Time timeSongSet = new Time(Integer.parseInt("00"), Integer.parseInt("03"), Integer.parseInt("00"));
		song.setTime(timeSongSet);

		try {
			entityManager.persist(song);
			entityManager.flush();
			System.out.println("\n\n================================  Complete testMatchSong ================================\n");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


	//////////////////////NULL/////////////////////////////////
	@Test
	public void testAlbumnameCannotBeNull() throws ParseException{
		Albums albums = new Albums();

		albums.setName(null);
		albums.setBand(band);
		albums.setProducer(producer);
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test testAlbumnameCannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testBandCannotBeNull() throws ParseException{
		Albums albums = new Albums();

		albums.setBand(null);
		albums.setProducer(producer);
		albums.setName("KingOfKing");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test testBandCannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testProducerCannotBeNull() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(null);
		albums.setName("Lotus");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test testProducerCannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testOnsaleCannotBeNull() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("Lotus");
		albums.setOnsale(null);
		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error test testOnsaleCannotBeNull ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	//////////////////////////////Patten////////////////////////////////
	@Test
	public void testNameCannotPatten() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("12345");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error testNameCannotPatten ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


	////////////////////SIZE///////////////////////////////////////////////
	@Test
	public void testNameSizeCannotMatchLowerThanMin() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("BI");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error testNameSizeCannotMatchLowerThanMin ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testNameSizeCannotMatchHighThanMin() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("BIfhdirjorkkyoykhitolghjfdjhoierjhoirejhoidjhoidrgoijerhijerjhjoiewjyhoiepwjhioejhoierwjhoiejhoiewjhoiewjhioejh");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);

		try {
			entityManager.persist(albums);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error testNameSizeCannotMatchHighThanMin ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testMinSizeSong() throws ParseException{
		Song song = new Song();
		song.setName("y");

		try {
			entityManager.persist(song);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println("\n\n================================  Error testMinSizeSong ================================\n");
			System.out.println(e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
///////////////////////////////unique//////////////////////
	@Test
	public void testNameAlbumMustBeUnique() throws ParseException{

		Albums albums = new Albums();

		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("LoveLove");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2563-05-05");
		albums.setOnsale(onsale);
		entityManager.persist(albums);
		entityManager.flush();

		Albums albums1 = new Albums();

		albums1.setBand(band);
		albums1.setProducer(producer);
		albums1.setName("LoveLove");
		Date onsale1 = new SimpleDateFormat("yyyy-MM-dd").parse("2566-05-05");
		albums1.setOnsale(onsale1);

		try {
			entityManager.persist(albums1);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.persistence.PersistenceException e) {
			System.out.println(e);
			System.out.println("AlbumsName Must Be Unique\n\n");
		}
	}

}
