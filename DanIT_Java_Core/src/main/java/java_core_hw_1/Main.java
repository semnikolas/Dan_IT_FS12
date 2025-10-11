package java_core_hw_1;

public class Main {
    public static void main(String[] args) {
        byte bt = 44;
        short sh = 10000;
        int itr = 40500;
        long lg = 9500500500L;
        float fl = 3.5f;
        double db = 49.506;
        boolean boo = false;
        char ch = 'C';
        String str = "Some lines with some numbers";

        bt = 0;
        sh = 0;
        itr = 0;
        lg = 0;

        System.out.println(str + ":\n" + bt + "\n" + sh + "\n" + itr + "\n" + lg);

        bt = 35;
        sh = 27;
        itr = 40;
        lg = 70;

        bt = (byte) (lg - bt + 2);
        sh = (short) (bt + sh);
        itr = (int) bt + (int) sh;
        lg = bt + sh + itr / 2;

        System.out.println(str + ":\n" + bt + "\n" + sh + "\n" + itr + "\n" + lg);

        Integer itrn = null;
        Integer myItr = (Integer) null;

        if (itrn == myItr) {
            System.out.println("This is true!");
        }
    }
}