package DSA.Arrays;

import java.util.Scanner;

public class Arr {
    public static void update(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        // Creation of arrays
        // int marks[] = new int[50];
        int numbers[] = {1, 5, 6};
        String fruits[] = {"apple", "mango", "orange"};

        /* marks[0] = scn.nextInt(); //phy
        marks[1] = scn.nextInt(); //che
        marks[2] = scn.nextInt(); //math

        System.out.println(marks.length);

        System.out.println("phy : " + marks[0]);
        System.out.println("chem : " + marks[1]);
        System.out.println("math : " + marks[2]);

        marks[2] = 100;
        System.out.println("math : " + marks[2]);

        // marks percentage
        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("percentage = " + percentage + "%"); */

        int marks[] = {97, 98, 99};
        update(marks);

        for(int i=0; i<marks.length; i++){
            System.out.println(marks[i]);
        }


    }
}
