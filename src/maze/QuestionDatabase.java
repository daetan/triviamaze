package maze;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.sqlite.SQLiteDataSource;

public class QuestionDatabase implements Serializable {

	private static int dbIndex = 0;

	private final static ArrayList<String> Questions = new ArrayList<>();

	private final static ArrayList<String> Answers = new ArrayList<>();

	public void databaseConnection() {

		// Create DataSource object
		SQLiteDataSource ds = new SQLiteDataSource();
		// Set DataSource URL
		ds.setUrl("jdbc:sqlite:TMazeQandA.db");
		// Set where we want to get our questions and answers from
		String query = "SELECT * FROM QandA";
		// Set up the connection
		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			// walk through each 'row' of results and store within array lists
			while (rs.next()) {
				String question = rs.getString("Questions");
				String answer = rs.getString("Answers");
				Questions.add(question);
				Answers.add(answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String getQuestion() {
		// Will iterate through all questions in database
		databaseConnection();
		dbIndex++;
		if (dbIndex == Questions.size()) {
			dbIndex = 0;
		}
		return Questions.get(dbIndex);
	}

	public String getAnswer() {
		databaseConnection();
		return Answers.get(dbIndex);
	}

	public Question createQuestion() {

		return new Question(getQuestion(), getAnswer());
	}

	public int getdbIndex() {
		return dbIndex;
	}

	/**
	 * A method that get return answer for specific question
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		QuestionDatabase p = new QuestionDatabase();
		// p.databaseConnection();
		String a = p.getQuestion();
		System.out.println(a);
		int b = p.indexOfQuestion(a);
		System.out.println(b);
	}

	/**
	 * a.(i) == get(i);
	 * 
	 */
	public String getQuestionsIndex(int index) {
		databaseConnection();
		String res = Questions.get(0);
		for (int i = 0; i < Questions.size(); i++) {
			res = Questions.get(index);
		}
		return res;
	}

	/***
	 * question -> index(value)
	 * 
	 * @param question
	 * @return
	 */
	public int indexOfQuestion(String question) {
		databaseConnection();
		int res = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < Questions.size(); i++) {
			question = Questions.get(i);
			map.put(question, Integer.valueOf(i));

		}
		// iterate through map elements and get value for every key

		for (String quest : map.keySet()) {
			res = map.get(quest).intValue();
		}
		return res;
	}
}
