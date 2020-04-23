package Hangman;
import java.util.Scanner;
import java.util.Random;


/*
Task: to create a game Hangman which invites the player to guess the secret word provided by computer
entering letter by letter until the whole word is guessed or until lives are over. Each time the game
is finished system should ask user whether he/she would like to continue. If yes - the game starts again, 
if no - system shows previous games statistics.
 */

public class Hangman01 {
	
	public static void main (String [] args) {
		
		//declare object of type scanner
		Scanner scanner = new Scanner(System.in);
		//declare random object to generate random numbers and get random words 
		Random random = new Random();
		
		//introduce string array containing word library
		String [] SecretWord = {"woodpecker", "eagle", "pelican", "condors", "owl", "goose", "hawk",
				"heron", "sparrow", "flamingo", "stork", "falcon", "duck", "pigeon", "skylark",
				"turkey", "albatross", "hummingbird", "bittern"};
		
		int won = 0;
		int lost = 0;
		//declare boolean variable
		boolean GameContinues = true;
		
		//main loop where the game takes place
		while (GameContinues) {
			System.out.println("Welcome to the Hangman game!\n\nThis game is about birds!\nLet's begin!\n");
			
			//retrieving a random word from the array 
			//and breaking down each letter of the word into individual character
			char[] randomWord = SecretWord[random.nextInt(SecretWord.length)].toCharArray();
			
			//indicate amount of tries player has
			int amountOfGuesses = randomWord.length;
			
			//create an empty char [] to store players input
			char[] hiddenWord = new char[amountOfGuesses];
			
			//encrypt all letters in random word to underscores
			for (int i = 0; i < hiddenWord.length; i++) {
			hiddenWord[i] = '_';
			}
			
			//declare boolean value
			boolean playerGuessed = false;
			int tries = 0;
			
			
			//while loop 
			while (!playerGuessed && tries != amountOfGuesses) {
			System.out.println("Secret Word: ");
			printArray(hiddenWord);
			int g = amountOfGuesses - tries;
			System.out.println("Number of tries left " + g);
			System.out.println("Enter one letter: ");
			//store players input in variable "letter"
			//the system will use just a single character even if user entered more than 1 letter
			char letter = scanner.nextLine().charAt(0);
			//converting inputed letter to lower case
			letter = Character.toLowerCase(letter);
			
			tries++;
			
			
			if (letter == '_') {
				GameContinues = false;
				playerGuessed = true;
				
			}else {
				//substitute _ with player input if the letter is guessed
				for (int i = 0; i < randomWord.length; i++) {
					if (randomWord[i] == letter) {
						hiddenWord[i] = letter;
						
								
				}
			}
			
				
			if (isTheWordGuessed(hiddenWord)) {
				playerGuessed = true;
				System.out.println("Congratulations you won!!!");
				System.out.println("Secret word is: ");
				printArray(hiddenWord);
				System.out.println("======================================");
				won++;
			}
			
			}
			
			
			
		}//End of wordIsGuessed
			
		//output in case player ran out of guesses 	
		if(!playerGuessed) {
			System.out.println("Sorry, you have ran out of guesses!");
			System.out.println("Secret word is: ");
			printArray(randomWord);
			lost++;
		}
		
		
		//output asking if the player wants to continue playing
			System.out.println("Do you want to play another game (yes/no)");
			String newGame = scanner.nextLine();
			if (newGame.equals("no")) {
				GameContinues = false;
			
		}
			
		}//End of GameContinues
		
		System.out.println("Game Over!");
		System.out.println("Games won: " + won);
		System.out.println("Games lost: " + lost);
		
		
	}//end main
	
		//adding spaces between underscores in the hiddenWord 
		public static void printArray(char[] array) {
			for (int i = 0; i<array.length; i++) {
				System.out.print(array[i] + " "); 
			}
			System.out.println();
			}	
		
		public static boolean isTheWordGuessed(char[]array) {
		
			for (int i = 0; i<array.length; i++) {
			if(array[i] == '_') return false;
		}
			return true;
	
	}
	
}//end class
