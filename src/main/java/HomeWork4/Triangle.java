package HomeWork4;

import java.util.Scanner;

public  class Triangle {

    private static double area;
    private static int s;

    public static double triangleType(int a, int b, int c) {
        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            return viewResult();
        }
        if (((a + b) < c) || ((a + c) < b) || ((b + c) < a)) {
            return viewResult();
        }
        return getArea(a, b, c);
    }

    public static double getArea(int a, int b, int c) {
        s = (a + b + c) / 2;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static double viewResult() {
        return 0;
    }

    static class main {
        public static void main(String[] args) {
          Triangle triangle = new Triangle();
            Scanner sc = new Scanner(System.in);

            System.out.println("Сторона a=");
            int a = sc.nextInt();

            System.out.println("Сторона b=");
            int b = sc.nextInt();

            System.out.println("Сторона c=");
            int c = sc.nextInt();

            System.out.println(triangle.triangleType(a,b,c));

        }
    }
}












