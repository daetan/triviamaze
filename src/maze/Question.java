package maze;

import java.io.Serializable;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8803674823619089654L;

	private final String myQuestion;

	private final String myAnswer;

	public Question(String theQuestion, String theAnswer) {
		this.myAnswer = theQuestion;
		this.myQuestion = theAnswer;

	}

	public String getQuestion() {
		return myQuestion;
	}

	public String getAnswer() {
		return myAnswer;
	}

}