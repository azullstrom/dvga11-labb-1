
public class Model {
	
	private int turn;
	private boolean[] clickedBoxO, clickedBoxX, resetBox;
	
	public Model() {
		turn = 0;
		clickedBoxO = new boolean[9];
		clickedBoxX = new boolean[9];
	}

	public int getPawn() {
		if(turn % 2 == 0) {
			turn++;
			return 0;
		} else {
			turn++;
			return 1;
		}	
	}

	public void setClickedBox(int i) {
		if(turn % 2 == 0) {
			clickedBoxO[i] = true;
		}
		else {
			clickedBoxX[i] = true;
		}
	}
	
	public boolean[] getClickedBox() {
		if(turn % 2 == 0)
			return clickedBoxO;
		else
			return clickedBoxX;
	}

	public boolean[] resetClick() {
		resetBox = new boolean[9];
		clickedBoxO = new boolean[9];
		clickedBoxX = new boolean[9];
		return resetBox;
	}
}
