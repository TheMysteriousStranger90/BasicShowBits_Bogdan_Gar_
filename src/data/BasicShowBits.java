package data;

public class BasicShowBits {
    private int num;
    private StringBuffer tmp = new StringBuffer();

    public BasicShowBits(int n) {
        num = n;
    }

    public String show(long val) {
        long mask = 1;

        mask <<= num - 1;

        int spacer = 0;
        for (; mask != 0; mask >>>= 1) {
            if ((val & mask) != 0) {
                tmp.append("1");
            }
            else {
                tmp.append("0");
            }
            spacer++;
            if ((spacer % 8) == 0) {
                tmp.append(" ");
                spacer = 0;
            }
        }
        return String.valueOf(tmp);
    }
}

