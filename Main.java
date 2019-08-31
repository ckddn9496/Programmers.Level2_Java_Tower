import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};	//	[0,0,2,2,4]
//		int[] heights = {3,9,9,3,5,7,2};	//	[0,0,0,3,3,3,6]
//		int[] heights = {1,5,3,6,7,6,5};	//	[0,0,2,0,0,5,6]
		System.out.println(Arrays.toString(new Solution().solution(heights)));
	}

}
class Solution {
    public int[] solution(int[] heights) {
        Stack<Tower> s = new Stack<>();
    	int[] answer = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
        	if (s.isEmpty())
        		s.add(new Tower(heights[i], i));
        	else {
        		while (!s.isEmpty()) {
        			if (heights[i] > s.peek().getHeight()) {
        				answer[s.pop().getLocation()] = i+1;
        			} else break;
        		}
        		s.push(new Tower(heights[i], i));
        	}
        }
        while (!s.isEmpty()) {
        	answer[s.pop().getLocation()] = 0;
        }
        return answer;
    }
}
class Tower {
	private int height;
	private int location;
	public Tower(int height, int location) {
		this.height = height;
		this.location = location;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public int getHeight() {
		return this.height;
	}
}