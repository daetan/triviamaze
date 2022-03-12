/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
interface ModelMazeInterface {
    void start();
    void move(final String theMove);
    void answer(final String theAnswer);
    void save();
    ModelMazeInterface load(final ModelMazeInterface theMaze);
    void about();
    void exit();
    void win();
    void lose();
}
