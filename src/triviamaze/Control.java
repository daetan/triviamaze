/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
class Control {
	//View -> User
	//User -> Control
	
	//A:
	//Control -> Model
	//Model -> View
	
	//B:
	//Control -> View
	
	private static ModelMaze myMaze;
	private static ModelUser myUser;
	private static View myView;

	private static String mySelection;
	
	Control(final View theView) {
		myMaze = new ModelMaze();
		myUser = new ModelUser();
		myView = theView;
	}
	
	String getSelection() {
		return mySelection;
	}
	
	void setSelection(final String theSelection) {
		mySelection = theSelection;
	}
	
	void move(final char theDirection) {
		boolean result = myUser.move(theDirection);
		if (!result) { // Could have View observe for Error string...
			myView.error("Can't move that way.");
		}
	}
	
	/**
	 * @param args
	 */
	static void main(final String[] args) {
	}
}
