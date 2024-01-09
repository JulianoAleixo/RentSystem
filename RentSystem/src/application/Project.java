package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rent;

public class Project {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Rent[] rooms = new Rent[10];
		
		int qtd = 0;
		do {
			System.out.print("How many students will rent a room? ");
			qtd = sc.nextInt();
		} while (qtd > 10 || qtd < 1);

		for (int i = 0; i < qtd; i++) {
			sc.nextLine();
			System.out.printf("Rent #%d:%n", i + 1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();

			if (room >= 0 && room < 10 && rooms[room] == null) {
				rooms[room] = new Rent(name, email);
				System.out.println("Rent registered successfully.");
			} else {
				System.out.println("Invalid room or room already occupied. Please choose another room.");
				i--; // Decrement i to repeat the current iteration for a valid room input.
			}
		}

		System.out.println();
		System.out.println("Busy rooms: ");

		for (int i = 0; i < 10; i++) {
			if (rooms[i] != null) {
				System.out.print(i);
				System.out.print(": ");
				System.out.println(rooms[i]);
			}
		}
		sc.close();
	}
}