import java.util.Locale;
import java.util.Scanner;

public class DesafioAtletas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? ");
        int atletas = sc.nextInt();
        int countSexoFeminino = 0;
        int countSexoMasculino = 0;
        double somaAlturaFeminina = 0.0;
        double pesoTotal = 0.0;
        double pesoMedio;
        String maisAlto = null;
        double altura1 = 0.0;

        for (int i = 1; i <= atletas; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ":");

            System.out.print("Nome: ");
            String nome = sc.next(); // Removido sc.nextLine()
            sc.nextLine();

            char sexo;
            do {
                System.out.print("Sexo (F/M): ");
                sexo = sc.next().charAt(0);
                if (sexo != 'F' && sexo != 'M') {
                    System.out.println("Digite o sexo novamente.");
                }
            } while (sexo != 'F' && sexo != 'M');

            if (sexo == 'F') {
                countSexoFeminino++;
            } else {
                countSexoMasculino++;
            }

            double altura;
            do {
                System.out.print("Altura: ");
                altura = sc.nextDouble();
                if (altura <= 0) {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            } while (altura <= 0);

            if (altura > altura1) {
                altura1 = altura;
                maisAlto = nome;
            }

            if (sexo == 'F') {
                somaAlturaFeminina += altura;
            }

            double peso;
            do {
                System.out.print("Peso: ");
                peso = sc.nextDouble();
                if (peso <= 0) {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            } while (peso <= 0);

            pesoTotal += peso;
        }

        pesoMedio = pesoTotal / atletas;
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);

        System.out.println("Atleta mais alto: " + maisAlto);

        double porcentagemHomens = (double) countSexoMasculino / atletas * 100;
        System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagemHomens);

        double mediaAlturaFeminina = (countSexoFeminino == 0) ? 0 : somaAlturaFeminina / countSexoFeminino;

        if (countSexoFeminino == 0) {
            System.out.println("Não há mulheres cadastradas.");
        } else {
            System.out.printf("Altura média das mulheres: %.1f%n", mediaAlturaFeminina);
        }

        sc.close();
    }
}
