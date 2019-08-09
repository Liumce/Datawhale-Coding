package task2;

import java.util.Scanner;

/**
 * Created by liumao 2019/8/9 0009
 **/
public class doFactorial {
    public static void main(String[] args) {
        int num = 0;
        int result = 1;
        System.out.println("输入一个数字");
        Scanner scan = new Scanner(System.in);
        if(scan.hasNext())
        {
            String str1 = scan.next();
            try {
                num = Integer.parseInt(str1);
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是数字!");
                e.printStackTrace();
            }
            for (int j = 1; j <= num; j++) {
                result = result * j;
            }
            System.out.println(num + "的阶乘为" + result);
        }
        scan.close();
    }
}
