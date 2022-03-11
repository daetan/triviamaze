package maze;

import java.io.Serializable;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947234501234725063L;
	private Door N;
	private Door W;
	private Door S;
	private Door E;
	private boolean entrance;
	private boolean exit;
	private QuestionDatabase question;
	private boolean questionAnswered = false;

	/**
	 * 
	 * 
	 */

	public Room() {
		N = new Door();
		W = new Door();
		S = new Door();
		E = new Door();
		question = new QuestionDatabase();
		entrance = false;
		exit = false;

	}

	/**
	 * 
	 * 
	 * @param entrance
	 * @param exit
	 */
	public Room(boolean entrance, boolean exit) {
		this.N = new Door();
		this.W = new Door();
		this.S = new Door();
		this.E = new Door();
		question = new QuestionDatabase();
		this.entrance = entrance;
		this.exit = exit;
	}

	/**
	 * 
	 * 
	 * @return
	 */

	public boolean getEntrance() {
		return entrance;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getExit() {
		return exit;
	}

	/**
	 * 
	 * 
	 * @param direction
	 * @return
	 */
	public Door getDoor(String direction) {
		if (direction == "N" || direction == "n") {
			return this.N;
		} else if (direction == "W" || direction == "w") {
			return this.W;
		} else if (direction == "S" || direction == "s") {
			return this.S;
		} else if (direction == "E" || direction == "e") {
			return this.E;
		}
		return N;

	}

	/**
	 * 
	 * 
	 * @param direction
	 * @param wall
	 */

	public void setWall(String direction, boolean wall) {
		if (direction == "N" || direction == "n") {
			N.setWall(wall);
		} else if (direction == "W" || direction == "w") {
			W.setWall(wall);
		} else if (direction == "S" || direction == "s") {
			S.setWall(wall);
		} else if (direction == "E" || direction == "e") {
			E.setWall(wall);
		}
	}

	/**
	 * 
	 * 
	 * @param direction
	 * @param locked
	 */
	public void setDoor(String direction, boolean locked) {

		if (direction == "N" || direction == "n") {
			N.setLocked(locked);
		} else if (direction == "W" || direction == "w") {
			W.setLocked(locked);
		} else if (direction == "S" || direction == "s") {
			S.setLocked(locked);
		} else if (direction == "E" || direction == "e") {
			E.setLocked(locked);
		}
	}

	public boolean getQuestionAnswered() {
		return this.questionAnswered;
	}

	public void setQuestionAnswered(boolean state) {
		this.questionAnswered = state;
	}

	public String setQuestion(int r) {

		return question.getQuestionsIndex(r);

	}

	public void displayRoom() {

		System.out.println("N: " + N.printDoor());
		System.out.println("S: " + S.printDoor());
		System.out.println("E: " + E.printDoor());
		System.out.println("W: " + W.printDoor());

	}

}
