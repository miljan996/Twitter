package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Class used for setting user's message and reading them
 * @author Miljan Ignjatovic
 * @version 1.0
 *
 */
public class Twitter {
	/**
	 * Attribute that contains list of messages
	 * Type of objects in list:
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Get method for all messages
	 * @return poruke - LinkedList of TwiterPoruka objects
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	
	/**
	 * Set method for user's message, message is added in list 
	 * @param korisnik - Strings with user's name
	 * @param poruka - String with user's message
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);

		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Get merthod for wanted number of messages that contains tag
	 * @param maxBroj - Max number of messages return, if maxBroj is less then or equals 0, maxBroj is set to 100
	 * @param tag - Tag in message
	 * @throws java.lang.RuntimeException if:
	 * <ul>
	 * 		<li>tag == null</li>
	 * 		<li>tag is empty string</li>
	 * </ul>
	 * @return rezultat - Array of messages	
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {

		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");

		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;

		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;

		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		
		return rezultat;
	}
}