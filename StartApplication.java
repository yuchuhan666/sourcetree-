package com.neusoft.demo;

import java.util.Random;
import java.util.Scanner;

public class StartApplication {
	
	public static int[] generateNumber(int len) throws IllegalArgumentException {
		if(len <= 0) {
			throw new IllegalArgumentException("wrong array's length:"+len+", except len > 0");
		}
		int[] ns = new int[len]; 
		Random r = new Random();
		int count = 1;
		ns[0] = r.nextInt(9) + 1;
		while(count < len) {
			int x = r.nextInt(10);
			boolean f = false;
			for(int i = 0; i < count; i++) {
				if(ns[i] == x) {
					f = true;
					break;
				}
			}
			if(!f) {
				ns[count++] = x;
			}
		}	
		return ns;
	}
	
	public static void main(String[] args) {
		int[] ns = generateNumber(4);
		int num = ns[0]*1000 + ns[1]*100 + ns[2]*10 + ns[3];
		System.out.println(num);
		while(true) {
			int a = 0;
			int b = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入您要猜测的四位数:");
			int guess = sc.nextInt();
			if(guess < 1000 || guess > 10000) {
				System.out.println("请输入四位数");
				continue;
			}
			int[] gs = {guess/1000, guess/100%10, guess/10%10, guess%10};
			
			for(int i = 0; i < ns.length; i++) {
				for(int j = 0; j < gs.length; j++) {
					if(ns[i] == gs[j] && i == j) {
						a++;
					}else if(ns[i] == gs[j] && i != j) {
						b++;
					}
				}
			}
			
			System.out.println("猜测结果："+a+"A"+b+"B");
			if(a == 4) {
				System.out.println("您猜中了数字："+num);
				break;
			}
		}
		
	}

}
