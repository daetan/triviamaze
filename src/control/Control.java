/**
 * 
 */
package control;

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

	private static String mySelection;
	
	public Control() {
	}
	
	public String getSelection() {
		return mySelection;
	}
	
	public void setSelection(String theSelection) {
		mySelection = theSelection;
	}
	
	/**
	 * @param args
	 */
	static void main(String[] args) {
	}
}
