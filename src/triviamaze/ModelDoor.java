package triviamaze;

class ModelDoor {
    boolean myIsLocked;

    boolean myIsPermanentLocked;

    ModelDoor() {
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
