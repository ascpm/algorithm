public class Sopoong {
	public int n;
	public boolean[][] friends;

	public Sopoong() {
		this.n = 6;
		this.friends = new boolean[this.n][];

		for (int i = 0; i < this.n; i++) {
			this.friends[i] = new boolean[this.n];

			for (int j = 0; j < this.friends.length; j++) {
				this.friends[i][j] = false;
			}
		}

		this.friends[0][1] = true;
		this.friends[1][0] = true;

		this.friends[0][2] = true;
		this.friends[2][0] = true;

		this.friends[1][2] = true;
		this.friends[2][1] = true;

		this.friends[1][3] = true;
		this.friends[3][1] = true;

		this.friends[1][4] = true;
		this.friends[4][1] = true;

		this.friends[2][3] = true;
		this.friends[3][2] = true;

		this.friends[2][4] = true;
		this.friends[4][2] = true;

		this.friends[3][4] = true;
		this.friends[4][3] = true;

		this.friends[3][5] = true;
		this.friends[5][3] = true;

		this.friends[4][5] = true;
		this.friends[5][4] = true;
	}

	public static void main(String[] args) {
		Sopoong sp = new Sopoong();
		boolean[] status = new boolean[sp.n];
		
		for (int i = 0; i < status.length; i++) {
			status[i] = false;
		}
		
		System.out.println("pair count is : " + sp.pairCount(status));
	}

	private int pairCount(boolean[] status) {
		int startIdx = -1;

		for (int i = 0; i < status.length; i++) {
			if (!status[i]) {
				startIdx = i;
				break;
			}
		}

		if (startIdx < 0) {
			return 1;
		} else {
			int count = 0;

			for (int i = startIdx + 1; i < status.length; i++) {
				if (!status[i] && friends[startIdx][i]) {
					status[startIdx] = true;
					status[i] = true;
					count += this.pairCount(status);
					status[startIdx] = false;
					status[i] = false;
				}
			}

			return count;
		}
	}
}
