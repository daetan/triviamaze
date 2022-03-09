/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
class Control implements ControlInterface {
    // View -> User
    // User -> Control

    // A:
    // Control -> Model
    // Model -> View

    // B:
    // Control -> View

    private static ModelMazeInterface myMaze;
    private static View myView;

    Control(final ModelMazeInterface theModel) {
        myMaze = theModel;
        myView = new View(this, myMaze);
        myView.createView();
        myView.promptInput();
        myMaze.initialize();
    }

    @Override
    void start() {
        model.placeuser();
        view.
    }

    @Override
    void move(final String theMove) {
        // TODO Auto-generated method stub
        boolean result = myUser.move(theMove);
        if (!result) { // Could have View observe for Error string...
            myView.error("Can't move that way.");
        }
    }

    @Override
    void answer(final String theAnswer) {
        // TODO pass short word or number to trivia object
        // Answers: A B C D T F 1 2 Short answer
        // File operations: [S]ave [L]oad [E]xit
    }

    @Override
    void save() {
        // TODO implement serialization
    }

    @Override
    void load(final String theLoad) {
        // TODO implement deserialization
    }

    @Override
    void exit() {
        // TODO
    }

    @Override
    void about() {
        // TODO Abo[u]t, [G]ame play instructions, C[h]eats
    }
    
    @Override
    void win() {
        // TODO
    }
    
    @Override
    void lose() {
        // TODO Auto-generated method stub
        
    }
}
