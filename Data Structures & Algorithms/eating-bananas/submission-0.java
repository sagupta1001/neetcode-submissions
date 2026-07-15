class Solution {

    // Problem:
    // piles at i is the number of bananas in the ith pile
    // h is the number of hours we have to eat all bananas

    // determine k which is the rate of eating bananas
    // per hour.
    // return the min K

    // approach:
    // try K as the mid of array
    // and then increment or decrement (binary search)
    // based on whether it requires more or less than h hours

    // pseudo code
    // eating rate is from 1 to max of the piles
    // find the mid eating rate to begin with
    // binary search on eating rate / number of hours is less than equal to H
    //   for each eating rate we set find the number of hours to finish
    //   keep track of min eating rate
    //   adjust eating rate based on if hours was less than H
    //   adjust end to be mid
    //   if hours greater than H
    //   adjust start to be mid

    // return min eating rate

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int eatingRate = (left + right) / 2;

            int currTime = 0;
            for (int i = 0; i < piles.length; i++) {
                currTime += (int)Math.ceil((double)piles[i] / eatingRate);
            }

            if (currTime <= h) {
                result = eatingRate;
                right = eatingRate - 1;
            } else {
                left = eatingRate + 1;
            }
        }

        return result;
    }
}
