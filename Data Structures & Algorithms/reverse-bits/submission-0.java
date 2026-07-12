class Solution {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            if (binary.charAt(i) == '1') {
                result |= (1 << (31 - i));
            }
        }

        return result;
    }
}
