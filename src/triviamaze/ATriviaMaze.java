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
        ModelMazeInterface model = new ModelMaze(); //TODO refactor to interfaces: ModelMazeInterface and ControlInterface
        @SuppressWarnings("unused")
        ControlInterface control = new Control(model);
    }
}
