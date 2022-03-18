package triviamaze;

import java.io.Serializable;

/**
 * Class that stores both the Question and Answer
 */
class ModelQuestion implements Serializable {
    
    /**
     * A long for serializing.
     */
    private static final long serialVersionUID = -402422357913381703L;

    /**
     * String that stores the Question
     */
    private final String myQuestion;

    /**
     * String that stores the Answer
     */
    private final String myAnswer;

    /**
     * Creates a question object that has 
     * both a question and answer
     * 
     * @param theQuestion
     * @param theAnswer
     */
    ModelQuestion(final String theQuestion, final String theAnswer) {
            myQuestion = theQuestion;
            myAnswer = theAnswer;
        }

    /**
     * Returns question
     * 
     * @return
     */
    String getQuestion() {
        return myQuestion;
    }

    /**
     * Returns answer for the question
     * 
     * @return
     */
    String getAnswer() {
        return myAnswer;
    }

}
