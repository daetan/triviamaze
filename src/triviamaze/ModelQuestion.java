package triviamaze;

import java.io.Serializable;

class ModelQuestion implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -402422357913381703L;

    private final String myQuestion;

    private final String myAnswer;

    public ModelQuestion(final String theQuestion, final String theAnswer) {
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
