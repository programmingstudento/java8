package com.study;

import java.util.function.ToDoubleFunction;

public class Area {
	public static final ToDoubleFunction<Triangle> AREA = triangle -> {
		double area = triangle.getBase() * triangle.getHeight() * .5;
		triangle.setArea(area);
		return area;
	};

	public static void main(String[] args) {
		var triangle = new Triangle();
		System.out.println(AREA.applyAsDouble(triangle));
		System.out.println(triangle.getArea());
	}

}

class Triangle {

	private final int height = 10;
	private final int base = 5;
	private double area;

	public void setArea(double a) {
		area = a;
	}

	public double getArea() {
		return area;
	}

	public int getHeight() {
		return height;
	}

	public int getBase() {
		return base;
	}

}