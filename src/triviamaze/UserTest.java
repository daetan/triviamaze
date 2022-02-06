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
class UserTest {
	
	private static User my3by3MazeUser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		my3by3MazeUser = new User(new Maze(3, 3));
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
		my3by3MazeUser.setMyX(2);
		my3by3MazeUser.setMyY(2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetMyX() {
		assertEquals(my3by3MazeUser.getMyX(), 2);
	}
	
	@Test
	void testGetMyY() {
		assertEquals(my3by3MazeUser.getMyY(), 2);
	}
	
	@Test
	void testMoveE() {
		assertTrue(my3by3MazeUser.move('E'));
		assertEquals(my3by3MazeUser.getMyX(), 3);
		assertEquals(my3by3MazeUser.getMyY(), 2);
	}
	
	@Test
	void testMoveS() {
		assertTrue(my3by3MazeUser.move('S'));
		assertEquals(my3by3MazeUser.getMyX(), 2);
		assertEquals(my3by3MazeUser.getMyY(), 3);
	}
	
	@Test
	void testMoveW() {
		assertTrue(my3by3MazeUser.move('W'));
		assertEquals(my3by3MazeUser.getMyX(), 1);
		assertEquals(my3by3MazeUser.getMyY(), 2);
	}
	
	@Test
	void testMoveN() {
		assertTrue(my3by3MazeUser.move('N'));
		assertEquals(my3by3MazeUser.getMyX(), 2);
		assertEquals(my3by3MazeUser.getMyY(), 1);
	}
	
	@Test
	void testMoveNWByXY() {
		assertTrue(my3by3MazeUser.move(-1, -1));
		assertEquals(my3by3MazeUser.getMyX(), 1);
		assertEquals(my3by3MazeUser.getMyY(), 1);
	}
	
	@Test
	void testMoveNEByXY() {
		assertTrue(my3by3MazeUser.move(1, -1));
		assertEquals(my3by3MazeUser.getMyX(), 3);
		assertEquals(my3by3MazeUser.getMyY(), 1);
	}
	
	@Test
	void testMoveSWByXY() {
		assertTrue(my3by3MazeUser.move(-1, 1));
		assertEquals(my3by3MazeUser.getMyX(), 1);
		assertEquals(my3by3MazeUser.getMyY(), 3);
	}
	
	@Test
	void testMoveSEByXY() {
		assertTrue(my3by3MazeUser.move(1, 1));
		assertEquals(my3by3MazeUser.getMyX(), 3);
		assertEquals(my3by3MazeUser.getMyY(), 3);
	}
}
