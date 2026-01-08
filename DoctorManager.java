package com.acc;

import java.util.List;
import java.util.Scanner;

import com.acc.model.Doctor;
import com.acc.service.OperableImp;

public class DoctorManager {

    public static void main(String[] args) throws DefaultMain {

        OperableImp op = new OperableImp();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= DOCTOR MANAGEMENT SYSTEM =========");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. View Doctors By Specialist");
            System.out.println("4. Find Doctor By ID");
            System.out.println("5. Update Doctor ");
            System.out.println("6. Delete Doctor");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Experience (Years): ");
                    int exp = sc.nextInt();

                    System.out.print("Enter Specialist: ");
                    String specialist = sc.next();

                    System.out.print("Enter First Name: ");
                    String fname = sc.next();

                    System.out.print("Enter Last Name: ");
                    String lname = sc.next();

                    System.out.print("Enter Contact: ");
                    long contact = sc.nextLong();

                    System.out.print("Enter Address: ");
                    String address = sc.next();

                    System.out.print("Enter Gender: ");
                    String gender = sc.next();

                    System.out.print("Enter Fees: ");
                    int fees = sc.nextInt();

                    System.out.print("Available (Yes/No): ");
                    String available = sc.next();

                    Doctor doc = new Doctor(id, exp, specialist, fname, lname,
                            contact, address, gender, fees, available);

                    op.add(doc);
                    break;

              
                case 2:
                    List<Doctor> doctors = op.findAll();
                    System.out.println("***************************************************************");
                    System.out.println("ID Exp Specialist FName LName Contact Fees Available");
                    System.out.println("***************************************************************");
                    for (Doctor d : doctors) {
                        System.out.println(d);
                    }
                    System.out.println("***************************************************************");
                    break;

                case 3:
                    System.out.print("Enter Specialist: ");
                    String sp = sc.next();
                    List<Doctor> spDocs = op.findAll(sp);

                    if (spDocs.isEmpty()) {
                        System.out.println("No Doctors Found for Specialist: " + sp);
                    } else {
                        for (Doctor d : spDocs) {
                            System.out.println(d);
                        }
                    }
                    break;

                
                case 4:
                    System.out.print("Enter Doctor ID: ");
                    int fid = sc.nextInt();
                    Doctor found = op.find(fid);

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Doctor Not Found");
                    break;

                
                case 5:
                    System.out.print("Enter Doctor ID to Update : ");
                    int uid = sc.nextInt();
                    op.update(uid);
                    break;

                
                case 6:
                    System.out.print("Enter Doctor ID to Delete: ");
                    int did = sc.nextInt();
                    op.delete(did);
                    break;

                
                case 7:
                    System.out.println("Thank You! Program Terminated.");
                    System.out.println("Creators :---\n ANAND NAKHATE \n NISHANT KORDE \n SIDDHANT DONGRE ");
                    break;

                default:
                   throw new DefaultMain("Your input is invalid...");
            }

        } while (choice != 7);

        sc.close();
    }
}
