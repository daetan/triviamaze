/**
 * 
 */
package model;

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
class MazeTest {
	
	private static Maze testDefaultMaze;
	private static Room[][] testDefaultRooms;
	
	private static Maze testEdge1000Maze;
	private static Room[][] testEdge1000Rooms;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testDefaultMaze = new Maze();
		testDefaultRooms = testDefaultMaze.getMyRooms();
		
		testEdge1000Maze = new Maze(1000, 1000);
		testEdge1000Rooms = testEdge1000Maze.getMyRooms();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDefaultConstructorHeight() {
		assertEquals(testDefaultMaze.getMyHeight(), 2);
	}
	
	@Test
	void testDefaultConstructorWidth() {
		assertEquals(testDefaultMaze.getMyWidth(), 2);
	}
	
	@Test
	void testDefaultConstructorIsSolvable() {
		assertTrue(testDefaultMaze.getIsSolvable());
	}
	
	@Test
	void testDefaultConstructorMyRoomsHeight() {
		assertEquals(testDefaultRooms.length, 4);
	}
	
	@Test
	void testDefaultConstructorMyRoomsWidth() {
		assertEquals(testDefaultRooms[0].length, 4);
	}
	
	/**
	 * Maze constructs a
	 */
	@Test
	void testDefaultIsValidRoom() {
		assertFalse(testDefaultMaze.isValidRoom(0, 0), "Room 0, 0 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(0, 1), "Room 0, 1 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(0, 2), "Room 0, 2 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(0, 3), "Room 0, 3 returned true instead of false.");

		assertFalse(testDefaultMaze.isValidRoom(1, 0), "Room 1, 0 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(1, 3), "Room 1, 3 returned true instead of false.");

		assertFalse(testDefaultMaze.isValidRoom(2, 0), "Room 2, 0 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(2, 3), "Room 2, 3 returned true instead of false.");

		assertFalse(testDefaultMaze.isValidRoom(3, 0), "Room 3, 0 returned true instead of false.");
		assertFalse(testDefaultMaze.isValidRoom(3, 3), "Room 3, 3 returned true instead of false.");

		assertTrue(testDefaultMaze.isValidRoom(1, 1), "Room 1, 1 returned false instead of true.");
		assertTrue(testDefaultMaze.isValidRoom(1, 2), "Room 1, 2 returned false instead of true.");
		assertTrue(testDefaultMaze.isValidRoom(2, 1), "Room 2, 1 returned false instead of true.");
		assertTrue(testDefaultMaze.isValidRoom(2, 2), "Room 2, 2 returned false instead of true.");	
	}
	
	void testEdge1000ConstructorHeight() {
		assertEquals(testEdge1000Maze.getMyHeight(), 1000);
	}
	
	@Test
	void testEdge1000ConstructorWidth() {
		assertEquals(testEdge1000Maze.getMyWidth(), 1000);
	}
	
	@Test
	void testEdge1000ConstructorIsSolvable() {
		assertTrue(testEdge1000Maze.getIsSolvable());
	}
	
	@Test
	void testEdge1000ConstructorMyRoomsHeight() {
		assertEquals(testEdge1000Rooms.length, 1002);
	}
	
	@Test
	void testEdge1000ConstructorMyRoomsWidth() {
		assertEquals(testEdge1000Rooms[0].length, 1002);
	}

	@Test
	void testEdge1000IsValidRoom() {
		assertFalse(testEdge1000Maze.isValidRoom(0, 0), "Room 0, 0 returned true instead of false.");
		assertFalse(testEdge1000Maze.isValidRoom(0, 1001), "Room 0, 1001 returned true instead of false.");
		assertFalse(testEdge1000Maze.isValidRoom(1001, 0), "Room 1001, 0 returned true instead of false.");
		assertFalse(testEdge1000Maze.isValidRoom(1001, 1001), "Room 1001, 1001 returned true instead of false.");

		assertFalse(testEdge1000Maze.isValidRoom(500, 0), "Room 500, 0 returned true instead of false.");
		assertFalse(testEdge1000Maze.isValidRoom(500, 1001), "Room 500, 1001 returned true instead of false.");

		assertFalse(testEdge1000Maze.isValidRoom(0, 500), "Room 0, 500 returned true instead of false.");
		assertFalse(testEdge1000Maze.isValidRoom(1001, 500), "Room 1001, 500 returned true instead of false.");

		assertTrue(testEdge1000Maze.isValidRoom(1, 1), "Room 1, 1 returned false instead of true.");
		assertTrue(testEdge1000Maze.isValidRoom(1, 1000), "Room 1, 1000 returned false instead of true.");
		assertTrue(testEdge1000Maze.isValidRoom(1000, 1), "Room 1000, 1 returned false instead of true.");
		assertTrue(testEdge1000Maze.isValidRoom(1000, 1000), "Room 1000, 1000 returned false instead of true.");	
		assertTrue(testEdge1000Maze.isValidRoom(500, 500), "Room 500, 500 returned false instead of true.");	
	}

}
