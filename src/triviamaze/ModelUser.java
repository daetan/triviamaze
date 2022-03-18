/**
 * Trivia Maze
 * Group 6: Abdulrehim Shuba, Daetan Huck, and Hanad Pellissier
 * TCSS 360 Winter 2022
 */
package triviamaze;

import java.io.Serializable;

/**
 * The user class that stores the user's column and row.
 */
class ModelUser implements Serializable {

    /**
     * A long for serializing the user's position.
     */
    private static final long serialVersionUID = -6750355880804259040L;

    /**
     * User's column.
     */
    private Integer myCol;

    /**
     * User's row.
     */
    private Integer myRow;

    /**
     * Default constructor
     */
    ModelUser() {
        myCol = 1;
        myRow = 1;
    }

    /**
     * Sets the user column. Input values are error-checked in the trivia maze.
     * @param theCol
     */
    void setMyCol(final Integer theCol) {
        myCol = theCol;
    }

    /**
     * Sets the user row. Input values are error-checked in the trivia maze.
     * @param theRow
     */
    void setMyRow(final Integer theRow) {
        myRow = theRow;
    }

    /**
     * Gets the user column.
     * @return int
     */
    Integer getMyCol() {
        return myCol;
    }

    /**
     * Gets the user row.
     * @return int
     */
    Integer getMyRow() {
        return myRow;
    }
}
