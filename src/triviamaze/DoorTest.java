/**
 * 
 */
package triviamaze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author daeta
 *
 */
class DoorTest {
	
	static Door myTestDoor;
	
	static Room myTestRoom;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		myTestDoor = new Door();
		myTestRoom = new Room();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
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
	
	void testRoomLocked() {
		assertTrue(myTestRoom.getMyEDoor().getMyIsLocked());
		assertTrue(myTestRoom.getMySDoor().getMyIsLocked());
		assertTrue(myTestRoom.getMyWDoor().getMyIsLocked());
		assertTrue(myTestRoom.getMyNDoor().getMyIsLocked());
	}
	
}
