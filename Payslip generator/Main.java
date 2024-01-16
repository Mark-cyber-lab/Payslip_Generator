import payslipPackage.Payslip;

import java.util.Scanner;

public class Main{

    //create the scanner object globally so that you won't need to pass it
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args){

        
        //the holder for the salary
        double salary = 0;

        System.out.println("                                                                  Welcome to the payslip generator\n\n");

        do{
            //declare an object for the payslip
            Payslip payslip = new Payslip();

            //get the personal information of the user
            getPersonalInformation(payslip);

            //allows user to enter the salary and initialize it to the salary variable
            salary = putSalary();

            //put the salary to the payslip generator
            payslip.calculateForPayslip(salary);

            //print the Payslip
            printPaySlip(payslip);

            //asks the user if he/she still want to put data again
            System.out.print("\n\n\nPress 1 to enter data again: ");
        }while(Character.toUpperCase(read.nextLine().charAt(0)) == '1');

        System.out.println("\n\n\nHava a nice day!"); //farewell message

        read.close();   //close the scanner

    }

    //will get the personal information of the user
    private static void getPersonalInformation(Payslip payslip){
        //holder for the user's decision input
        char choice;    //I didn't initialize it because it produces error when initialized to my IDE

        OuterLoop:
        while (true){       //this will loop if the user selected the No if he is asked if the info provided is final
            //asks the user to input the information required for payslip
            System.out.println("                                          +=====================================================================================+");
            System.out.println("                                          |                                  Payslip Generator                                  |");
            System.out.println("                                          +=====================================================================================+");
            System.out.print("\n                                                          Enter employee name: ");
            payslip.setName(read.nextLine());
            System.out.print("\n                                                            Enter Designation: ");
            payslip.setDesignation(read.nextLine());

            System.out.print("\n                                                             Enter Department: ");
            payslip.setDepartment(read.nextLine());

            System.out.print("\n                                            Enter Date of Joining(MM/DD/YYYY): ");
            payslip.setDateOfJoining(read.nextLine());

            System.out.print("\n                                                 Enter Pay Period(MM/DD/YYYY): ");
            payslip.setPayPeriod(read.nextLine());

            printPersonalInfo(payslip);     //prints the personal info that has been provided

            //will ask if the user is final about the data that has been provided and will loop if the user has entered a wrong input
            while (true){

                    printContinue();
                    choice = Character.toUpperCase(read.nextLine().charAt(0));

                    if (choice == 'Y')
                        break OuterLoop; //will stop the loop all at once
                    else if (choice == 'N')
                        break;  //will only stop the inner loop
                    else
                        printError();   //prints error if the user has select neither of the two choices
            }
        }
    }

    //this method will print the personal info provided
    private static void printPersonalInfo(Payslip payslip){
        System.out.println("\n\n\n                                         +=====================================================================================+");
        System.out.println("                                         |                                    Personal Info                                    |");
        System.out.println("                                         +=====================================================================================+");
        System.out.println("                                          |                                                                                     |");
        System.out.printf ("                                          |                         Name: %25s                             |\n", payslip.getName());
        System.out.println("                                          |                                                                                     |");
        System.out.printf ("                                          |                  Designation: %25s                             |\n", payslip.getDesignation());
        System.out.println("                                          |                                                                                     |");
        System.out.printf ("                                          |                   Department: %25s                             |\n", payslip.getDepartment());
        System.out.println("                                          |                                                                                     |");
        System.out.printf ("                                          |              Date of Joining: %25s                             |\n", payslip.getDateOfJoining());
        System.out.println("                                          |                                                                                     |");
        System.out.printf ("                                          |                   Pay Period: %25s                             |\n", payslip.getPayPeriod());
        System.out.println("                                          |                                                                                     |");
        System.out.println("                                          +=====================================================================================+\n\n");
    }

    //this method will prompt the user to continue or not
    private static void printContinue(){
        System.out.println("\n\n\n                                                                  +=================================+");
        System.out.println("                                                                  |            Continue?            |");
        System.out.println("                                                                  +=================================+");
        System.out.println("                                                                  |                                 |");
        System.out.println("                                                                  |             [Y]es               |");
        System.out.println("                                                                  |             [N]o                |");
        System.out.println("                                                                  |                                 |");
        System.out.println("                                                                  +=================================+\n");
        System.out.print  ("                                                                            Enter here: ");
    }

    //show error message to the screen pertaining to the wrong choice
    private static void printError(){
        System.out.println("\n\n\n                                                                  +=================================+");
        System.out.println("                                                                  |           Invalid Input         |");
        System.out.println("                                                                  +=================================+");
        System.out.println("                                                                  |                                 |");
        System.out.println("                                                                  |    Input should be 'Y' or 'N'   |");
        System.out.println("                                                                  |                                 |");
        System.out.println("                                                                  +=================================+\n\n");
    }

    //will ask for the salary
    private static double putSalary(){
        //holder of the salary
        double salary = 0;

        //will continue to loop as long as the user has entered a string or a letter
        while (true){
            try {
                char choice; //holder of the choice input

                outerLoop:
                while (true){

                    while (true){    //this will loop if the salary entered is lesser than or equals to 0
                        System.out.println("\n\n\n                                                                  +=================================+");
                        System.out.println("                                                                  |              Salary             |");
                        System.out.println("                                                                  +=================================+\n\n");
                        System.out.print  ("                                                                        Enter Salary: ");
                        salary = Double.parseDouble(read.nextLine());

                        //checks if the salary is valid
                        if (salary <= 0)
                            printError2();      //outputs error message to the screen
                        else
                            break;  //exits from the current loop
                    }

                    //asks if the user wants to continue or rewrite the salary entered
                    while (true){
                        printContinue();    //prompt the user to continue or not
                        choice = read.nextLine().toUpperCase().charAt(0);   //wll receive the user input

                        //checks if the user has entered a valid input
                        if (choice == 'N')
                            break;  //breaks the inner loop but not the outerLoop therefore rewriting the salary entered
                        else if(choice == 'Y')
                            break outerLoop;  //breaks the outerLoop therefore there will be no loop happening
                        else
                            printError();   //print error message because the user has picked neither of the 2
                    }

                }

                //breaks the loop because everything went smoothly
                break;
            }
            catch (NumberFormatException e){    //this will catch the error if the user has entered a string or a character instead og a number
                printError3();  //outputs an error message
            }
        }
        //returns the salary
        return salary;
    }

    //outputs an error pertaining to the zero salary entered
    private static void printError2(){
        System.out.println("\n\n\n                                                                  +===================================+");
        System.out.println("                                                                  |            Invalid Input          |");
        System.out.println("                                                                  +===================================+");
        System.out.println("                                                                  |                                   |");
        System.out.println("                                                                  | Input should be Greater than zero |");
        System.out.println("                                                                  |                                   |");
        System.out.println("                                                                  +===================================+\n\n");
    }

    //output an error pertaining to the string input instead of a number
    private static void printError3(){
        System.out.println("\n\n\n                                                                  +===================================+");
        System.out.println("                                                                  |            Invalid Input          |");
        System.out.println("                                                                  +===================================+");
        System.out.println("                                                                  |                                   |");
        System.out.println("                                                                  |      Input should be a number     |");
        System.out.println("                                                                  |                                   |");
        System.out.println("                                                                  +===================================+\n\n");
    }

    //prints the payslip info
    private static void printPaySlip(Payslip receipt){
        //prints the payslip
        System.out.print ("\n\n\n");
        System.out.print ("                                                                   Payslip\n\n");
        System.out.print ("                                                                 Zoonodle Inc\n\n");
        System.out.print ("                                                           21023 Pearson Point Road\n");
        System.out.print ("                                                                Gateway Avenue\n\n\n");
        System.out.printf("                                  Date of Joining  : %11s           Employee Name  : %s\n", receipt.getDateOfJoining(), receipt.getName());
        System.out.printf("                                  Pay Period       : %11s           Designation    : %s\n", receipt.getPayPeriod(), receipt.getDesignation());
        System.out.printf("                                                                           Department     : %s\n\n", receipt.getDepartment());
        System.out.print ("                    +==================================================================================================+\n");
        System.out.print ("                    |         Earnings        |       Amount       |          Deductions          |       Amount       |\n");
        System.out.print ("                    +==================================================================================================+\n");
        System.out.printf("                    | Basic Pay               | %18.2f | Profession Tax               | %18.2f |\n", receipt.getBasicPay(), receipt.getProfessionTax());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Incentive Pay           | %18.2f | General Provident Fund       | %18.2f |\n", receipt.getIncentivePay(), receipt.getGeneralProvidentFund());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | House Rent Allowance    | %18.2f | Life Insurance Incorporation | %18.2f |\n", receipt.getHouseRentAllowance(), receipt.getLifeInsuranceCorporation());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Meal Allowance          | %18.2f | Postal Life Insurance        | %18.2f |\n", receipt.getMealAllowance(), receipt.getPostalLifeInsurance());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Medical Allowance       | %18.2f | Group Insurance              | %18.2f |\n", receipt.getMedicalAllowance(), receipt.getGroupInsurance());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Vehicle Allowance       | %18.2f | Income Tax                   | %18.2f |\n", receipt.getVehicleAllowance(), receipt.getIncomeTax());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Dearness Allowance      | %18.2f |                              |                    |\n", receipt.getDearnessAllowance());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    |                         |                    | Total Deductions             | %18.2f |\n", receipt.getTotalDeductions());
        System.out.print ("                    +-------------------------+--------------------+------------------------------+--------------------+\n");
        System.out.printf("                    | Gross Pay               | %18.2f | Net Pay                      | %18.2f |\n", receipt.getGrossPay(), receipt.getNetPay());
        System.out.print ("                    +==================================================================================================+\n\n\n");
    }
}