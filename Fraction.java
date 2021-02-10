public class Fraction {
    private int num, denom;

    // CONSTRUCTOR

    Fraction() { //default
        num = 1;
        denom = 1;
    }

    Fraction(int n, int d) {
        num = n;
        if (d == 0) {
            System.out.println("ERROR: denominator cannot be 0");
            denom = 1;
            return;
        }
        denom = d;
    }

    Fraction(String fr) {
        int i = fr.indexOf("/");

        num = Integer.parseInt(fr.substring(0,i));
        denom = Integer.parseInt(fr.substring(i+1));
        if (denom == 0) {
            denom = 1;
            System.out.println("ERROR: denominator cannot be 0");
        }
    }

    Fraction(Fraction fr) { //copy
        this.num = fr.num;
        this.denom = fr.denom;
    }

    // ACCESSOR

    public int getNum() {
        return this.num;
    }

    public int getDenom() {
        return this.denom;
    }

    public String toString() {
        return (""+this.num+"/"+this.denom);
    }
    public double toDouble(){
        return (double)this.getNum()/this.getDenom();
    }

    // MUTATOR

    public void reduce() {
        int GCF = findGCF(num,denom);
        this.num = num/GCF;
        this.denom = denom/GCF;
    }



    public void setNum(int n) {
        this.num = n;
    }

    public void setDenom(int d) {
        if (d != 0) this.denom = d;
        else this.denom = 1;
    }

//    public void multiply(Fraction fr) {
//        this.num = this.num*fr.num;
//        this.denom = this.denom*fr.denom;
//        this.reduce();
//    }

    // STATIC
    // not acting on object; "tools" that can use them
    // cannot use "this" because it is not about an obj

    public static Fraction multiply(Fraction fr1, Fraction fr2) {
        int n = fr1.num*fr2.num;
        int d = fr1.denom*fr2.denom;

        Fraction temp = new Fraction(n,d);
        //i cant reduce here because i need to use it for divide()
        return temp;
    }

    public static Fraction divide(Fraction fr1, Fraction fr2) {
        if (fr2.num == 0) {
            System.out.println("Error: invalid numerator");
            return new Fraction();
        }

        int n = fr1.num*fr2.denom;
        int d = fr1.denom*fr2.num;

        Fraction temp = new Fraction(n,d);
        temp.reduce();

        return temp;
    }

    public static Fraction add(Fraction fr1, Fraction fr2) {
        int temp = fr1.denom;
        fr1 = multiply(fr1, new Fraction(fr2.denom, fr2.denom));
        fr2 = multiply(fr2, new Fraction(temp, temp));

        int n = fr1.num+fr2.num;

        Fraction fr = new Fraction(n,fr1.denom);
        fr.reduce();
        return fr;
    }

    public static Fraction subtract(Fraction fr1, Fraction fr2) {
        int temp = fr1.denom;
        fr1 = multiply(fr1, new Fraction(fr2.denom, fr2.denom));
        fr2 = multiply(fr2, new Fraction(temp, temp));

        int n = fr1.num-fr2.num;

        Fraction fr = new Fraction(n,fr1.denom);
        fr.reduce();
        return fr;
    }

    // HELPER

    public static int findGCF(int num1, int num2) {
        int a = Math.abs(num1);
        int b = Math.abs(num2);
        if ( a == 0 || b == 0) return 1;

        while (a != b) {
            if (a > b) {
                a -= b;
            } else
                b -= a;
        }
        return a;
    }

}
