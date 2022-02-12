/**
 * 
 */
package triviamaze;

import java.util.Scanner;

/**
 * @author daeta
 *
 */
class View {
	
	private static Controller control;
	private static Scanner console;
	private static String selection;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Trivia Maze test.");
		
		control = new Controller();
		console = new Scanner(System.in);
		selection = "";
		
		
		while (!selection.equalsIgnoreCase("exit")) {
			System.out.print("Enter your selection: ");
			selection = console.nextLine();
			control.setSelection(selection);
			System.out.println("Your selection was: " + control.getSelection());
		}
		
		console.close();
		System.out.println("Goodbye!");
	}

}
