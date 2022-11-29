package com.study;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {
	private double value;
	private Operation operation;
	private Lock lock;

	public Calculator(double value, Operation operation) {
		this.value = value;
		this.operation = operation;
		lock = new ReentrantLock();
	}

	public void add(double value) {
		try {
			lock.lock();
			this.value += value;
		} finally {
			lock.unlock();
		}
	}

	public void subtract(double value) {
		try {
			lock.lock();
			this.value -= value;
		} finally {
			lock.unlock();
		}
	}

	public void multiply(double value) {
		try {
			lock.lock();
			this.value *= value;
		} finally {
			lock.unlock();
		}
	}

	public void divide(double value) {
		try {
			lock.lock();
			this.value /= value;
		} finally {
			lock.unlock();
		}
	}

	public double getValue() {
		return value;
	}

	public void calculate(Calculator[] calculators) {
		Arrays.stream(calculators).forEach(calculator -> {
			double result = switch (calculator.operation) {
			case ADDITION -> {
				try {
					lock.lock();
					calculator.add(10);

				} finally {
					lock.unlock();
				}
				yield calculator.getValue();
			}
			case SUBTRACTION -> {
				try {
					lock.lock();
					calculator.subtract(10);
				} finally {
					lock.unlock();
				}
				yield calculator.getValue();
			}
			case MULTIPLICATION -> {
				try {
					lock.lock();
					calculator.multiply(10);
				} finally {
					lock.unlock();
				}
				yield calculator.getValue();
			}
			case DIVISION -> {
				try {
					lock.lock();
					calculator.divide(10);
				} finally {
					lock.unlock();
				}
				yield calculator.getValue();
			}
			};
			System.out.format("Result after %s  is : %f%n", calculator.operation, result);
		});
	}
}
