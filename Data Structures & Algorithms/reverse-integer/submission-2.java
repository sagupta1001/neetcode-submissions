class Solution {
    // Problem:
    // reverse a signed 32 bit integer x
    // 4 bytes
    // output should be an integer within 
    // the range [intger.min, integer.max]

    // Approach:
    // Keep a decimal counter
    // counter = 1
    // output = 0
    // 1234 / 10 = 123
    // 1234 % 10 = 4
    // output += 1 * counter 
    // counter *= 10
    // 1234 % 1000 = 234
    // 234 / 100 = 2
    // 234 % 100 = 34
    // output += 2 * counter
    // if output is overflowing then return 0 (TODO need to figure this out)
    // counter *= 10
    // 34 / 10 = 3
    // 34 % 10 = 4
    // 4 / 1 = 4
    // 4 % 1 = 0

    // when the mod operator returns zero
    // we are done

    // Pseudo code:
    // isNegative = x < 0
    // absX = abs (x)
    // counter = 1
    // divisor = 1
    // output = 0

    // determine the initial divisor
    // while absX / divisor != 1
    // - divisor *= 10
     


    // do 
    //  quotient = x / divisor 
    //  remainder = x % divisor
    //  output += remainder * counter
    //  counter *= 10
    //  overflow check (TODO)
    // while (remainder != 0)

    // return output and check isNegative

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // overflow check before multiplying by 10
            if (result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
               (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }
}
