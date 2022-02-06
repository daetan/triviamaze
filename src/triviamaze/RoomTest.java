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
class RoomTest {
	
	static Room my1By1MazeCenterRoom;
	
	static Room my3By3MazeCenterRoom;
	
	static Room[][] my3By3MazeRooms;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		my1By1MazeCenterRoom = new Room(new Maze(1,1), 1, 1);
		Maze a3By3Maze = new Maze(3, 3);
		my3By3MazeCenterRoom = new Room(a3By3Maze, 2, 2);
		//TODO import below snippet into Maze for Room[][] initialization 
		my3By3MazeRooms = a3By3Maze.getMyRooms();
		for (int x = 1; x <= 3; x++) {
			for (int y = 1; y <= 3; y++) {
				my3By3MazeRooms[x][y] = new Room(a3By3Maze, x, y);
			}
		}
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
	void test1By1MazeCenterRoomHasNoDoors() {
		assertEquals(my1By1MazeCenterRoom.getMyNumDoors(), 0);
		assertFalse(my1By1MazeCenterRoom.getMyHasEDoor());
		assertFalse(my1By1MazeCenterRoom.getMyHasSDoor());
		assertFalse(my1By1MazeCenterRoom.getMyHasWDoor());
		assertFalse(my1By1MazeCenterRoom.getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeCenterRoomHasAllDoors() {
		assertEquals(my3By3MazeCenterRoom.getMyNumDoors(), 4);
		assertTrue(my3By3MazeCenterRoom.getMyHasEDoor());
		assertTrue(my3By3MazeCenterRoom.getMyHasSDoor());
		assertTrue(my3By3MazeCenterRoom.getMyHasWDoor());
		assertTrue(my3By3MazeCenterRoom.getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsNW() {
		assertEquals(my3By3MazeRooms[1][1].getMyNumDoors(), 2);
		assertTrue(my3By3MazeRooms[1][1].getMyHasEDoor());
		assertTrue(my3By3MazeRooms[1][1].getMyHasSDoor());
		assertFalse(my3By3MazeRooms[1][1].getMyHasWDoor());
		assertFalse(my3By3MazeRooms[1][1].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsN() {
		assertEquals(my3By3MazeRooms[2][1].getMyNumDoors(), 3);
		assertTrue(my3By3MazeRooms[2][1].getMyHasEDoor());
		assertTrue(my3By3MazeRooms[2][1].getMyHasSDoor());
		assertTrue(my3By3MazeRooms[2][1].getMyHasWDoor());
		assertFalse(my3By3MazeRooms[2][1].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsNE() {
		assertEquals(my3By3MazeRooms[3][1].getMyNumDoors(), 2);
		assertFalse(my3By3MazeRooms[3][1].getMyHasEDoor());
		assertTrue(my3By3MazeRooms[3][1].getMyHasSDoor());
		assertTrue(my3By3MazeRooms[3][1].getMyHasWDoor());
		assertFalse(my3By3MazeRooms[3][1].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsW() {
		assertEquals(my3By3MazeRooms[1][2].getMyNumDoors(), 3);
		assertTrue(my3By3MazeRooms[1][2].getMyHasEDoor());
		assertTrue(my3By3MazeRooms[1][2].getMyHasSDoor());
		assertFalse(my3By3MazeRooms[1][2].getMyHasWDoor());
		assertTrue(my3By3MazeRooms[1][2].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsE() {
		assertEquals(my3By3MazeRooms[3][2].getMyNumDoors(), 3);
		assertFalse(my3By3MazeRooms[3][2].getMyHasEDoor());
		assertTrue(my3By3MazeRooms[3][2].getMyHasSDoor());
		assertTrue(my3By3MazeRooms[3][2].getMyHasWDoor());
		assertTrue(my3By3MazeRooms[3][2].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsSW() {
		assertEquals(my3By3MazeRooms[1][3].getMyNumDoors(), 2);
		assertTrue(my3By3MazeRooms[1][3].getMyHasEDoor());
		assertFalse(my3By3MazeRooms[1][3].getMyHasSDoor());
		assertFalse(my3By3MazeRooms[1][3].getMyHasWDoor());
		assertTrue(my3By3MazeRooms[1][3].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsS() {
		assertEquals(my3By3MazeRooms[2][3].getMyNumDoors(), 3);
		assertTrue(my3By3MazeRooms[2][3].getMyHasEDoor());
		assertFalse(my3By3MazeRooms[2][3].getMyHasSDoor());
		assertTrue(my3By3MazeRooms[2][3].getMyHasWDoor());
		assertTrue(my3By3MazeRooms[2][3].getMyHasNDoor());
	}
	
	@Test
	void test3By3MazeRoomsSE() {
		assertEquals(my3By3MazeRooms[3][3].getMyNumDoors(), 2);
		assertFalse(my3By3MazeRooms[3][3].getMyHasEDoor());
		assertFalse(my3By3MazeRooms[3][3].getMyHasSDoor());
		assertTrue(my3By3MazeRooms[3][3].getMyHasWDoor());
		assertTrue(my3By3MazeRooms[3][3].getMyHasNDoor());
	}
}
