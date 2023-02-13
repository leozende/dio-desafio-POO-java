package br.com.dio.desafio.dominio;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class ChangeInformation {

    public static String changeName (Scanner scan, String info) {
        System.out.println("What is the name of the " + info + "?");
        String name = scan.nextLine();

        while(true) {
            System.out.println(info + "'s name is - " + name + " - Do you want to change?");
            String confirm = scan.nextLine();
            if(confirm.equalsIgnoreCase("no")){
                return name;
            } else if(confirm.equalsIgnoreCase("yes")){
                System.out.println("So please, write the name again.");
                name = scan.nextLine();
            } else {
                System.out.println("Invalid answer, write again.");
            }
        }
    }

    public static String changeDescription (Scanner scan, String info) {
        System.out.println("What is the description of the " + info + "?");
        String description = scan.nextLine();

        while(true) {
            System.out.println(info + " description: " + description + " - Do you want to change?");
            String confirm = scan.nextLine();
            if(confirm.equalsIgnoreCase("no")){
                return description;
            } else if(confirm.equalsIgnoreCase("yes")){
                System.out.println("So please, write a new description.");
                description = scan.nextLine();
            } else {
                System.out.println("Invalid answer, write again.");
            }
        }
    }

    public static Integer changeWorkload (Scanner scan) {
        System.out.println("How long is the course? ");
        Integer workload = verifyNumber(scan);

        while(true) {
            System.out.println("Content time: " + workload + " - Do you want to change?");
            String confirm = scan.nextLine();
            if(confirm.equalsIgnoreCase("no")){
                return workload;
            } else if(confirm.equalsIgnoreCase("yes")){
                System.out.println("So please, write a new time.");
                workload = verifyNumber(scan);
            } else {
                System.out.println("Invalid answer, write again.");
            }
        }
    }

    public static Integer verifyNumber (Scanner scan) {
        Integer number = 0;
        boolean loopContinue = true;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                loopContinue = false;    
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Invalid input, please enter an integer! " + e.getMessage());
            } 
        } while (loopContinue);
        return number;
    } 

    public static Set<Bootcamp> createContent(Scanner scan, String content) {
        String changeName = changeName(scan, content);
        String changeDescription = changeDescription(scan, content);
        Set<Bootcamp> contentInfo = new HashSet<>(){{
            add(new Bootcamp(changeName, changeDescription));
        }};

        return contentInfo;
    }
}
