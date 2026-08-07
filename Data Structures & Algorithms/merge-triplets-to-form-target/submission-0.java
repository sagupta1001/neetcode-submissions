class Solution {
    // problem
    // obtain the target triplet

    // approach
    // we consider two triplets at a time
    // apply the operation and see what the result is

    // if the target is reached, then return true
    // if the target is not reached, then we have two
    // options to keep that in place as triplet[j] and
    // not to

    // taking a step back at any given index i, we have 
    // two options to apply the operation with index j or not
    // j would be looped from i+1 to N
    // this is a recursive algorithm with backtracking
    // where after the recursive returns we undo the operation
    // and bring the array back to the state it was before

    // max is associative and cumulative 
    // order of triplets does not matter

    // first we will filter out the triplets that cannot be used
    // then we loop through the ones that can be used, and see if any
    // has the 1,2 and 3rd index matching the triplet
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean hasOne = false;
        boolean hasTwo = false;
        boolean hasThree = false;
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] ||
                triplets[i][2] > target[2]) {
                    continue;
                }
            if (triplets[i][0] == target[0]) {
                hasOne = true;
            }
            if (triplets[i][1] == target[1]) {
                hasTwo = true;
            }
            if (triplets[i][2] == target[2]) {
                hasThree = true;
            }
        }
        return hasOne && hasTwo && hasThree;
    }
}
