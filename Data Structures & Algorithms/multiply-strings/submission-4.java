class Solution {
    // problem
    // multiply two integer strings
    // return the product as a string

    // approach
    // convert each character to a digit
    // ascii conversion?

    // so then i have part of a large string lets say 12 and 
    // 5 12 5 -- 60 multiply the rightmost digits, 
    // take the carry and add it to the next digit result

    // two nested loops
    // outer loop for the larger string
    // initial carry is zero
    // sum is zero (string builder)
    // inner loop for the smaller string or equal string
    // start from the right most characters, 
    // convert to digit in integer
    // multiply the two and add any carry from last iteration
    // keep track of carry
    // inner loop will increment 
    // sum keeps getting appended
    // 
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            Integer digit1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                Integer digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;

                int posRight = i + j + 1;
                int posLeft = i + j;

                int sum = product + result[posRight];

                result[posRight] = sum % 10;
                result[posLeft] += sum / 10;
            } 
        }
        StringBuilder sb = new StringBuilder();

        for (int num : result) {
            if (num == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(num);

        }

        return sb.toString();
    }
}
