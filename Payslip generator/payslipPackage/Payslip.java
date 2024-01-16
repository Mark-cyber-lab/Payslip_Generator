package payslipPackage;

public class Payslip {

    //personal info
    private String name = "";
    private String designation = "";
    private String department = "";
    private String dateOfJoining = "";
    private String payPeriod = "";


    //this is for the emoluments
    private double basicPay = 0;
    private final double houseRentAllowance = 3000;
    private final double mealAllowance = 1000;
    private final double medicalAllowance = 100;
    private final double vehicleAllowance = 500;
    private final double dearnessAllowance = 7500;
    private final double incentivePay = 1000;


    //this is for the deductions
    private double professionTax = 200;
    private double generalProvidentFund = 4000;
    private double lifeInsuranceCorporation = 5000;
    private double postalLifeInsurance = 240;
    private double groupInsurance = 150;
    private double incomeTax = 1000;


    //the result of the basic pay added with emoluments
    private double grossPay = 0;


    //the total of the deductions to the gross pay
    private double totalDeductions = 0;


    //the result of the deduction to the basic pay and emoluments
    private double netPay = 0;

    //constructor
    public Payslip(){
        //setting the personal info to the constructor
        this.setName(name);
        this.setDesignation(designation);
        this.setDepartment(department);
        this.setDateOfJoining(dateOfJoining);
        this.setPayPeriod(payPeriod);

        this.calculateForPayslip(basicPay); //gets the salary
    }


    //setters for personal info
    public void setName(String name) {
        this.name = name;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }


    //getters for personal info
    public String getName() {
        return name;
    }
    public String getDesignation() {
        return designation;
    }
    public String getDepartment() {
        return department;
    }
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    public String getPayPeriod() {
        return payPeriod;
    }

    //calculates the salary by setting the grosspay and the deductions to be made
    public void calculateForPayslip(double basicPay){
        this.basicPay = basicPay;

        //sets the gross pay
        setGrossPay();

        //sets all the deductions
        setProfessionTax();
        setGeneralProvidentFund();
        setLifeInsuranceCorporation();
        setPostalLifeInsurance();
        setGroupInsurance();
        setIncomeTax();
        setTotalDeductions();

        //sets the net pay or the final salary
        netPay();
    }


    //sets the gross pay or the basic pay added by the emoluments
    private void setGrossPay(){
        grossPay = houseRentAllowance + mealAllowance + medicalAllowance + vehicleAllowance + dearnessAllowance + incentivePay + basicPay;
    }


    //deductions
    private void setProfessionTax(){
        professionTax = basicPay * 0.014;  //1.4%
    }
    private void setGeneralProvidentFund(){
        generalProvidentFund = basicPay * 0.15; //15%
    }
    private void setLifeInsuranceCorporation(){
        lifeInsuranceCorporation = basicPay * 0.20; //20%
    }
    private void setPostalLifeInsurance(){
        postalLifeInsurance = basicPay * 0.016; //1.6%
    }
    private void setGroupInsurance(){
        groupInsurance = basicPay * 0.01;  //1%
    }
    private void setIncomeTax(){
        incomeTax = basicPay * 0.067;  //6.7%
    }


    //all the deductions combined
    private void setTotalDeductions(){
        this.totalDeductions = professionTax + generalProvidentFund + lifeInsuranceCorporation + postalLifeInsurance + groupInsurance + incomeTax;
    }


    //Net pay or the salary that has been added with emoluments and deducted
    private  void netPay(){
        netPay = grossPay - totalDeductions;
    }


    //getter of the basic pay
    public double getBasicPay(){
        return basicPay;
    }


    //getters of the emoluments
    public double getHouseRentAllowance(){
        return houseRentAllowance;
    }
    public double getDearnessAllowance() {
        return dearnessAllowance;
    }
    public double getMedicalAllowance() {
        return medicalAllowance;
    }
    public double getMealAllowance() {
        return mealAllowance;
    }
    public double getVehicleAllowance() {
        return vehicleAllowance;
    }
    public double getIncentivePay() {
        return incentivePay;
    }

    //getters of the gross pay
    public double getGrossPay() {
        return grossPay;
    }

    //getters of the deductions
    public double getProfessionTax() {
        return professionTax;
    }
    public double getGeneralProvidentFund() {
        return generalProvidentFund;
    }
    public double getLifeInsuranceCorporation() {
        return lifeInsuranceCorporation;
    }
    public double getPostalLifeInsurance() {
        return postalLifeInsurance;
    }
    public double getGroupInsurance() {
        return groupInsurance;
    }
    public double getIncomeTax() {
        return incomeTax;
    }


    //getter of the total deductions
    public double getTotalDeductions() {
        return totalDeductions;
    }

    //getter of the net pay
    public double getNetPay() {
        return netPay;
    }
}
