/**
 * 
 */
package control;

import model.Maze;
import model.User;
import view.View;

/**
 * @author daeta
 *
 */
public class Control {
	//View -> User
	//User -> Control
	
	//A:
	//Control -> Model
	//Model -> View
	
	//B:
	//Control -> View
	
	private static Maze myMaze;
	private static User myUser;
	private static View myView;

	private static String mySelection;
	
	public Control(View theView) {
		myMaze = new Maze();
		myUser = new User();
		myView = theView;
	}
	
	public String getSelection() {
		return mySelection;
	}
	
	public void setSelection(String theSelection) {
		mySelection = theSelection;
	}
	
	public void move(final char theDirection) {
		boolean result = myUser.move(theDirection);
		if (!result) { // Could have View observe for Error string...
			myView.error("Can't move that way.");
		}
	}
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
	}
}
