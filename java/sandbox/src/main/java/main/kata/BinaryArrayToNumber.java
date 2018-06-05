package main.kata;

import java.util.List;

class BinaryArrayToNumber {

    static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int ans = 0;
        for (int i = 0; i < binary.size(); i++) {
            ans += Math.pow(2, (binary.size()-1) - i) * binary.get(i);
        }
        return ans;
    }
}
