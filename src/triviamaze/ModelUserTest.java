/**
 * Trivia Maze
 * Group 6: Abdulrehim Shuba, Daetan Huck, and Hanad Pellissier
 * TCSS 360 Winter 2022
 */
package triviamaze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the ModelUser class.
 */
class ModelUserTest {

    /**
     * A test user.
     */
    private static ModelUser myTestUser;

    /**
     * Sets up a single test user.
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        myTestUser = new ModelUser();
    }

    /**
     * Sets user to column and row 2 before each test.
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        myTestUser.setMyCol(2);
        myTestUser.setMyRow(2);
    }

    @Test
    void testGetMyCol() {
        assertEquals(myTestUser.getMyCol(), 2);
    }

    @Test
    void testGetMyRow() {
        assertEquals(myTestUser.getMyRow(), 2);
    }

    @Test
    void testMoveCol() {
        myTestUser.setMyCol(3);
        assertEquals(myTestUser.getMyCol(), 3);
    }

    @Test
    void testMoveRow() {
        myTestUser.setMyRow(3);
        assertEquals(myTestUser.getMyRow(), 3);
    }
}
