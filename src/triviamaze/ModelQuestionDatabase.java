/**
 * 
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
 * @author daeta
 *
 */
public class ModelQuestionDatabase implements Serializable {
    /**
     * 1. first call databaseConnection in order to setup the database
     * 2. call createQuestion() to create a question object
     */
    private static final long serialVersionUID = 7843813149543978519L;

    private static int dbIndex = 0;

    private static final ArrayList<String> Questions = new ArrayList<>();

    private static final ArrayList<String> Answers = new ArrayList<>();

    public static void databaseConnection() {

        // Create DataSource object
        SQLiteDataSource ds = new SQLiteDataSource();
        // Set DataSource URL
        ds.setUrl("jdbc:sqlite:TMazeQandA.db");
        // Select table where we want to get our questions and answers from
        String query = "SELECT * FROM QandA";
        // Set up connection
        try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            // go through each row of results in the table and store within lists
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

    public static ModelQuestion createQuestion() {
        return new ModelQuestion(getQuestion(), getAnswer());
    }

    public static String getQuestion() {

        Random rand = new Random();
        dbIndex = rand.nextInt(Questions.size());
        return Questions.get(dbIndex);
    }

    public static String getAnswer() {
        return Answers.get(dbIndex);
    }

}
