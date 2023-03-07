



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		int flag = 0; // declaring and initializing flag
		for (int i = 0; i < plainText.length(); i++ ) { // for loop to check each individual character in the string
			
			if ((plainText.charAt(i) <= UPPER_BOUND) && (plainText.charAt(i) >= LOWER_BOUND)) { // if statement to check whether character is in range			
				flag += 1; // if true add 1
		     }
			else {			
				flag -= 1; // if false subtract 1
			}
			
		}
		if (flag == plainText.length()) // if statement to check whether all characters were in the range
		{
			return true; // return true if true
		}
		else
		{
			return false; // return false if false
		}
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// string to store new encrypted string
		
		String encryptedString = ""; // declare and initialize new string
		
		for (int i = 0; i < plainText.length(); i++ ) { // for loop to change every individual character in the string
			char character = plainText.charAt(i);  // assign character to the char in the string at "i"
			
			int encryptedValue = ((int) character) + key; // assign encrypted value to the ascii value of the character at "i" + the key int
			
			while (encryptedValue > 95 ) { // while loop to make sure the encrypted value is not above 95
				encryptedValue -= 64; // subtract 95 while the encrypted value is above 95
			}
			
			char encryptedChar = (char) encryptedValue; // assign encryptedChar the char value of the int encryptedValue
			
			encryptedString += encryptedChar; // add each new encryptedChar to the new encrypted String
		}
				
		return encryptedString; // return encrypted string
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String keyString = ""; // declare and initialize new string
		
		int i = 0; // declare and initialize i for while loop
		
		while (keyString.length() < plainText.length()) // while loop to make the bellasoStr wrap around the string to be encrypted
		{
			if (i >= bellasoStr.length()) { // if statement to reset i once the max number of characters has been reached in the bellasoStr
				i = 0; // if true then i resets to 0
			}
			
			keyString += bellasoStr.charAt(i); // add each character to new string "KeyString"
			
			i++; // increment i
		}
		
		String encryptedString = ""; // declare and intiailize new encryptedString
		
		for (int j = 0; j < plainText.length(); j++ ) { // for loop to go through each character in the string
			char character = plainText.charAt(j); // assign char character the value of the character in the string to be encrypted at "i"
			
			char character1 = keyString.charAt(j); // assign char character1 the value of the character in the keyString at "i"
			
			int encryptedValue = ((int) character) + ((int) character1); // assign encrypted value the sum of both character and character1
			
			// while loop to make sure the encrypted ascii value gets wrapped around if it is greater than 95
			while (encryptedValue > 95) {
				
				encryptedValue -= 64;
				
			}
			char encryptedChar = (char) encryptedValue; // assign encryptedChar the char value of encryptedValue
			
			encryptedString += encryptedChar; // add each encryptedChar to the new encrypted string
		}	
		
		return encryptedString; // return statement
			}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
        String decryptedString = ""; // declaring and initializing decryptedString to hold decryptedValues
		
		for (int i = 0; i < encryptedText.length(); i++) { // for loop to go through every character in the string to be decrypted
			char character = encryptedText.charAt(i); // assign character the character in the string at "i"
			
			int decryptedValue = ((int) character) - key; // set decrypted value to the int value of character minus the int key
			
			while (decryptedValue < 32) { // while loop to add 64 if the value is less than 32
				decryptedValue += 64;
			}
			
			char decryptedChar = (char) decryptedValue; // assign decryptedChar the char value of decryptedValue
			
			decryptedString += decryptedChar; // add each decryptedChar into new decryptedString
		}
		
		return decryptedString; // return statement
	}
		
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		String keyString = ""; // declare and initialize new string
		
		int i = 0; // declare and initialize i for while loop
		
		while (keyString.length() < encryptedText.length()) // while loop to make the bellasoStr wrap around the string to be encrypted
		{
			if (i >= bellasoStr.length()) { // if statement to reset i once the max number of characters has been reached in the bellasoStr
				i = 0; // if true then i resets to 0
			}
			
			keyString += bellasoStr.charAt(i); // add each character to new string "KeyString"
			
			i++; // increment i
		}
				
		String decryptedString = ""; // declare and initialize new decryptedString
		
		for (int j = 0; j < encryptedText.length() ; j++) { // for loop to go through each character in the encryptedString
			char character = encryptedText.charAt(j); // assign character the character value in the string at "i"
			
			char character1 = keyString.charAt(j); // assign character1 the character value in the keystring at "i"
			
			int decryptedValue = ((int) character) - ((int) character1); // assign decryptedValue the difference of the int values of character and character1
			
			while (decryptedValue < 32) { // while loop to make sure the decryptedValue is above 32
				decryptedValue += 64;
			}
			
			char decryptedChar = (char) decryptedValue; // assign decryptedChar the char value of the int decryptedValue
			
			decryptedString += decryptedChar; // add each decryptedChar into decryptedString
			
		}
		
		return decryptedString; // return statement
	}
}