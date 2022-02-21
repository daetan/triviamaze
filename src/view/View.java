/**
 * 
 */
package view;

import java.util.Scanner;
import control.Control;
import model.Maze;
import model.User;
import view.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author daeta
 *
 */
public class View implements PropertyChangeListener {
	private static Control myControl;
	private static Scanner myConsole;
	private static String mySelection;

	
	public View(User theUser) {
		theUser.addChangeListener(this);
	}
	
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Changed property: " + event.getPropertyName() + " [old -> "
            + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final User aUser = new User();
		new View(aUser);
		aUser.move(1, 0);
		aUser.move(0, 1);
		aUser.move(-1, 0);
		aUser.move(0, -1);
		
		System.out.println("Welcome to Trivia Maze test.");
		final View aView = new View(aUser);
		myControl = new Control(aView);
		myConsole = new Scanner(System.in);
		mySelection = "";
		
		while (!mySelection.equalsIgnoreCase("exit")) {
			System.out.print("Enter your selection: ");
			mySelection = myConsole.nextLine();
			myControl.setSelection(mySelection);
			System.out.println("Your selection was: " + myControl.getSelection());
		}
		
		myConsole.close();
		System.out.println("Goodbye!");
	}

	public void error(String theString) {
		System.out.println(theString);
	}

}
