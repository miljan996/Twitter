package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @author Miljan Ignjatovic
* Test Class for TwitterPoruka {@link com.twitter.poruke.TwitterPoruka} 
*
*/
public class TwitterPorukaTest {
	
	private TwitterPoruka tp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}


	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		String korisnik = "Janko";
		tp.setKorisnik(korisnik);
		assertEquals(korisnik, tp.getKorisnik());
	}
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		String korisnik = null;
		tp.setKorisnik(korisnik);
	}
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyStr() {
		String korisnik = "";
		tp.setKorisnik(korisnik);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		String poruka = "Twitter test message";
		tp.setPoruka(poruka);
		assertEquals(poruka, tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		String poruka = null;
		tp.setPoruka(poruka);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmptyStr() {
		String poruka = "";
		tp.setPoruka(poruka);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaLength() {
		String poruka = "Twitter test message Twitter test message Twitter test message Twitter test message "
				+ "Twitter test message Twitter test message Twitter test message Twitter test message "
				+ "Twitter test message Twitter test message";
		tp.setPoruka(poruka);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("Janko");
		tp.setPoruka("Twitter test message ");
		String testStr = "KORISNIK:" + tp.getKorisnik() + " PORUKA:" + tp.getPoruka();
		assertEquals(testStr, tp.toString());
	}

}
