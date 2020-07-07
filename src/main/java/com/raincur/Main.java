package com.raincur;

import com.raincur.exception.UserNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int x = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String[] para = str.split(" ");
            System.out.println(x + " " + str);
            boolean res = false;
            switch (x){
                case 1:
                    System.out.println("创建用户, id为:" + para[0] + ", 名字为: " + para[1]);
//                    res = UserManager.createUser(para[0], para[1]);
                    break;
                case 2:
//                    res = UserManager.deleteUser(para[0]);
                    break;
                case 3:
//                    res = Operator.copyNbToUser(para[0], para[1]);
                    break;
                case 4:
//                     res = Operator.deleteNb(para[0]);
                default:
                    break;
            }
            if (res)
                System.out.println("成功");
            else System.out.println("失败");
        }
    }
}
