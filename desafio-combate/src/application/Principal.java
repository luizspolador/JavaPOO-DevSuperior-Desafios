package application;

import entities.Champion;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vidaInicial = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura = sc.nextInt();
        sc.nextLine();

        Champion champion1 = new Champion(nome, vidaInicial, ataque, armadura);

        System.out.println();
        System.out.println("Digite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String nome2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int vidaInicial2 = sc.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = sc.nextInt();
        sc.nextLine();

        Champion champion2 = new Champion(nome2, vidaInicial2, ataque2, armadura2);

        System.out.println();
        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = sc.nextInt();

        for (int i = 1; i <= turnos; i++) {
            System.out.println("Resultado do turno " + i + ":");
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);
            System.out.println(champion1.status());
            System.out.println(champion2.status());

            if (champion1.getLife() <= 0 || champion2.getLife() <= 0) {
                System.out.println("FIM DO COMBATE");
                break;
            }
        }
    }
}