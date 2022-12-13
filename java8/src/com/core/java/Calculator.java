package com.core.java;

import java.util.Arrays;

public class Calculator {
	public double getTotalArea(Shape... shapes) {
		return Double.valueOf(String.format("%.2f", Arrays.stream(shapes).mapToDouble(Shape::area).sum()));
	}
}

interface Shape {
	double area();
}

class Square implements Shape {
	double side;

	Square(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return side * side;
	}
}

class Triangle implements Shape {
	double base;
	double height;

	Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public double area() {
		return base * height;
	}
}

class Rectangle implements Shape {
	double width;
	double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height * .5;
	}
}

class Circle implements Shape {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return radius * radius * Math.PI;
	}
}