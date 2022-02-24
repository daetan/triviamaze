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
	private static View myView;
	
	Control(final ModelMaze theMaze) {
		myMaze = theMaze;
		myView = new View(this, myMaze);
		myView.createView();
		myView.promptInput();
	}
	
	void start() {
		//TODO user enters, maze setup
	}
	
	void move(final char theDirection) {
		boolean result = myUser.move(theDirection);
		if (!result) { // Could have View observe for Error string...
			myView.error("Can't move that way.");
		}
	}
	
	void ask() {
		//TODO user moves in direction of locked door


	}
	
	void answer(final char theAnswer) {
		//TODO pass char as answer to trivia object
		//TODO combine with String signature below
	}
	
	void answer(final String theAnswer) {
		//TODO pass short word or number to trivia object
		//Answers: A B C D T F 1 2 Short answer
		//File operations: [S]ave [L]oad [E]xit
	}
	
	void save() {
		//TODO implement serialization
	}
	
	void load() {
		//TODO implement deserialization
	}
	
	void exit() {
		//TODO
	}
	
	void about() {
		//TODO Abo[u]t, [G]ame play instructions, C[h]eats
	}
	
	void win() {
		//TODO
	}
	
	/**
	 * @param args
	 */
	static void main(final String[] args) {
	}
}
