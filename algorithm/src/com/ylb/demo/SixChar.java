package com.ylb.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个4位字符串超过20w的不重复变量
 */
public class SixChar {
    public static void main(String[] args) {
        //实现一个从00-99的随机数


        //实现一个4位字符串超过20w的不重复变量
        char str[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','L'};
//        List<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        char one = str[0];
        char two = str[0];
        char three = str[0];
        char four = str[0];
        for(int i=0; i<200000; i++){
            if('L' == four){
                for(int j=0;j<str.length;j++){
                    if(three == str[j] && j<21){
                        three = str[j+1];
                        four = str[0];
                        if('L' == three){
                            for(int m=0;m<str.length;m++){
                               if(two == str[m] && m<21){
                                   two = str[m+1];
                                   three = str[0];
                                   if('L' == two){
                                       for(int n=0;n<str.length;n++){
                                           if(one == str[n]  && n<21){
                                               one = str[n+1];
                                               two = str[0];
                                           }
                                       }
                                   }else{
                                       break;
                                   }
                               }
                            }
                        }else{
                            break;
                        }
                    }
                }

            }
            four = str[i%str.length];
            sb.append(one).append(two).append(three).append(four);
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }

//        list.add(sb.toString());
    }


}
