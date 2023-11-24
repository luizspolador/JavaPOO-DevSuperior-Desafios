package entities;

public class TaxPayer {
    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServiceIncome() {
        return serviceIncome;
    }

    public void setServiceIncome(double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }


    public double salaryTax(){
        double tax;
        if(salaryIncome < 3000.0){
            System.out.println("Isento");
            tax = 0.0;
        } else if (salaryIncome >= 3000.0 && salaryIncome < 5000.0){
            tax = 0.1;
        } else {
            tax = 0.2;
        }
        return salaryIncome * tax * 12;
    }

    public double serviceTax(){
        double tax = 0.0;
        if(serviceIncome > 0){
            tax = 0.15;
        }
        return serviceIncome * tax;
    }

    public double capitalTax(){
        double tax = 0.0;
        if(capitalIncome > 0){
            tax = 0.20;
        }
        return capitalIncome * tax;
    }

    public double grossTax(){
        return salaryTax() + serviceTax() + capitalTax();
    }

    public double taxRebate(){
        double medicoEducacional = healthSpending + educationSpending;
        double porcentagem = grossTax() * 0.3;
        if(medicoEducacional < porcentagem){
            return medicoEducacional;
        } else {
            return porcentagem;
        }
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }
}
