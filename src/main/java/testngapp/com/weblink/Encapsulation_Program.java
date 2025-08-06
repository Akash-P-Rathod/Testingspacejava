package testngapp.com.weblink;


import java.util.Scanner; // Scanner class import करना

public class Encapsulation_Program {

    private String name; // private variable

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanner object create
        Encapsulation_Program obj = new Encapsulation_Program(); // object create

        System.out.print("Enter Student Name: ");
        String inputName = sc.nextLine(); // user से input लेना

        obj.setName(inputName); // setName method से set करना

        System.out.println("Student Name Is: " + obj.getName()); // result show

        sc.close(); // Scanner बंद करना (optional लेकिन good practice)
    }
}
