package application;

import entities.Adress;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int diaPagamento = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Adress endereco = new Adress(email, telefone);
        Department departmento = new Department(departamento, diaPagamento, endereco);

        System.out.print("Quantos funcionários tem o departamento? ");
        int funcionarios = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<funcionarios; i++){
            System.out.println("Dados do funcionário " + (i+1) + ":");
            System.out.print("Nome: ");
            String nomeFuncionario = sc.nextLine();
            System.out.print("Salário: ");
            double salarioFuncionario = sc.nextDouble();
            sc.nextLine();
            Employee funcionario = new Employee(nomeFuncionario, salarioFuncionario);
            departmento.addEmployee(funcionario);
        }

        System.out.println();
        System.out.println("FOLHA DE PAGAMENTO:");
        showReport(departmento);

        sc.close();
    }

    private static void showReport(Department dept){
        System.out.println("Departamento " + dept.getName() + " = R$ " + dept.payRoll());
        System.out.println("Pagamento realizado no dia " + dept.getPayDay());
        System.out.println("Funcionários: ");
        for(Employee employee : dept.getEmployees()){
            System.out.println(employee.getName());
        }
        System.out.println("Para dúvidas favor entrar em contato: " + dept.getAdress().getEmail());
    }
}
