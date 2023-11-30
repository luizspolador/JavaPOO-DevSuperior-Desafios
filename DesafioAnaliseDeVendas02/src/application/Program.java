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

            Set<String> vendedores = list.stream() // criado um set de String e convertido para stream. Set foi utililizado pq n permite repetição
                    .map(Sale::getSeller) // pega os sellers (nome dos vendedores) de casa Sale (venda)
                    .collect(Collectors.toSet()); // transforma para um set novamente

            Map<String, Double> totalVenda = vendedores.stream() // criado um map que possui o seller como chave e o total como valor. Convertido o map para stream
                    .collect(Collectors.toMap( // pegando os elementos do map
                            seller -> seller, // definindo os selers como chave
                            seller -> list.stream() // definindo valor
                                    .filter(s -> s.getSeller().equals(seller)) // filtrando as vendas de vendedores do mesmo nome
                                    .mapToDouble(Sale::getTotal) // mapeando a venda para o valor total
                                    .sum() // soma o total de vendas para o seller
                    ));

            System.out.println("Total de vendas por vendedor:");
            totalVenda.forEach((seller, total) -> System.out.println(seller + ": R$ " + String.format("%.2f", total)));

        } catch (IOException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }
    }
}
