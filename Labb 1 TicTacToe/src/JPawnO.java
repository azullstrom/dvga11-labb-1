import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class JPawnO extends JComponent {
	
	private JButton button;
	
	public JPawnO(JButton button, Color color) {
		this.button = button;
		setForeground(color);
	}

	/*@Override
	public Dimension getMinimumSize() {
		return new Dimension(100, 100);
	}
	
	@Override
	public Dimension getMaximumSize() {
		return new Dimension(button.getWidth(), button.getHeight());
	}*/
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(20));
		graphics.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
	}
}
