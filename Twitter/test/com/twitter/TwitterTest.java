/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Miljan Ignjatovic
 */
public class TwitterTest {
	
	private Twitter t;
	private int numOfMsg = 50;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		

		for (int i = 0; i < numOfMsg; i++){
			String korisnik = "Kor";
			String poruka = "Msg";
			
			korisnik += Integer.toString(i);
			poruka += Integer.toString(i);
			t.unesi(korisnik, poruka);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		assertEquals(numOfMsg, t.vratiSvePoruke().size());
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		String korisnik = "Mika";
		String poruka = "Twitter message TEST";
		t.unesi(korisnik, poruka);
		
		LinkedList<TwitterPoruka> msgs = t.vratiSvePoruke();
		assertEquals(korisnik, msgs.getLast().getKorisnik());
		assertEquals(poruka, msgs.getLast().getPoruka());
		
	}
	
	@Test
	public void testUnesiStrBug() {
		String korisnik = "Mika";
		String poruka = "Twitter message TEST";
		t.unesi(korisnik, poruka);
		
		LinkedList<TwitterPoruka> msgs = t.vratiSvePoruke();
		
		if (msgs.getLast().getKorisnik().equals("korisnik")) {
			fail("Method should add user's name provided as parameter in method");
			
		}
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		assertEquals(30, t.vratiPoruke(30, "test").length);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(10, null);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyTag() {
		t.vratiPoruke(10, "");
	}
	

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPorukeMaxBroj() {
		assertEquals(100, t.vratiPoruke(-1, "test").length);
	}
}
