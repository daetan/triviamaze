package triviamaze;

class ModelQuestionAnswer {
    boolean myIsLocked;

    boolean myIsPermanentLocked;

    ModelQuestionAnswer() {
        myIsLocked = true;
        myIsPermanentLocked = false;
    }

    boolean getMyIsLocked() {
        return myIsLocked;
    }

    void setMyIsLocked(final boolean theIsLocked) {
        myIsLocked = theIsLocked;
    }

}
