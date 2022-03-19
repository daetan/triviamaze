/**
 * Trivia Maze
 * Group 6: Abdulrehim Shuba, Daetan Huck, and Hanad Pellissier
 * TCSS 360 Winter 2022
 */
package triviamaze;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *  Class that connects to the database and pulls 
 *  questions and answers from the tables in the database
 *  and loads them into Lists that can be easily used.
 *       1. call databaseConnection in order to setup the database
 *       2. call createQuestion() to create a question object
 */
class ModelQuestionDatabase implements Serializable {
    
    /**
     *  A long for serialization.
     */
    private static final long serialVersionUID = 7843813149543978519L;

    /**
     * Holds the index for which question and answer to search for.
     */
    private static int dbIndex = 0;

    /**
     * Holds the questions pulled from database.
     */
    private static final ArrayList<String> Questions = new ArrayList<>();

    /**
     * Holds the answers pulled from database.
     */
    private static final ArrayList<String> Answers = new ArrayList<>();

    /**
     * Connects to database and loads data within tables into lists.
     */
    static void databaseConnection() {

        // Create DataSource object.
        SQLiteDataSource ds = new SQLiteDataSource();
        
        // Set DataSource URL.
        ds.setUrl("jdbc:sqlite:TMazeQandA.db");
        
        // Select table where we want to get our questions and answers from.
        String query = "SELECT * FROM QandA";
        
        // Set up connection.
        try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            
            // Go through each row of results in the table and store within lists.
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

    /**
     * Creates question and answer from data in lists.
     * @return ModelQuestion
     */
    static ModelQuestion createQuestion() {
        return new ModelQuestion(getQuestion(), getAnswer());
    }

    /**
     * Gets Question String at randomly selected index.
     * @return String
     */
    static String getQuestion() {
        Random rand = new Random();
        dbIndex = rand.nextInt(Questions.size());
        return Questions.get(dbIndex);
    }

    /**
     * Gets Answer String at the previously-selected index.
     * @return String
     */
    static String getAnswer() {
        return Answers.get(dbIndex);
    }

}
