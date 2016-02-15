public class Sopoong {
	private int studentCount = 6;
	private boolean[][] friends = { { false, true, true, false, false, false },
			{ false, false, true, true, true, false },
			{ false, false, false, true, true, false },
			{ false, false, false, false, true, true },
			{ false, false, false, false, false, true },
			{ false, false, false, false, false, false } };

	public static void main(String[] args) {
		boolean[] pairStatus = { false, false, false, false, false, false };
		Sopoong sp = new Sopoong();
		System.out.println("pair count is : " + sp.pairCount(pairStatus));
	}

	private int pairCount(boolean[] statusArray) {
		int startNum = -1;
		
		for (int i = 0; i < statusArray.length; i++) {
			if (!statusArray[i]) {
				startNum = i;
				break;
			}
		}
		
		int count = 0;
		
		if (startNum > 0) {
			for (int i = startNum; i < statusArray.length - 1; i++) {
				if (!statusArray[i + 1] && friends[i][i + 1]) {
					statusArray[i] = true;
					statusArray[i + 1] = true;
					count += this.pairCount(statusArray);
					statusArray[i] = false;
					statusArray[i + 1] = false;
				}
			}
		} else {
			return 1;
		}
		
		return count;
	}
}
