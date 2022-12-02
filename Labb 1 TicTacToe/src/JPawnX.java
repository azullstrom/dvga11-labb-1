import java.awt.*;
import javax.swing.*;

public class JPawnX extends JComponent {
	
	private Color color;
	private JButton button;
	
	public JPawnX(JButton button, Color color) {
		this.button = button;
		this.color = color;
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
		graphics.drawLine(0, 0, getWidth(), getHeight());
		graphics.drawLine(0, button.getHeight() - 15, button.getWidth() - 15, 0);
	}
}
