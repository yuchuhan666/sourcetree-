package com.neusoft.demo;

public class Triangle {
	
	double a;
	double b;
	double c;
	double d;
	
	public Triangle() {}
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public boolean isTriangle() {
		return (a + b > c && a + c > b && b + c > a);
	}
	
	public double getRound() {
		if(isTriangle()) {
			return a + b + c;
		}
		return -1;
	}
	
	public double getArea() {
		if(isTriangle()) {
			double p = getRound() / 2;
			return Math.sqrt(p*(p+a)*(p+b)*(p+c));
		}
		return -1;
	}
}
