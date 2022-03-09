/**
 * 
 */
package triviamaze;

import java.beans.PropertyChangeListener;

/**
 * @author daeta
 *
 */
interface ModelMazeInterface {
    
    void initialize();
    void start();
    void move(final String theMove);
    void answer(final String theAnswer);
    void save();
    void load(final String theLoad);
    void about();
    void exit();
    void win();
    void lose();
    void notifyListeners(final Object theObject, final String theProperty, final String theOldValue,
            final String theNewValue);
    void addChangeListener(final PropertyChangeListener theNewListener);

}
