package com.cap.bean;

import java.util.Arrays;

public class Solution {

	public static int ALLOWED_WEEK_DAYS = 7;
	public static int CHARGE_PER_DAY = 2;
	public static int CHARGE_PER_WEEK = 7;
	public static int CHARGE_PER_MONTH = 25;

	/*public static void main(String[] args) {
		int[] A = new int[11];
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		A[4] = 5;
		A[5] = 6;
		A[6] = 7;
		A[7] = 8;
		A[8] = 9;
		A[9] = 10;
		A[10] = 11;
		A[11] = 12;
		A[12] = 13;
		A[13] = 14;
		A[14] = 15;
		A[15] = 16;
		A[16] = 17;
		A[17] = 18;
		A[18] = 19;
		A[19] = 20;
		A[20] = 21;
		A[21] = 22;
		A[22] = 23;
		A[23] = 24;
		A[24] = 25;
		A[25] = 26;
		A[26] = 27;
		A[27] = 29;
		A[28] = 30;
		Solution solution = new Solution();
		System.out.println(solution.solution(A));
	}*/

	public static void main(String[] args) {
		int[] A = new int[29];
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		A[4] = 5;
		A[5] = 6;
		A[6] = 7;
		A[7] = 8;
		A[8] = 9;
		A[9] = 10;
		A[10] = 11;
		A[11] = 12;
		A[12] = 13;
		A[13] = 14;
		A[14] = 15;
		A[15] = 16;
		A[16] = 17;
		A[17] = 18;
		A[18] = 19;
		A[19] = 20;
		A[20] = 21;
		A[21] = 22;
		A[22] = 23;
		A[23] = 24;
		A[24] = 25;
		A[25] = 26;
		A[26] = 27;
		A[27] = 29;
		A[28] = 30;
		Solution solution = new Solution();
		System.out.println(solution.solution(A));
	}
	
	public int solution(int[] A) {

		int totalCharges = 0;

		// Step 0: Assumption as per task description, A is an sorted, unique list and only 1 - 30 values are participating without null or zero values..

		// Step 1: Validate and localize the list
		if (A.length < 1)
			return totalCharges;

		// Step 2: find if it has 29th and 30th day and charge as per day
		// ticket.
		final Integer noOfPerDayTicket = (Arrays.stream(A)
				.filter(n -> (n == 29 || n == 30)).toArray().length);
		totalCharges = CHARGE_PER_DAY * noOfPerDayTicket;

		// Step 3: find and charge as per week ticket.
		final Integer noOfPerWeekTicket = ((int) Math
				.ceil((double) (A.length - noOfPerDayTicket.intValue())
						/ ALLOWED_WEEK_DAYS));
		totalCharges = totalCharges + (noOfPerWeekTicket * CHARGE_PER_WEEK);

		// Step 4: Check if charges is more than 25 than issue month ticket.
		if (totalCharges >= 25)
			totalCharges = 1 * CHARGE_PER_MONTH;

		return totalCharges;
	}
}
