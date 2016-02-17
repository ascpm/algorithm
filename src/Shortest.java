import java.util.Stack;

public class Shortest {
	public int[][] length = {
			{0, 10, 8, 11},
			{10, 0, 5, 11},
			{5, 5, 0, 5},
			{11, 5, 11, 0}			
	};	
	public boolean[] checked = {false, false, false, false};
	public int n = 4;
	
	public static void main(String[] args) {		
		Shortest st = new Shortest();
		Stack<Integer> path = new Stack<Integer>();
		path.push(0);
		st.checked[0] = true;
		System.out.println("result is : " + st.shortest(path, 0));
	}
	
	public int shortest(Stack<Integer> path, int pathLength) {
		if (path.size() == n) {
			return pathLength + length[0][path.get(n - 1)];
		} else {
			int shortestLength = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				if (!checked[i]) {
					int prePath = path.peek();
					path.push(i);
					checked[i] = true;
					int lengthVal = this.shortest(path, pathLength + length[prePath][i]);
					
					if (shortestLength > lengthVal) {
						shortestLength = lengthVal;
					}
					
					path.pop();
					checked[i] = false;
				}
			}
			
			return shortestLength;
		}
	}
}
