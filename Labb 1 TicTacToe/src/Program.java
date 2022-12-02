import java.io.IOException;

public class Program {

	public static void main(String[] args) throws IOException {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
	}
}
