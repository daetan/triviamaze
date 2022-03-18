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
 * A test class for ModelRoom.
 */
class ModelRoomTest {

    /**
     * A test room.
     */
    static ModelRoom myTestRoom;

    /**
     * Initializes the test room.
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        myTestRoom = new ModelRoom();
    }

    @Test
    void testRoomHasUser() {
        assertFalse(myTestRoom.getMyHasUser());
        myTestRoom.setMyHasUser(true);
        assertTrue(myTestRoom.getMyHasUser());
    }
    
    @Test
    void testRoomIsWinningRoom() {
        assertFalse(myTestRoom.getMyIsWinningRoom());
        myTestRoom.setMyIsWinningRoom(true);
        assertTrue(myTestRoom.getMyIsWinningRoom());
    }
}
