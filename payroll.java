import java.util.Scanner;
class Employee2 {
    String empName;
    String empId;
    String address;
    String mailId;
    int mobileNo;
    double basicPay;
    public Employee(String empName, String empId, String address, String mailId, int mobileNo, double basicPay) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Address: " + address);
        System.out.println("Email: " + mailId);
        System.out.println("Mobile No: " + mobileNo);
        System.out.println("Basic Pay: " + basicPay);
    }
}

class Programmer extends Employee {
    private static final double DA_PERCENTAGE = 0.97;
    private static final double HRA_PERCENTAGE = 0.10;
    private static final double PF_PERCENTAGE = 0.12;
    private static final double STAFF_CLUB_PERCENTAGE = 0.01;

    public Programmer(String empName, String empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
    
    public void generatePaySlip() {
        super.generatePaySlip();

        double da = basicPay * DA_PERCENTAGE;
        double hra = basicPay * HRA_PERCENTAGE;
        double pf = basicPay * PF_PERCENTAGE;
        double staffClubFund = basicPay * STAFF_CLUB_PERCENTAGE;

        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        System.out.println("Designation: Programmer");
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Staff Club Fund: " + staffClubFund);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("--------------------");
    }
}

public class Payroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile No: ");
        int mobile = sc.nextLine();

        System.out.print("Enter Basic Pay: ");
        double basicPay = sc.nextDouble();

        Programmer p = new Programmer(name, id, address, email, mobileNo, basicPay);
        p.generatePaySlip();

        sc.close();
    }
}
