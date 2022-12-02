import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class View extends JFrame {
	
	private JPanel gamePanel, gameScorePanel, iconPanel;
	private JButton[] squares;
	private JLabel oLabel, xLabel, iconLabel, turnLabel, oScoreLabel, xScoreLabel;
	private JPawnO[] oPawn;
	private JPawnX[] xPawn;
	private int xScore, oScore;
	private ImageIcon icon;
	private Border border;
	private Color color;
	
	public View(Controller controller) throws IOException {
		border = BorderFactory.createLineBorder(Color.darkGray, 5);
		color = new Color(100, 90, 70);

		// Squares
		squares = new JButton[9];
		for(int i = 0; i < 9; i++) {
			squares[i] = new JButton();
			squares[i].setBorder(border);
			squares[i].setOpaque(true);
			squares[i].setBackground(Color.black);
			squares[i].setFont(new Font("Arial", 150, 150));
			squares[i].addActionListener(controller);
			squares[i].setActionCommand(Integer.toString(i));
		}
		
		// JPawns
		oPawn = new JPawnO[9];
		xPawn = new JPawnX[9];
		for(int i = 0; i < 9; i++) {
			oPawn[i] = new JPawnO(squares[0], Color.blue);
			xPawn[i] = new JPawnX(squares[0], Color.red);
		}
		
		// JLabels
		oScoreLabel = new JLabel();
		oScoreLabel.setText(Integer.toString(oScore));
		xScoreLabel = new JLabel();
		xScoreLabel.setText(Integer.toString(xScore));
		oLabel = new JLabel();
		oLabel.setText("O");
		oLabel.setForeground(Color.blue);
		xLabel = new JLabel();
		xLabel.setText("X");
		xLabel.setForeground(Color.red);
		turnLabel = new JLabel();
		turnLabel.setText(oLabel.getText());
		turnLabel.setForeground(Color.blue);
		
		// GamePanel
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3, -5, -5));
		for(int i = 0; i < 9; i++)
			gamePanel.add(squares[i]);
		
		// GameScorePanel
		gameScorePanel = new JPanel();
		gameScorePanel.setLayout(new BoxLayout(gameScorePanel, BoxLayout.X_AXIS));
		gameScorePanel.add(new JLabel("Player "));
		gameScorePanel.add(xLabel);
		gameScorePanel.add(new JLabel(" Score: "));
		gameScorePanel.add(xScoreLabel);
		gameScorePanel.add(Box.createHorizontalGlue());
		gameScorePanel.add(new JLabel("It's "));
		gameScorePanel.add(turnLabel);
		gameScorePanel.add(new JLabel("'s turn!"));
		gameScorePanel.add(Box.createHorizontalGlue());
		gameScorePanel.add(new JLabel("Player "));
		gameScorePanel.add(oLabel);
		gameScorePanel.add(new JLabel(" Score: "));
		gameScorePanel.add(oScoreLabel);
		gameScorePanel.setBackground(color);
		gameScorePanel.setBorder(border);
		
		// IconPanel
		iconPanel = new JPanel();
		iconPanel.setBackground(color);
		iconPanel.setBorder(border);
		icon = loadIcon("tttlogo.png", 70, 50);
		iconLabel = new JLabel(icon, JLabel.HORIZONTAL);
		iconPanel.add(iconLabel);
		
		// JFrame
		this.add(gameScorePanel, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(iconPanel, BorderLayout.SOUTH);
		
		this.setTitle("TIC TAC TOE");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 600);
		
		controller.setView(this);
	}
	
	public ImageIcon loadIcon(String filePath, int width, int height) throws IOException {
		return new ImageIcon(ImageIO.read(new File(filePath)).getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}

	public void setPawn(int turn, int square) {
		if(turn == 0) {
			turnLabel.setText(xLabel.getText());
			turnLabel.setForeground(Color.red);
			squares[square].add(oPawn[square]);
		} else if(turn == 1) {
			turnLabel.setText(oLabel.getText());
			turnLabel.setForeground(Color.blue);
			squares[square].add(xPawn[square]);
		}
	}

	public void setScore(int turn) {
		if(turn % 2 == 0) {
			oScore++;
			oScoreLabel.setText(Integer.toString(oScore));
		}
		else {
			xScore++;
			xScoreLabel.setText(Integer.toString(xScore));
		}
	}

	public void clearBoard() {
		for(int i = 0; i < 9; i++) {
			squares[i].remove(oPawn[i]);
			squares[i].remove(xPawn[i]);
		}
	}

	public void showJOptionPane(String string) {
		if(string.contains("O"))
			JOptionPane.showMessageDialog(this, string + " won the game!", "GAME OVER!", JOptionPane.INFORMATION_MESSAGE, icon);
		else if(string.contains("X"))
			JOptionPane.showMessageDialog(this, string + " won the game!", "GAME OVER!", JOptionPane.INFORMATION_MESSAGE, icon);
		else if(string.contains("Draw"))
			JOptionPane.showMessageDialog(this, "It's a draw!", "GAME OVER!", JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
