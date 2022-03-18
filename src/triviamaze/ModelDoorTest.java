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
 * Test class for ModelDoor.
 */
class ModelDoorTest {

    /**
     * A test door.
     */
    static ModelDoor myTestDoor;

    /**
     * Re-initializes door before each test.
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        myTestDoor = new ModelDoor();
    }

    @Test
    void doorStartsLocked() {
        assertTrue(myTestDoor.getMyIsLocked());
    }

    @Test
    void testDoorUnlocksAndLocks() {
        myTestDoor.setMyIsLocked(false);
        assertFalse(myTestDoor.getMyIsLocked());
        myTestDoor.setMyIsLocked(true);
        assertTrue(myTestDoor.getMyIsLocked());
    }
    
    @Test
    void doorStartsUnblocked() {
        assertFalse(myTestDoor.getMyIsBlocked());
    }    

    void testDoorBlocksAndUnBlocks() {
        assertFalse(myTestDoor.getMyIsBlocked());
        myTestDoor.setMyIsBlocked(true);
        assertTrue(myTestDoor.getMyIsBlocked());
    }

}
