/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
class Control implements ControlInterface {

    private static ModelMazeInterface myMaze;
    private static View myView;

    Control(final ModelMazeInterface theModel) {
        myMaze = theModel;
        myView = new View(this, myMaze);
        myView.start();
        myMaze.start();
    }

    @Override
    public void start() {
        myMaze.start();
        myView.start();
    }

    @Override
    public void move(final String theMove) {
        // TODO Auto-generated method stub
        boolean result = myUser.move(theMove);
        if (!result) { // Could have View observe for Error string...
            myView.error("Can't move that way.");
        }
    }

    @Override
    public void answer(final String theAnswer) {
        // TODO pass short word or number to trivia object
        // Answers: A B C D T F 1 2 Short answer
        // File operations: [F]ile -> [S]ave [L]oad [E]xit
    }

    @Override
    public void save() {
        // TODO implement serialization
    }

    @Override
    public void load(final String theLoad) {
        // TODO implement deserialization
    }

    @Override
    public void exit() {
        // TODO
    }

    @Override
    public void about() {
        // TODO Abo[u]t, [G]ame play instructions, C[h]eats
    }
    
    @Override
    public void win() {
        // TODO
    }
    
    @Override
    public void lose() {
        // TODO Auto-generated method stub
        
    }
}
