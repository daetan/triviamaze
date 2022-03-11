package maze;

public class mazePrint {

	public static void main(String[] args) {
		horizontal();
		vertical();
		horizontal();
		vertical();
	}

	private static String northWall() {
		String room = "";
		room += "++++";
		return room;
	}

	private static void vertical() {
		for (int i = 1; i < 5; i++) {
			System.out.println("+");
		}
	}

	private static void horizontal() {
		for (int i = 1; i < 5; i++) {
			System.out.print("+");
		}
	}
}
