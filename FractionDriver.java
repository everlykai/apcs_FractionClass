import java.util.ArrayList;
import java.util.Arrays;

public class FractionDriver {
    public static void main(String[] args) {
        ArrayList<Fraction> fr = new ArrayList<>();
        // CHECK CONSTRUCTORS  1,1 | 1,3 | -4,6 | 1,3
        fr.add(new Fraction());
        fr.add(new Fraction(1,3));
        fr.add(new Fraction("-4/6"));
        fr.add(new Fraction(fr.get(1)));
        fr.add(new Fraction(5,0));  // sets denom to 1
        System.out.println(Arrays.deepToString(fr.toArray()));

        // CHECK ACCESSORS  // 1,3 | 1,3 | 0.333...
        System.out.println(fr.get(1).getNum());
        System.out.println(fr.get(1).getDenom());
        System.out.println(fr.get(1).toString());
        System.out.println(fr.get(1).toDouble());

        // CHECK MUTATOR
        fr.get(1).reduce();  // no change
        fr.get(2).reduce();  // -4,6 -> -2,3

        fr.get(0).setNum(5);
        fr.get(0).setDenom(2);  // 1,1 -> 5,2

        // CHECK MATHS
        fr.add(Fraction.multiply(fr.get(0), fr.get(1)));  // 5,2 * 1,3 = 5,6
        fr.add(Fraction.divide(fr.get(0), fr.get(1)));    // 5,2 / 1,3 = 15,2
        fr.add(Fraction.add(fr.get(0), fr.get(1)));       // 5,2 + 1,3 = 17,6
        fr.add(Fraction.subtract(fr.get(0), fr.get(1)));  // 5,2 - 1,3 = 13,6

  //      fr.add(Fraction.divide(new Fraction(1,1), new Fraction(0,1))); // dividing by 0

        System.out.println(Arrays.deepToString(fr.toArray()));
    }
}
