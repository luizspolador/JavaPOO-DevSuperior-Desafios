package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Sale> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
                line = br.readLine();
            }

            List<Sale> vendas = list.stream() // transforma para stream
                    .filter(s -> s.getYear() == 2016) // filtra todos os dados de 2016
                    .sorted(Comparator.comparingDouble(Sale::averagePrice).reversed()) // compara os preços medios e pega do maior para o menor valor
                    .limit(5) // pega apenas os 5 maiores valores
                    .collect(Collectors.toList()); // converte para lista novamente

            System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
            vendas.forEach(System.out::println);

            System.out.println();

            double logan = list.stream() // transforma para stream
                    .filter(s -> s.getSeller().equals("Logan"))// filtra o vendedor Logan
                    .filter(s -> s.getMonth() == 1 || s.getMonth() == 7)// filtra as vendas entre os meses 1 e 7
                    .mapToDouble(Sale::getTotal) // mapeia as vendas para o valor total
                    .sum(); // soma os totais

            System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f%n" , logan);

        } catch (IOException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }
    }
}
