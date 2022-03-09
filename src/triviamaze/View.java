/**
 * 
 */
package triviamaze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import control.Control;
import model.Maze;
import model.User;
import view.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author daeta
 *
 */
class View implements PropertyChangeListener {
    private static ModelMazeInterface myMaze;
    private static ControlInterface myControl;

    private static Scanner myConsole;
    private static String mySelection;

    private List<PropertyChangeListener> myListeners = new ArrayList<PropertyChangeListener>();

    View(final ControlInterface theControl, final ModelMazeInterface theMaze) {
        myMaze = theMaze;
        myControl = theControl;
        myMaze.addChangeListener(this);
    }

    void start() {
        //TODO write escape
        System.out.println("Welcome to Trivia Maze!");
        myConsole = new Scanner(System.in);
        mySelection = "";

        while (!mySelection.equalsIgnoreCase("E")) {
            printView();
            System.out.print("Enter your selection: ");
            mySelection = myConsole.nextLine();
            myControl.setSelection(mySelection);
            System.out.println("Your selection was: " + myControl.getSelection());
        }

        myConsole.close();
        System.out.println("Goodbye!");
    }

    void error(final String theString) {
        System.out.println(theString);
    }

    void setMySelection(final String theString) {
        notifyListeners(this, "Selection", mySelection, theString);
        mySelection = theString;
    }

    private void notifyListeners(final Object theObject, final String theProperty, final String theOldValue,
            final String theNewValue) {
        for (PropertyChangeListener aListener : myListeners) {
            aListener.propertyChange(new PropertyChangeEvent(this, theProperty, theOldValue, theNewValue));
        }
    }

    void addChangeListener(final PropertyChangeListener theNewListener) {
        myListeners.add(theNewListener);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        System.out.println("Changed property: " + event.getPropertyName() + " [old -> " + event.getOldValue()
                + "] | [new -> " + event.getNewValue() + "]");
    }
}
