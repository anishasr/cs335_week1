import java.util.*;

public class CaesarCipher {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String msg;
		int offset;
		
		// User input - ask for offset, message
		System.out.println("Enter a message to encrypt! ");
		msg = sc.nextLine(); 
		
		System.out.println("Please enter the offset to use:  ");
		offset = sc.nextInt(); 
		
		sc.close();
		
		// Call cipher
		cipher(msg, offset);
		cipher_revised(msg, offset);
		
	}

	// Encrypts user input - prints original message and encrypted message
	private static void cipher_revised(String msg, int offset) {
		
		// empty string for encrypted message
		String new_msg = "";
		
		// ascii value of character
		int ascii_val;
		
		// // ascii value of shifted character
		int new_ascii;
		
		// iterate through message
		for(int i = 0;i < msg.length();i++) {
			// get ASCII value of char
			ascii_val = (int)msg.charAt(i);
			new_ascii = msg.charAt(i) + offset;
				
			// handle uppercase characters 
			if(ascii_val >= 65 && ascii_val <= 90) {
				// if new character is ASCII value is past 'Z', find the difference between new ASCII value and ASCII value of 'Z' 
				// add that value to the ASCII value of 'A' to wrap around to beginning of uppercase alphabet
				if(new_ascii > (int)'Z') {
					new_ascii = (new_ascii - 'A') % 26 + 'A';
				}
				new_msg += (char)new_ascii;
			// handle lowercase characters 
			} else if(ascii_val >= 97 && ascii_val <= 122) {
				// if new character is ASCII value is past 'z', find the difference between new ASCII value and ASCII value of 'z' 
				// add that value to the ASCII value of 'a' to wrap around to beginning of lowercase alphabet
				if(new_ascii > (int)'z') {
					new_ascii = (new_ascii - 'a') % 26 + 'a';
				}
				new_msg += (char)new_ascii;
			// handle non-alphabetic characters
			} else {
				new_msg += msg.charAt(i);
			}
		}
		
		
		System.out.println(msg);
		System.out.println(new_msg);
		
	}
	
	// Encrypts user input - prints original message and encrypted message
	private static void cipher(String msg, int offset) {
		
		// arrays holding letters of alphabet 
		String[] upper_alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] lower_alphabet = {"a","b","b","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		// empty string for encrypted message
		String new_msg = "";
		
		// index of new character
		int new_idx;
		
		// numeric value of character
		int ascii_val;
		
		// iterate through message
		for(int i = 0;i < msg.length();i++) {
			// get ASCII value of char
			ascii_val = (int)msg.charAt(i);
			
			// handle uppercase
			if(ascii_val >= 65 && ascii_val <= 90) {
				// subtract 'A' ASCII value from current character then add offset to find position of new character in array
				new_idx = (ascii_val - 65 + (offset)) % 26;
				// append new character to encrypted string variable
				new_msg += upper_alphabet[new_idx];
			// handle lowercase
			} else if(ascii_val >= 97 && ascii_val <= 122) {
				// subtract 'a' ASCII value from current character then add offset to find position of new character in array
				new_idx = (ascii_val - 97 + (offset)) % 26;
				// append new character to encrypted string variable
				new_msg += lower_alphabet[new_idx];
			// handle non-alphabetic characters
			} else if(ascii_val < 65) {
				// append character, no encryption
				new_msg += msg.charAt(i);
			}
		}
		
		
		System.out.println(msg);
		System.out.println(new_msg + "\n");
		
	}
	

}
