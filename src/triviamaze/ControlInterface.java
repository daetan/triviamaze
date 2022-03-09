/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
interface ControlInterface {
    void start();
    void move(final String theMove);
    void answer(final String theAnswer);
    void save();
    void load(final String theLoad);
    void about();
    void exit();
    void win();
    void lose();
}
