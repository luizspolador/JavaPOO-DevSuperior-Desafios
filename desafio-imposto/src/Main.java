import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //SOLICITANDO DADOS
        System.out.print("Renda anual com salário: ");
        double renda = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double servico = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double capital = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double medicos = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double educacionais = sc.nextDouble();

        System.out.println();

        //RELATORIOD E IMPOSTO DE RENDA
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA: ");


        double mensal = renda/12;
        double impostoSalario = 0.0;
        double impostoServico = 0.0;
        double impostoCapital = 0.0;

        //VALIDANDO SALÁRIO

        if(mensal < 3000.0){
            System.out.println("Imposto sobre o salário: ISENTO");
        } else if (mensal >= 3000.0 && mensal < 5000.0){
            impostoSalario = mensal * 0.10 * 12;
            System.out.printf("Imposto sobre o salário: %.2f%n" , impostoSalario);
        } else {
            impostoSalario = mensal * 0.20 * 12;
            System.out.printf("Imposto sobre o salário: %.2f%n" , impostoSalario);
        }

        //SERVIÇOS
        if(servico > 0.0){
            impostoServico = servico * 0.15;
            System.out.printf("Imposto sobre serviços: %.2f%n" , impostoServico);
        } else {
            impostoServico = 0.00;
            System.out.printf("Imposto sobre serviços: %.2f%n" , impostoServico);
        }

        //CAPITAL
        if(capital > 0.0){
            impostoCapital = capital * 0.20;
            System.out.printf("Imposto sobre ganho de capital: %.2f%n" , impostoCapital);
        } else {
            impostoCapital = 0.00;
            System.out.printf("Imposto sobre ganho de capital: %.2f%n" , impostoCapital);
        }

        System.out.println("DEDUÇÕES:");
        double impostoBruto = impostoSalario + impostoServico + impostoCapital;
        double porcentagemBruto = impostoBruto * 0.30;
        double medicoEducacional = medicos + educacionais;
        double abatimento = 0.0;

        if(medicoEducacional < porcentagemBruto){
            abatimento = medicoEducacional;
        } else {
            abatimento += porcentagemBruto;
        }

        System.out.printf("Máximo dedutível:  %.2f%n", porcentagemBruto);
        System.out.printf("Gastos dedutíveis: %.2f%n" , medicoEducacional);

        System.out.println();

        System.out.println("RESUMO");
        System.out.printf("Imposto bruto total: %.2f%n" , impostoBruto);
        System.out.printf("Abatimento: %.2f%n" , abatimento);
        double impostoDevido = impostoBruto - abatimento;
        System.out.printf("Imposto devido: %.2f%n" , impostoDevido);
    }
}