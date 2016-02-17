public class Game {
	private boolean[][] block = { 
		{ true, false, false, false, false, false, true },
		{ true, false, false, false, false, false, true },
		{ true, true, false, false, true, true, true }, 
	};
	
	private int[] my = {0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1};
	private int[] mx = {0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, -1};	
	private int mn = 3;
	
	private int n = 4;

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("result is : " + game.check());
	}
	
	public int check() {
		int yIdx = -1;
		int xIdx = -1;
		
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i].length; j++) {
				if (!block[i][j]) {
					yIdx = i;
					xIdx = j;
					break;
				}
			}
			
			if (yIdx >= 0) {
				break;
			}
		}
		
		if (yIdx < 0) {
			return 1;
		} else {
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				if (!this.isBlocked(yIdx,xIdx, i)) {
					this.marking(yIdx, xIdx, i, true);
					count += this.check();
					this.marking(yIdx, xIdx, i, false);
				}
			}
			
			return count;
		}
	}
	
	private void marking(int by, int bx, int bn, boolean tag) {
		int idx = (bn + 1) * mn - mn;
		
		for (int i = 0; i < mn; i++) {
			int bmy = by + my[idx + i];
			int bmx = bx + mx[idx + i];
			
			block[bmy][bmx] = tag;
		}
	}
	
	private boolean isBlocked(int by, int bx, int bn) {
		int idx = (bn + 1) * mn - mn;
		
		for (int i = 0; i < mn; i++) {
			int bmy = by + my[idx + i];
			int bmx = bx + mx[idx + i];
			
			if (bmy >= 0 && bmy < block.length &&
					bmx >= 0 && bmx < block[0].length) {
				if (block[bmy][bmx]) {
					return true;
				}
			} else {
				return true;
			}
		}
		
		return false;
	}	
}
