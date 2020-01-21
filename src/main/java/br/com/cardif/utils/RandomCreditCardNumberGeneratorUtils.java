package br.com.cardif.utils;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * See the license below. Obviously, this is not a Javascript credit card number
 * generator. However, The following class is a port of a Javascript credit card
 * number generator.
 * 
 * @author robweber
 * 
 */
public class RandomCreditCardNumberGeneratorUtils {
	/*
	 * Javascript credit card number generator Copyright (C) 2006 Graham King
	 * graham@darkcoding.net
	 * 
	 * This program is free software; you can redistribute it and/or modify it under
	 * the terms of the GNU General Public License as published by the Free Software
	 * Foundation; either version 2 of the License, or (at your option) any later
	 * version.
	 * 
	 * This program is distributed in the hope that it will be useful, but WITHOUT
	 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
	 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
	 * details.
	 * 
	 * You should have received a copy of the GNU General Public License along with
	 * this program; if not, write to the Free Software Foundation, Inc., 51
	 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
	 * 
	 * www.darkcoding.net
	 */

	public static final String[] VISA_PREFIX_LIST = new String[] { "4539", "4556", "4916", "4532", "4929", "40240071",
			"4485", "4716", "4" };

	public static final String[] MASTERCARD_PREFIX_LIST = new String[] { "51", "52", "53", "54", "55" };

	public static final String[] AMEX_PREFIX_LIST = new String[] { "34", "37" };

	public static final String[] DISCOVER_PREFIX_LIST = new String[] { "6011" };

	public static final String[] DINERS_PREFIX_LIST = new String[] { "300", "301", "302", "303", "36", "38" };

	public static final String[] ENROUTE_PREFIX_LIST = new String[] { "2014", "2149" };

	public static final String[] JCB_16_PREFIX_LIST = new String[] { "3088", "3096", "3112", "3158", "3337", "3528" };

	public static final String[] JCB_15_PREFIX_LIST = new String[] { "2100", "1800" };

	public static final String[] VOYAGER_PREFIX_LIST = new String[] { "8699" };

	public static Label LABEL;

	public static enum Label {
		VISA, MASTER, AMEX, DINERS;
		public static Label getLabel(final String label) {
			if (label.toUpperCase().equals("VISA"))
				return VISA;
			if (label.toUpperCase().equals("MASTER"))
				return MASTER;
			if (label.toUpperCase().equals("AMEX"))
				return AMEX;
			if (label.toUpperCase().equals("DINERS"))
				return DINERS;
			throw new IllegalArgumentException("Unknown Label: [" + label + "]");
		}
	};

	static String strrev(String str) {
		if (str == null)
			return "";
		String revstr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revstr += str.charAt(i);
		}

		return revstr;
	}

	/*
	 * 'prefix' is the start of the CC number as a string, any number of digits.
	 * 'length' is the length of the CC number to generate. Typically 13 or 16
	 */
	static String completed_number(String prefix, int length) {

		String ccnumber = prefix;

		// generate digits

		while (ccnumber.length() < (length - 1)) {
			ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
		}

		// reverse number and convert to int

		String reversedCCnumberString = strrev(ccnumber);

		List<Integer> reversedCCnumberList = new Vector<Integer>();
		for (int i = 0; i < reversedCCnumberString.length(); i++) {
			reversedCCnumberList.add(new Integer(String.valueOf(reversedCCnumberString.charAt(i))));
		}

		// calculate sum

		int sum = 0;
		int pos = 0;

		Integer[] reversedCCnumber = reversedCCnumberList.toArray(new Integer[reversedCCnumberList.size()]);
		while (pos < length - 1) {

			int odd = reversedCCnumber[pos] * 2;
			if (odd > 9) {
				odd -= 9;
			}

			sum += odd;

			if (pos != (length - 2)) {
				sum += reversedCCnumber[pos + 1];
			}
			pos += 2;
		}

		// calculate check digit

		int checkdigit = new Double(((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
		ccnumber += checkdigit;

		return ccnumber;

	}

	public static String[] credit_card_number(String[] prefixList, int length, int howMany) {

		Stack<String> result = new Stack<String>();
		for (int i = 0; i < howMany; i++) {
			int randomArrayIndex = (int) Math.floor(Math.random() * prefixList.length);
			String ccnumber = prefixList[randomArrayIndex];
			result.push(completed_number(ccnumber, length));
		}

		return result.toArray(new String[result.size()]);
	}

	public static String[] generateCardNumbers(int howMany) {
		return credit_card_number(getPrefixList(), 16, howMany);
	}

	public static String generateCardNumber() {
		return credit_card_number(getPrefixList(), 16, 1)[0];
	}

	public static String[] getPrefixList() {
		if (Label.VISA.equals(LABEL))
			return VISA_PREFIX_LIST;
		if (Label.MASTER.equals(LABEL))
			return MASTERCARD_PREFIX_LIST;
		if (Label.AMEX.equals(LABEL))
			return AMEX_PREFIX_LIST;
		if (Label.DINERS.equals(LABEL))
			return DINERS_PREFIX_LIST;
		return null;
	}

	public static boolean isValidCreditCardNumber(String creditCardNumber) {
		boolean isValid = false;

		try {
			String reversedNumber = new StringBuffer(creditCardNumber).reverse().toString();
			int mod10Count = 0;
			for (int i = 0; i < reversedNumber.length(); i++) {
				int augend = Integer.parseInt(String.valueOf(reversedNumber.charAt(i)));
				if (((i + 1) % 2) == 0) {
					String productString = String.valueOf(augend * 2);
					augend = 0;
					for (int j = 0; j < productString.length(); j++) {
						augend += Integer.parseInt(String.valueOf(productString.charAt(j)));
					}
				}

				mod10Count += augend;
			}

			if ((mod10Count % 10) == 0) {
				isValid = true;
			}
		} catch (NumberFormatException e) {
		}

		return isValid;
	}

	public static String getNumberCardFormatOcult() {

		String cardNumber = null;
		int numberOfCards = 1;
		LABEL = Label.getLabel("VISA");
		String[] creditcardnumbers = generateCardNumbers(numberOfCards);
	

		cardNumber = creditcardnumbers[0].substring(0, 5) + "******" + creditcardnumbers[0].substring(11, 16);

		return cardNumber;
	}
	
	public static String getNumberCardFormat() {

		String cardNumber = null;
		int numberOfCards = 1;
		LABEL = Label.getLabel("VISA");
		String[] creditcardnumbers = generateCardNumbers(numberOfCards);
	

		cardNumber = creditcardnumbers[0];

		return cardNumber;
	}

	public static void main(String[] args) {
		//int numberOfCards = 0;
		try {

		} catch (Exception e) {
			System.err.println("Usage error: [NUMBER_OF_CARDS] [VISA|MASTER|AMEX|DINERS]");
			System.err.println("Examples:");
			System.err.println("10 VISA");
			System.err.println("200 MASTER");
		}


	}
}
