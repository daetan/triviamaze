package maze;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MenuOptions {
	public static void main(String[] args) {
		printOptions();
	}

	/**
	 * This method should read user input correctly
	 */

	public static void printOptions() {

		System.out.println("Please Enter Enteger 1-5 from choices: ");
		System.out.println("1) Play Game");
		System.out.println("2) File");
		System.out.println("3) Help");
		System.out.println("4) Exit");
		System.out.print("Choose: ");

	}

	public void menuImplementer() {
		Scanner myInput = new Scanner(System.in);
		printOptions();
		int a = myInput.nextInt();
		if (a == 1) {
			playGame();
		} else if (a == 2) {
			fileOptions();
		} else if (a == 3) {
			helpOptions();
		} else if (a == 4) {
			exitGame();

		}

	}

	private void helpOptions() {
		// TODO Auto-generated method stub

	}

	private void fileOptions() {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		System.out.println("1) Save Game");
		System.out.println("1) Load Game");
		System.out.println("Enter Your choice: ");
		int a = myInput.nextInt();
		if (a == 1) {
			saveGame();
		} else if (a == 2) {
			loadGame();
		}
	}

	/**
	 * This method will save the currrent status of the game
	 */
	private void saveGame() {
		// TODO Auto-generated method stub
		Player p = new Player("Abdul", 0, 0);
		Maze m = new Maze(4, 4, p);

		try (FileOutputStream save = new FileOutputStream("maze.bin")) {

			ObjectOutputStream saveObj = new ObjectOutputStream(save);
			saveObj.writeObject(p);
			saveObj.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void exitGame() {
		// TODO Auto-generated method stub

	}

	private void intstrcutions() {
		// TODO Auto-generated method stub

	}

	private void loadGame() {
		// TODO Auto-generated method stub

	}

	private void playGame() {
		// TODO Auto-generated method stub
		System.out.println("You have Entered the maze");

	}
}