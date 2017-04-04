package com.twitter.poruke;
/**
 * 
 * Class with information about twitter user and message
 * @author Miljan Ignjatovic
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Attribute that contains user name 
	 */
	private String korisnik;
	/**
	 * Attribute that contains user's message
	 */
	private String poruka;
	/**
	 * get method for attribute korisnik
	 * @return korisnik - String with user's name
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * set method for attribute korisnik
	 * @param korisnik - String with user's name
	 * @throws java.lang.RuntimeException if 
	 * <ul>
	 * 		<li>korisnik == null</li>
	 * 		<li>korisnik is empty string</li>
	 * 
	 * </ul>
	 * 
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || !korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");

		this.korisnik = korisnik;
	}
	/**
	 * get method for attribute poruka
	 * @return poruka - String with user's message
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * set method for attribute poruka
	 * @param poruka - String with user's message
	 * @throws java.lang.RuntimeException if:
	 * <ul>
	 * 		<li>poruka == null</li>
	 * 		<li>poruka is empty string</li>
	 * 		<li>poruka is longer then 140 characters </li>
	 * 
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (this.poruka == null || this.poruka == new String("") || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Overridden toString method for class TwitterPoruka
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}