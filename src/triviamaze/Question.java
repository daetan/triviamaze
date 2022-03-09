package model;

import java.io.Serializable;

public class Question implements Serializable {

	private final String myQuestion;
	
	private final String myAnswer;
	
 		
		public Question(final String theQuestion, final String theAnswer) {
	        myQuestion = theQuestion;
	        myAnswer = theAnswer;
	    }
		
		public String getQuestion() {
	        return myQuestion;
	    }

		 public String getAnswer() {
		        return myAnswer;
		    }
	}


