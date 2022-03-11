package maze;

public class Main {
	public static void main(String[] args) {

		Player c = new Player();

		Maze m = new Maze(5, 5, c);
		m.setPlayerLoc(4, 4);
		m.displayMaze();

	}
	/**
	 * 
	 * Room 0, 0 = ArrayList(Questions) Room 0, 1 Room 0, 2 Room 0, 3 =
	 * ArrayList(questions)
	 */
}
