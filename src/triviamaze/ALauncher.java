/**
 * 
 */
package triviamaze;

/**
 * @author daeta
 *
 */
public class ALauncher {
	/**
	 * @param args
	 */
	static void main(final String[] args) {
		ModelMaze model = new ModelMaze();
		Control control = new Control(model);
	}
}
