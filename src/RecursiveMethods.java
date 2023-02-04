/**
 * Program 6
 *  This program creates three recursive methods that utilize one or more base cases and recursive calls to itself to find
 *  the combinations of leaps and bounds from the input of spaces, the number of times a substring is present in a larger string,
 *  and a binary search of an array of numbers given a target number.
 *  4/15/22
 *  @author  Cameron Cobb
 * 
 */
public class RecursiveMethods {
	public static void main(String[] args) {
		RecursiveMethods p6 = new RecursiveMethods();
	
		int partI = p6.byLeapsAndBounds(3);
        System.out.println("Part I answer: " + partI); //should print Part I answer: 3

        int partII = p6.subCount("aaaa","a");
        System.out.println("Part II answer: " + partII); //should print Part II answer: 4

        int[]sampleArr = {1,2,3,5,6,8,13};
        int partIII = p6.binarySearch(sampleArr,3,0,sampleArr.length-1); 
        System.out.println("Part III answer: " + partIII); //should print Part III answer: 2
	}

	/**
	 * This method calculates the number of combinations of leaps and bounds based on the input, or the number of given spaces. This method utilizes two recursive calls.
	 * The base cases are if the integer parameter n is equal to 2 and equal to 1.
	 * @param n
	 * @return
	 */
	public int byLeapsAndBounds(int n) {
		if (n == 2) {
			return 2;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return byLeapsAndBounds(n - 1) + byLeapsAndBounds(n - 2);
		}
	}
	
	/**
	 * This method finds and returns the number of occurrences of a substring inside a String. The base case returns 0 if the desired substring is not apart of the actual string, else the method increments the num variable and recursively calls itself with a substring of the original string after the index of the occurrence to the end of the String. 
	 * The base case is if the index of substring is not located within the String, then return 0. If (str.indexxOf(subStr) == -1).
	 * @param str
	 * @param subStr
	 * @return
	 */
	public int subCount(String str, String subStr) {
		int num = 0;
		if (str.indexOf(subStr) == -1) {
			return 0;
		}
		else {
			num++;
			return num + subCount(str.substring(str.indexOf(subStr) + 1, str.length()), subStr);
		}

	}
	
	/**
	 * This method determines the index of a target int by recursively calling itself. It uses a left, right, and mid int variable and checks if the midpoint contains the target, else the method is recursively called. If the target is lower than mid, the method is called from left to the mid value, else the method is called from mid val + 1 to the right value.
	 * The base cases are if array[mid] == target and if the range == 1. Range == 1 signifies that the left and right variables are looking at the same index. The first base case returns the mid index while the second base case returns -1, indicating that the target cannot be found.
	 * @param array
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	public int binarySearch(int[] array, int target, int left, int right) {
		if (array.length != 0) {
			int mid = (right + left) / 2;
			int range = (right - left) + 1;
			int position;
			
			if (array[mid] == target) {
				position = mid;
			}
			
			
			else if (range == 1) {
				position = -1; 
			}
			else {
				if (target < array[mid]) {
					position = binarySearch(array, target, left, mid);
				}
				else {
					position = binarySearch(array, target, mid + 1, right);
				}
			}
			return position;
		}
		else {
			return -1;
		}
		
	}
}
