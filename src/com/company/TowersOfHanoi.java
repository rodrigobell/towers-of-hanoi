package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class TowersOfHanoi {

	public void solve(int n, Peg start, Peg aux, Peg finish) {
		if (n == 1) {
			System.out.println(n + " from " + start.name + " to " + finish.name);
		} else {
			solve(n - 1, start, aux, finish);
			System.out.println(n + " from " + start.name + " to " + finish.name);
			solve(n - 1, aux, start, finish);
		}
	}

//	public void solve(int n, String start, String auxiliary, String end) {
//		if (n == 1) {
//			System.out.println(start + " -> " + end);
//		} else {
//			solve(n - 1, start, end, auxiliary);
//			System.out.println(start + " -> " + end);
//			solve(n - 1, auxiliary, start, end);
//		}
//	}

    public static void main(String[] args) {
		System.out.println("Move                   Peg Configuration");
		System.out.println("                       A          B          C");

//	    System.out.print("Enter number of disks: ");
//	    Scanner scanner = new Scanner(System.in);
//	    int disks = scanner.nextInt();

		int disks = 3;

	    Peg A = new Peg("A");
	    Peg B = new Peg("B");
	    Peg C = new Peg("C");

		TowersOfHanoi towers = new TowersOfHanoi();

	    towers.solve(disks, A, B, C);
    }
}

class Peg {
	public String name = new String();
//	private ArrayList<Integer> disks = new ArrayList<Integer>();

	public Peg() {}

	public Peg(String name) {
		this.name = name;
	}

//	public void Peg(String name, int n) {
//		this.name = name;
//
//		for (int i = 0; i < n; i++) {
//			this.disks.add(n);
//		}
//	}
}
