package java_core_hw_1_1;

public class Main {
    public static void main(String[] args) {
        //Змінні та їх властивості
        byte b = 44; // -127 to 127; 1 байт
        short s =  10000; // -32768 to 32767; 2 байти
        int i = 40500; // -2147483648 to 2147483647; 4 байти
        long l = 9500500500L; //Обов'язково вказувати в кінці L; Дуже великі числа:)-9*1018 .. 9*1018(: 8 байт
        float f = 3.5f; //Обов'язково вказувати в кінці f; -1038 .. 1038; 4 байти
        double d = 49.506; //-10308 .. 10308; 8 байт
        boolean boo = false; //По замовченню завжди false
        char c = 'C'; //Зберігає лише один символ або кодировку ASCII; одинарні лапки
        String st = "Some lines with some numbers"; // Подвійні лапки

        //Перевизначемо деякі змінні шляхом внесення нового значення 0; null бажано зайвий раз не використовувати
        b = 0;
        s = 0;
        i = 0;
        l = 0;
        System.out.println(st + ":\n" + b +"\n" + s + "\n" + i + "\n" + l );
        //Змінемо значення певних змінних
        b = 35;
        s = 27;
        i = 40;
        l = 70;
        //Виконаємо математичні операції та приведення даних
        b = (byte) (l - b + 2);
        s = (short) (b + s);
        i = (int)b + (int)s;
        l = b + s + i / 2;
        System.out.println(st + ":\n" + b +"\n" + s + "\n" + i + "\n" + l );

        //Пограємо в null зі змінними
        //int integer = null; Так не гуд. Ми не можемо призначати null примітивним змінним
        Integer itr = null; // А так вже ок
        Double dbl = null; // Так також ок
        String str = null; // Ніякого криміналу

        String myStr = (String) null; // Так також ок
        Integer myItr = (Integer) null; // І так ок
        Double myDbl = (Double) null; // І так

        //Поки що ми не отримали NullPointerException, але...
        //i = integer; //Ніякого криміналу, але IDE нас попереджає тож можемо перевірити, якщо приберемо коментар
        //Чи можно порівняти null?
        if(itr == myItr) {
            System.out.println("This is true!");
        }
        //null це дуже цікаво
    }



}