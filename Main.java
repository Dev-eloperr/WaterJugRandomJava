package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int minSteps = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList= new ArrayList<>();
        int j=0;
        while (j<10000) {
            rules rules = new rules();
            if (rules.step < minSteps){
                minSteps = rules.step;
                arrayList.clear();
                arrayList.addAll(rules.arrayList);
            }
            j++;
        }
        System.out.println(minSteps);
        System.out.println(arrayList);
    }

}
class rules{
    private int x=0,y=0;
    int step = 0;
    ArrayList<Integer>  arrayList= new ArrayList<>() ;
    rules(){
        int i;
        while (!((x==2))) {
            i=(int) (Math.random()*9);
            //System.out.println(i+1);
            switch (i + 1) {
                case 1: r1();
                    break;
                case 2: r2();
                    break;
                case 3: r3();
                    break;
                case 4: r4();
                    break;
                case 5: r5();
                    break;
                case 6: r6();
                    break;
                case 7: r7();
                    break;
                case 8: r8();
                    break;
                case 9: r9();
                    break;
            }
        }
        //System.out.println("Total Steps: "+step);
    }
    private void r1(){
        //Fill 4 gallon jug
        if(x<4) {
            x = 4;
            //System.out.println("1");
            arrayList.add(1);
            step++;
        }
    }
    private void r2(){
        //Fill 3 gallon jug
        if (y<3) {
            y = 3;
            //System.out.println("2");
            arrayList.add(2);
            step++;
        }
    }
    private void r3(){
        //Empty 3 gallon jug
        if (y>0) {
            y = 0;
            //System.out.println("3");
            arrayList.add(3);
            step++;
        }
    }
    private void r4(){
        //empty 4 gallon jug
        if (x>0) {
            x = 0;
            //System.out.println("4");
            arrayList.add(4);
            step++;
        }
    }
    private void r5(){
        //pour water from 3 gallon jug into 4 galllon jug
        //until 4 gallon jug is full
        if ((x+y >= 4) && (y>0) ){
            y = y-(4-x);
            x=4;
            //System.out.println("5");
            arrayList.add(5);
            step++;
        }
    }
    private void r6(){
        //pour water from 4 gallon jug into 3 gallon jug
        //until 3 gallon jug is full
        if((x+y>=3) && (x>0) ){
            x=x - (3-y);
            y=3;
            //System.out.println("6");
            arrayList.add(6);
            step++;
        }
    }
    private void r7(){
        //pour all water from 3 gallon jug into 4 gallon jug
        if((x+y<=4)&&(y>0)){
            x=x+y;
            y=0;
            //System.out.println("7");
            arrayList.add(7);
            step++;
        }
    }
    private void r8(){
        //pour all water from 4 gallon jug into 3 gallon jug
        if ((x+y<=3) && (x>0)){
            x=0;
            y=x+y;
            //System.out.println("8");
            arrayList.add(8);
            step++;
        }
    }
    private void r9(){
        //pour 2 gallon water from 3 gallon jug into 4 gallon jug
        if (x==0 && y==2){
            x=2;
            y=0;
            //System.out.println("9");
            arrayList.add(9);
            step++;
        }
    }

}