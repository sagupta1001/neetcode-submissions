class Solution {
    // problem
    // count number of 1 bits in the binary 
    // rep of an unsigned integer i.e. >= 0
    
    // approach
    // brute force
    // 0

    // 16
    // 1000

    // 31
    // 01111

    // 5
    // 101

    // XOR 
    // 1 XOR 0 = 1
    // AND
    // 1 AND 1 = 1
    // otherwise 0

    // loop through the bits
    // AND the SB at a time
    // keep track of the count

    // while n != 0
    // count += (n>>1) && 1
    // 


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
