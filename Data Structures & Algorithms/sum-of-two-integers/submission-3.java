class Solution {
    // problem
    // return sum of two integers without using + or -

    // examples
    // 1, 1 -> 2

    // approach
    // binary?
    // 4 = 100
    // 7 = 111
    // 11 = 1011
    // binary operators, and does not work
    // xor with carry seems to work
    // 

    // algorithm
    // initial carry 0
    // Loop right to left traversal
    // how to get the Rightmost bit
    // -> function call
    // xor RB and carry
    // -> if result is 1 then continue
    // -> if result is 0 then carry 1
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {

            // Get the rightmost bit from each number
            int aBit = a & 1;
            int bBit = b & 1;

            // Sum the two bits and the carry
            int sumBit = aBit ^ bBit ^ carry;

            // Put this bit back in its correct position
            result |= sumBit << i;

            // Carry happens when at least two of the three bits are 1
            carry = (aBit & bBit) | (aBit & carry) | (bBit & carry);

            // Move to the next bit
            a >>= 1;
            b >>= 1;
        }

        return result;
    }
}
