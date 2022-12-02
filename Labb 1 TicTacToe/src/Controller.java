import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	
	private Model model;
	private View view;
	private boolean[] click;
	
	public Controller(Model model) {
		this.model = model;
		click = new boolean[9];
	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("0") && !click[0]) {
			int turn = model.getPawn();
			click[0] = true;
			model.setClickedBox(0);
			view.setPawn(turn, 0);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("1") && !click[1]) {
			int turn = model.getPawn();
			click[1] = true;
			model.setClickedBox(1);
			view.setPawn(turn, 1);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("2") && !click[2]) {
			int turn = model.getPawn();
			click[2] = true;
			model.setClickedBox(2);
			view.setPawn(turn, 2);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("3") && !click[3]) {
			int turn = model.getPawn();
			click[3] = true;
			model.setClickedBox(3);
			view.setPawn(turn, 3);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("4") && !click[4]) {
			int turn = model.getPawn();
			click[4] = true;
			model.setClickedBox(4);
			view.setPawn(turn, 4);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("5") && !click[5]) {
			int turn = model.getPawn();
			click[5] = true;
			model.setClickedBox(5);
			view.setPawn(turn, 5);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("6") && !click[6]) {
			int turn = model.getPawn();
			click[6] = true;
			model.setClickedBox(6);
			view.setPawn(turn, 6);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("7") && !click[7]) {
			int turn = model.getPawn();
			click[7] = true;
			model.setClickedBox(7);
			view.setPawn(turn, 7);
			checkGameState(turn);
		} else if(e.getActionCommand().equals("8") && !click[8]) {
			int turn = model.getPawn();
			click[8] = true;
			model.setClickedBox(8);
			view.setPawn(turn, 8);
			checkGameState(turn);
		}
	}
	
	private void checkGameState(int turn) {
		if(model.getClickedBox()[0] && model.getClickedBox()[1] && model.getClickedBox()[2]
		|| model.getClickedBox()[3] && model.getClickedBox()[4] && model.getClickedBox()[5]
		|| model.getClickedBox()[6] && model.getClickedBox()[7] && model.getClickedBox()[8]
		|| model.getClickedBox()[0] && model.getClickedBox()[4] && model.getClickedBox()[8]
		|| model.getClickedBox()[2] && model.getClickedBox()[4] && model.getClickedBox()[6]
		|| model.getClickedBox()[0] && model.getClickedBox()[3] && model.getClickedBox()[6]
		|| model.getClickedBox()[1] && model.getClickedBox()[4] && model.getClickedBox()[7]
		|| model.getClickedBox()[2] && model.getClickedBox()[5] && model.getClickedBox()[8]) {
			if(turn % 2 == 0) {
				view.setScore(turn);
				view.showJOptionPane("O");
				click = model.resetClick();
				view.clearBoard();
			}
			else {
				view.setScore(turn);
				view.showJOptionPane("X");
				click = model.resetClick();
				view.clearBoard();
			}
		} else if(allClicked()) {
			view.showJOptionPane("Draw");
			click = model.resetClick();
			view.clearBoard();
		}
			
	}

	private boolean allClicked() {
		if(click[0] && click[1] && click[2] && click[3] && click[4] && click[5] && click[6] && click[7] && click[8])
			return true;
		return false;
	}

	public void setView(View view) {
		this.view = view;
	}
}
