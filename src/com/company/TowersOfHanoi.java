package com.company;
import java.util.ArrayList;

public class TowersOfHanoi {
	public int nDisks = 3;
	public Peg A = new Peg("A", nDisks);
	public Peg B = new Peg("B");
	public Peg C = new Peg("C");

	public void start() {
		System.out.println("Move                   Peg Configuration");
		System.out.println("                    A         B         C");
		System.out.print("init                ");
		for (int i = nDisks; i > 0; i--) {
			System.out.print(i);
		}
		System.out.print('\n');
		solve(nDisks, A, B, C);
	}

	public void solve(int topDisk, Peg A, Peg B, Peg C) {
		if (topDisk == 1) {
			int d = A.pop();
			C.push(d);
			System.out.print(d + " from " + A.name + " to " + C.name + "       ");
			printStep();
		} else {
			solve(topDisk - 1, A, C, B);
			int d = A.pop();
			C.push(d);
			System.out.print(d + " from " + A.name + " to " + C.name + "       ");
			printStep();
			solve(topDisk - 1, B, A, C);
		}
	}

	public void printStep() {
		this.A.printDisks(nDisks);
		this.B.printDisks(nDisks);
		this.C.printDisks(nDisks);
		System.out.print('\n');
	}

    public static void main(String[] args) {
		TowersOfHanoi tower = new TowersOfHanoi();
		tower.start();
    }
}

class Peg {
	public String name = new String();
	public ArrayList<Integer> disks = new ArrayList<Integer>();

	public Peg() {}

	public Peg(String name) {
		this.name = name;
	}

	public Peg(String name, int n) {
		this.name = name;

		for (int i = n; i > 0; i--) {
			this.disks.add(i);
		}
	}

	void push(int d) {
		this.disks.add(d);
	}

	int pop() {
		int d = 0;
		if (!this.disks.isEmpty()) {
			d = this.disks.get(this.disks.size() - 1);
			this.disks.remove(this.disks.size() - 1);
		}

		return d;
	}

	void printDisks(int nDisks) {
		for (int i = 0; i < nDisks; i++) {
			if (i >= this.disks.size())
				System.out.print(" ");
			else
				System.out.print(this.disks.get(i));
		}
		System.out.print("       ");
	}
}
