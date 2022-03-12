/**
 * 
 */
package triviamaze;

import java.io.Serializable;

//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import java.util.ArrayList;
//import java.util.List;

/**
 * @author daeta
 *
 */
class ModelUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6750355880804259040L;

    private Integer myCol;

    private Integer myRow;

//    private List<PropertyChangeListener> myListeners = new ArrayList<PropertyChangeListener>();

    ModelUser() {
        myCol = 1;
        myRow = 1;
    }

    void setMyCol(final Integer theX) {
        myCol = theX;
    }

    void setMyRow(final Integer theY) {
        myRow = theY;
    }

    Integer getMyCol() {
        return myCol;
    }

    Integer getMyRow() {
        return myRow;
    }

//    private void notifyMove(final int theX, final int theY) {
//        String theMyIntString;
//        String theIntString;
//        if (theX != 0) {
//            theMyIntString = Integer.toString(myX);
//            theIntString = Integer.toString(myX + theX);
//            notifyListeners(this, "myX", theMyIntString, theIntString);
//        }
//        if (theY != 0) {
//            theMyIntString = Integer.toString(myY);
//            theIntString = Integer.toString(myY + theY);
//            notifyListeners(this, "myY", theMyIntString, theIntString);
//        }
//    }

//    private void notifyListeners(final Object theObject, final String theProperty, final String theOldValue,
//            final String theNewValue) {
//        for (PropertyChangeListener aListener : myListeners) {
//            aListener.propertyChange(new PropertyChangeEvent(this, theProperty, theOldValue, theNewValue));
//        }
//    }
//
//    void addChangeListener(final PropertyChangeListener theNewListener) {
//        myListeners.add(theNewListener);
//    }

}
