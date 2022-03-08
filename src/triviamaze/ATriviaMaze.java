/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
public class ATriviaMaze {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        ModelMaze model = new ModelMaze(); //TODO refactor to interfaces: ModelMazeInterface and ControlInterface
        Control control = new Control(model);
    }
}
