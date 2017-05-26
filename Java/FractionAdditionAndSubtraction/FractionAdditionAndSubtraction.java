import java.util.Arrays;

/**
 * (19ms)
 * Created by Phoenix-Z on 2017/5/26.
 */
public class FractionAdditionAndSubtraction {

    static class Fraction {
        int son, mum;

        public Fraction(String fraction) {
            String[] nums = fraction.split("/");
            son = Integer.parseInt(nums[0]);
            mum = Integer.parseInt(nums[1]);
        }

        public void add(Fraction another) {
            int lcm = getLcm(this.mum, another.mum);
            this.son *= lcm / this.mum;
            this.mum = lcm;
            another.son *= lcm / another.mum;
            this.son += another.son;
        }

        public void sub(Fraction another) {
            int lcm = getLcm(this.mum, another.mum);
            this.son *= lcm / this.mum;
            this.mum = lcm;
            another.son *= lcm / another.mum;
            this.son -= another.son;
        }

        public void reduceRedundent() {
            int gcd = getGcd(Math.abs(son), mum);
            if(gcd == 0) {
                son = 0;
                mum = 1;
            } else {
                son /= gcd;
                mum /= gcd;
            }
        }
        public String toString(){
            reduceRedundent();
            return son + "/" + mum;
        }
    }

    public String fractionAddition(String expression) {
        String[] nums = expression.split("[+-]");
        Fraction[] fractions = new Fraction[nums.length];
        if(expression.charAt(0) == '-') {
            nums = Arrays.copyOfRange(nums, 1, nums.length);
            nums[0] = "-" + nums[0];
        }
        for(int i = 0; i < nums.length; i++) {
            fractions[i] = new Fraction(nums[i]);
        }
        Fraction ans = fractions[0];
        int j = 1;
        for(int i = 1; i < expression.length(); i++) {
            if(j >= fractions.length)
                break;
            if(expression.charAt(i) == '+') {
                ans.add(fractions[j++]);
            } else if(expression.charAt(i) == '-') {
                ans.sub(fractions[j++]);
            }
        }
        return ans.toString();
    }

    public static int getGcd(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b == 0 || a % b == 0)
            return b;
        return getGcd(b, a % b);
    }

    public static int getLcm(int a, int b) {
        return a / getGcd(a, b) * b;
    }

    public static void main(String[] args) {
        FractionAdditionAndSubtraction test = new FractionAdditionAndSubtraction();
        System.out.println(test.fractionAddition("-1/2+1/6+1/3"));
    }
}
