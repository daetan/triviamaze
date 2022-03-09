package model;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QuestionDatabase implements Serializable {
	
	private static int dbIndex = 0;
	
	private static final ArrayList<String> Questions = new ArrayList<>();
	
	 private static final ArrayList<String> Answers = new ArrayList<>();
	
	public static void databaseConnection() { 
	
		//Create DataSource object
        SQLiteDataSource ds = new SQLiteDataSource();
        //Set DataSource URL
        ds.setUrl("jdbc:sqlite:TMazeQandA.db");
        //Set where we want to get our questions and answers from
        String query = "SELECT * FROM QandA";
        //Set up the connection
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
          //walk through each 'row' of results and store within array lists  
            while (rs.next()) {
                String question = rs.getString("Question");
                String answer = rs.getString("Answer");
                Questions.add(question);
                Answers.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    } 
	
	public static String getQuestion() {
		//Will iterate through all questions in database
		dbIndex++;
		if (dbIndex == Questions.size()) {
			dbIndex = 0;
		}
        return Questions.get(dbIndex);
	}
	
	public static String getAnswer() {
		return Answers.get(dbIndex);
	}
	
	public static Question createQuestion() {
		
		return new Question(getQuestion(), getAnswer());
	}
	
	public static int getdbIndex() {
		return dbIndex;
	}
	    
}


