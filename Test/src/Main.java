public class Main {
    public static void main(String[] args) {
        //1
        /*long l = (byte) 1234_564_890L;
        int x = (byte) 0b1000_1100_1010;
        double m = (byte) 110_987_654_6299.123_34;
        float f = l + 10 + x - (float) m;
        l = 1234567L;
        System.out.println(l);*/

        //3
        /*int i = 1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                System.out.print(i * j + " ");
                j++;
            }
            System.out.println();
            i++;*/

        //4
        Cat cat1 = new Cat();
        cat1.age = 2;
        cat1.weight = 4;
        cat1.strength = 5;

        Cat cat2 = new Cat();
        cat2.age = 3;
        cat2.weight = 3;
        cat2.strength = 6;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }
}