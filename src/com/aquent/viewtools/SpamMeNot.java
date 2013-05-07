package com.aquent.viewtools;

import org.apache.velocity.tools.view.tools.ViewTool;

import com.dotmarketing.util.Logger;

import java.util.Random;
import java.lang.StringBuffer;

/**
 * 
 * @author cfalzone
 * 
 * A Viewtool Implementation of the Spam-me-not Java version by Bjšrn Bergenheim
 * Original Version can be found at:  http://paula.edmiston.org/nb/spamx/SpamMeNot.java
 *
 */
public class SpamMeNot implements ViewTool {

	@Override
	public void init(Object initData) {
		Logger.info(this, "Spam Me Not Viewtool Initialized");
	}
	
	/**
	 * Encode email addresses to make it harder for spammers to harvest them.
	 * 
	 * @param emailAddress    the address to encode
	 * @param name            the name to be displayed in statusbar
	 * @return                a complete email link
	 */
	public static String encodeEmail(String emailAddress, String name) {
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		
		if( name == null)
			name = "";
		
		String originalString = "mailto:" + emailAddress;

		StringBuffer encodedName = new StringBuffer();
		StringBuffer encodedMailto = new StringBuffer();

		int originalLenght = originalString.length();
		int nameLength = name.length();

		int i;
		for (i = 0; i < originalLenght; i++) {
			switch (random.nextInt(3)) {
				case 0 : //Decimal code
					encodedMailto.append("&#" + (int)originalString.charAt(i) + ";");
					break;
				case 1 : //Hexadecial code
					encodedMailto.append("&#x" + Integer.toHexString(originalString.charAt(i)) + ";");
					break;
				case 2 : //No action code
					encodedMailto.append(originalString.charAt(i));
					break;
			}
		}

		for (i = 0; i < nameLength; i++) {
			switch (random.nextInt(3)) {
				case 0 : //Decimal code
					encodedName.append("&#" + (int)name.charAt(i) + ";");
					break;
				case 1 : //Hexadecial code
					encodedName.append("&#x" + Integer.toHexString(name.charAt(i)) + ";");
					break;
				case 2 : //No action code
					encodedName.append(name.charAt(i));
					break;
			}
		}
		
		//if no name is supplied, use email in statusbar
		if( nameLength == 0 ) {
			return "<a href=\"" + encodedMailto.toString() + "\">" +
					encodedMailto.toString() + "</a>";
		} else {
			return "<a href=\"" + encodedMailto.toString() + "\">" +
					encodedName.toString() + "</a>";
		}
	}

}
