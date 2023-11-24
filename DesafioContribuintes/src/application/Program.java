package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for(int i=0; i<n; i++){
            System.out.println("Digite os dados do " + (i+1) + "o contribuinte:");
            System.out.print("Renda anual com salário: ");
            double anual = sc.nextDouble();
            double mensal = anual/12;
            System.out.print("Renda anual com prestação de serviço: ");
            double servico = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capital = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double medico = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educacao = sc.nextDouble();
            TaxPayer taxPayer = new TaxPayer(mensal, servico, capital, medico, educacao);
            taxPayers.add(taxPayer);
            System.out.println();
        }

        System.out.println();
        for(TaxPayer x : taxPayers){
            x.salaryTax();
            x.serviceTax();
            x.capitalTax();
            double impostoBruto = x.grossTax();
            double abatimento = x.taxRebate();
            double impostoDevido = x.netTax();
            System.out.println("Resumo: " + (taxPayers.indexOf(x)+1));
            System.out.printf("Imposto bruto total: %.2f%n" , impostoBruto);
            System.out.printf("Abatimento: %.2f%n" , abatimento);
            System.out.printf("Imposto devido: %.2f%n" , impostoDevido);
            System.out.println();
        }

        sc.close();
    }
}
