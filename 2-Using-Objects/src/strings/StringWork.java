package strings;

public class StringWork {

	public static void main(String[] args) {
		/*
		 * For all the questions below, print the value the question is requesting.
		 * Use only the variables provided for the given question.
		 * Your code may require you to create temporary variables and write multiple lines of code (especially with later questions).
		 *
		 * Here is a sample question and answer:
		 *
		 * 0. Write Java code to return the first six characters of a given string.
		 *
		 * Sample Output:
		 * cheese
		 */
		String q0 = "cheeseburger";
		System.out.println(q0.substring(0, 6));

		/*
		 * 1. Write a Java program to get the character at the given index within the String.
		 *
		 * Sample Output:
		 * The character at position 0 is J
		 * The character at position 10 is i
		 */
		String q1 = "Java Exercises!";
		System.out.println("Question 1:");
		System.out.printf("The character at position 0 is %s\n", q1.substring(0, 1));
		System.out.printf("The charactrer at position 10 is %s\n", q1.substring(10, 11));

		/*
		 * 2. Write a java program to count the number of characters in a String.
		 *
		 * Sample Output:
		 * Number of characters in Darlington = 10
		 */
		String q2 = "Darlington";
		System.out.println("Question 2:");
		System.out.printf("Number of characters in Darlington = %d\n", q2.length());

		/*
		 * 3a. Write a java program to compare the value of two strings (case sensitive)
		 *
		 * Sample Output:
		 * false
		 */
		String q3a_1 = "example.com", q3a_2 = "Example.com";
		System.out.println("Question 3a:");
		System.out.printf("%b\n", q3a_1.equals(q3a_2));

		/*
		 * 3b. Write a java program to compare the value of two strings, ignoring case differences.
		 *
		 * Sample Output:
		 * true
		 */
		String q3b_1 = "example.com", q3b_2 = "Example.com";
		System.out.println("Question 3b:");
		System.out.printf("%b\n", q3b_1.equalsIgnoreCase(q3b_2));

		/*
		 * 4. Write a Java program to concatenate a given string to the end of another string.
		 *
		 * Sample Output:
		 * Darlington School
		 */
		String q4a = "Darlington";
		String q4b = "School";
		System.out.println("Question 4:");
		System.out.println(q4a.concat(q4b));

		/*
		 * 5. Write a Java program to concatenate the result of addition with a given string and another string.
		 *
		 * Sample Output:
		 * Darlington School is 115 years old
		 */
		int StartYear = 1905;
		int CurrentYear = 2021;
		String q5a = "Darlington";
		String q5b = "School";
		System.out.println("Question 5:");
		System.out.printf("%s is %d years old\n", q5a.concat(q5b), CurrentYear - StartYear);

		/*
		 * 6. Write a Java program to test if a given String contains the specified String.
		 *
		 * Sample Output:
		 * true
		 */
		String q6 = "Thornwood House";
		String search6 = "horn";
		System.out.println("Question 6:");
		System.out.printf("%b\n", q6.contains(search6));

		/*
		 * 7. Write a Java program to test if a given String contains the specified full word.
		 *
		 * Sample Output:
		 * false
		 */
		String q7 = "Band is my favorite class but so is computer science";
		String search7 = "and";
		System.out.println("Question 7:");
		System.out.printf("%b\n", q7.contains(" " + search7 + " "));

		/*
		 * 8. Write a Java program to return the first 3 characters of a given string.
		 *
		 * Sample Output:
		 * Dar
		 */
		String q8 = "Darlington";
		System.out.println("Question 8:");
		System.out.printf("%s\n", q8.substring(0, 3));

		/*
		 * 9. Write a Java program to return the last 3 characters of a given string.
		 *
		 * Sample Output:
		 * ton
		 */
		String q9 = "Darlington";
		System.out.println("Question 9:");
		System.out.printf("%s\n", q9.substring(q9.length() - 3));

		/*
		 * 10. Write a Java program to return the middle 2 characters of a given string.
		 *
		 * Sample Output:
		 * in
		 */
		String q10 = "Darlington";
		System.out.println("Question 10:");
		System.out.printf("%s\n", q10.substring(q10.length() / 2 - 1, q10.length() / 2 + 1));

		/*
		 * 11. Write a Java program to replace a given string with a replacement string in an original String
		 *
		 * Sample Output:
		 * The quick brown fox jumps over the lazy fog.
		 */
		String q11 = "The quick brown fox jumps over the lazy dog";
		String search11 = "d";
		String replace11 = "f";
		System.out.println("Question 11:");
		System.out.printf("%s\n", q11.replace(search11, replace11));

		/*
		 * 12. Write a Java program to use substring to extract “brown fox jump” from the given string.
		 *
		 * Sample Output:
		 * brown fox jumps
		 */
		String q12 = "The quick brown fox jumps over the lazy dog.";
		System.out.println("Question 12:");
		System.out.printf("%s\n", q12.substring(q12.indexOf("brown fox jump")));

		/*
		 * 13. Write a Java program to use substring to extract from the given string the full word starting at the given index.
		 * Use no hard coded integers, only the given startIndex variable
		 *
		 * Sample Output:
		 * brown
		 */
		String q13 = "The quick brown fox jumps over the lazy dog.";
		int startIndex = 10;
		System.out.println("Question 13:");
		String sub = q13.substring(startIndex);
		System.out.printf("%s\n", sub.substring(0, sub.indexOf(" ")));

		/*
		 * 14. Write a Java program to convert all the characters in a string to uppercase.
		 *
		 * Sample Output:
		 * THE QUICK BROWN FOX!
		 */
		String q14 = "tHe quICk BRoWn fOx!";
		System.out.println("Question 14:");
		System.out.printf("%s\n", q14.toUpperCase());

		/*
		 * 15. Write a Java program that converts a string to proper case.
		 *
		 * Sample Output:
		 * Darlington
		 */
		String q15 = "dARLINGTON";
		System.out.println("Question 15:");
		System.out.printf("%s%s\n", q15.substring(0, 1).toUpperCase(), q15.substring(1).toLowerCase());

		/*
		 * 16. Write a Java program that returns the index of the second occurrence of one string inside another.
		 *
		 * Sample Output:
		 * 14
		 */
		String q16 = "Darlington School";
		String search16 = "o";
		System.out.println("Question 16:");
		int first = q16.indexOf(search16);
		System.out.printf("%s\n", q16.indexOf(search16, first + 1));

		/*
		 * 17. Write a Java program that converts a simple name to the format of last name + comma + first name.
		 *
		 * Sample Output:
		 * Billingsworth, Barbara
		 */
		String q17 = "Barbara Billingsworth";
		System.out.println("Question 17:");
		int space = q17.indexOf(" ");
		String firstName = q17.substring(0, space);
		String lastName = q17.substring(space + 1);
		System.out.printf("%s, %s\n", lastName, firstName);

		/*
		 * 18. Write a Java program that returns the two string results shown below, only using these given variables:
		 * 
		 * Sample Output 1: Joe Biden
			            PRESIDENT OF THE UNITED STATES
			                
		 * Sample Output 2: President Biden
		 */
		firstName = "Joe";
		lastName = "Biden";
		String title = "President of the United States";
		System.out.println("Question 18:");
		String header = title.substring(0, title.indexOf(" "));
		System.out.printf("%s %s\n", firstName, lastName);
		System.out.println(title.toUpperCase());
		System.out.printf("%s %s\n", header, lastName);

		/*
		 * 19. Write a Java program that returns the fourth word of the given string:
		 *
		 * Sample Output:
		 * fox
		 */
		String q19 = "The quick brown fox jumps over the lazy dog.";
		String word = "";
		int lastSpace = 0;
		for (int i = 0; i < 4; i++) {
			int nextSpace = q19.indexOf(" ", lastSpace + 1);
			word = q19.substring(lastSpace + 1, nextSpace);
			lastSpace = nextSpace;
		}
		System.out.println("Question 19:");
		System.out.printf("%s\n", word);

		/*
		 * 20. Write a Java program that returns the original string with the search string in quotation marks:
		 *
		 * Sample Output:
		 * All "good" men should come to the aid of their country.
		 */
		String q20 = "All good men should come to the aid of their country.";
		String search20 = "good";
		System.out.println("Question 20:");
		System.out.printf("%s\n", q20.replaceFirst(search20, "\"" + search20 + "\""));

		String str = "AP";

		str += "CS " + 1 + 2;

		System.out.println(str);
	}
}