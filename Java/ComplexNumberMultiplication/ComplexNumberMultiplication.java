/**
 * (6ms)
 * Created by Phoenix-Z on 2017/4/14.
 */
public class ComplexNumberMultiplication {

    public static String complexNumberMultiply(String a, String b) {
        int indexOfPlusInA = a.indexOf("+");
        int indexOfPlusInB = b.indexOf("+");
        int realA = Integer.parseInt(a.substring(0, indexOfPlusInA));
        int virtualA = Integer.parseInt(a.substring(indexOfPlusInA + 1, a.length() - 1));
        //System.out.println("real: " + realA + " virtual: " + virtualA);
        int realB = Integer.parseInt(b.substring(0, indexOfPlusInB));
        int virtualB = Integer.parseInt(b.substring(indexOfPlusInB + 1, b.length() - 1));
        //System.out.println("real: " + realB + " virtual: " + virtualB);
        int real = realA * realB - virtualA * virtualB;
        int virtual = realA * virtualB + realB * virtualA;
        return real + "+" + virtual + "i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
