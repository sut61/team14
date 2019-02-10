package sut.se.g14.backend;

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

public class AlbumsApplicationTests {

	@Autowired private TestEntityManager entityManager;
	@Autowired private GenderRepository genderRepository;
	@Autowired private  BandRepository bandRepository;
	@Autowired private  TypeMusicRepository typeMusicRepository;
	@Autowired private  ProducerRepository producerRepository;
	@Autowired private  SongRepository songRepository;


	Gender gender = new Gender();
	Band band = new Band();
	TypeMusic typeMusic = new TypeMusic();
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
	public void testMatchAlbums() throws ParseException{
		Albums albums = new Albums();
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("LoveLove");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		entityManager.persist(albums);
		entityManager.flush();
	}

    @Test
    public void testMatchSong() {
        Song song = new Song();
        song.setName("Youyuo");
        Time timeSongSet = new Time(Integer.parseInt("00"), Integer.parseInt("03"), Integer.parseInt("00"));
        song.setTime(timeSongSet);
        entityManager.persist(song);
        entityManager.flush();
    }

   //////////////////////NULL/////////////////////////////////
	@Test
	public void testAlbumnameCannotBeNull() throws ParseException{
		Albums albums = new Albums();
        Song song = new Song();
        song.setName("BUBUBUBUBU");
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName(null);
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name Null <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
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
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name Null <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
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
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name Null <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
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
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name NotMatchPatten <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

    ////////////////////SIZE///////////////////////////////////////////////
	@Test
	public void testNameSizeCannotMatchLowerThanMin() throws ParseException{
		Albums albums = new Albums();
        Song song = new Song();
        song.setName("BUBUBUBUBU");
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("BI");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name MinSize <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testNameSizeCannotMatchHighThanMin() throws ParseException{
		Albums albums = new Albums();
        Song song = new Song();
        song.setName("BUBUBUBUBU");
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("BIfhdirjorkkyoykhitolghjfdjhoierjhoirejhoidjhoidrgoijerhijerjhjoiewjyhoiepwjhioejhoierwjhoiejhoiewjhoiewjhioejh");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Name MaxSize <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

    @Test
    public void testMinSizeSong() throws ParseException{
        Song song = new Song();
        song.setName("y");
        Time timeSongSet = new Time(Integer.parseInt("00"), Integer.parseInt("03"), Integer.parseInt("00"));
        song.setTime(timeSongSet);
        try {
            entityManager.persist(song);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println("----------> SongName MinSize <--------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

///////////////////////////////////////DateFuture////////////////////////////////////////////////////////
	@Test
	public void testOnsaleCannnotFuture() throws ParseException{
		Albums albums = new Albums();
		Song song = new Song();
		song.setName("BUBUBUBUBU");
		albums.setBand(band);
		albums.setProducer(producer);
		albums.setName("BIBIBI");
		Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-05");
		albums.setOnsale(onsale);
		try {
			entityManager.persist(albums);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			System.out.println();
			System.out.println("----------> Onsale NotFuture <--------------------");
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

  ///////////////////////////Unique//////////////////////////
  @Test(expected = javax.persistence.PersistenceException.class)
	public void testNameAlbumsBeUnique() throws ParseException{

	  Albums albums = new Albums();
	  albums.setBand(band);
	  albums.setProducer(producer);
	  albums.setName("ComingSoon");
	  Date onsale = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-05");
	  albums.setOnsale(onsale);
	  entityManager.persist(albums);
	  entityManager.flush();

	  Albums albums1 = new Albums();
	  albums1.setBand(band);
	  albums1.setProducer(producer);
	  albums1.setName("ComingSoon");
	  Date onsale1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-25");
	  albums1.setOnsale(onsale1);
	  entityManager.persist(albums1);


	  System.out.println();
	  System.out.println("----------> NameAlbumsBeUnique <--------------------");
	  System.out.println();
	  System.out.println();

	  entityManager.flush();
	  fail("Should not pass to this line");
  }

}

