/**
 * 
 */
package view;

//import java.util.Scanner;
//import controller.Controller;
import model.User;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author daeta
 *
 */
class View implements PropertyChangeListener {
	
//	private static Controller control;
//	private static Scanner console;
//	private static String selection;
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
//		System.out.println("Welcome to Trivia Maze test.");
//		
//		control = new Controller();
//		console = new Scanner(System.in);
//		selection = "";
//		
//		
//		while (!selection.equalsIgnoreCase("exit")) {
//			System.out.print("Enter your selection: ");
//			selection = console.nextLine();
//			control.setSelection(selection);
//			System.out.println("Your selection was: " + control.getSelection());
//		}
//		
//		console.close();
//		System.out.println("Goodbye!");
		final User aUser = new User();
		final View aView = new View(aUser);
		aUser.move(1, 0);
		aUser.move(0, 1);
		aUser.move(-1, 0);
		aUser.move(0, -1);
	}

}
