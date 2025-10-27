// Project_Josellyn_Zuniga.java
// Part 2 – Insurance Policy Demo
// Name: Josellyn Zuniga

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_Josellyn_Zuniga {
    public static void main(String[] args) {

        // List to hold all Policy objects
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            // Open the file
            File file = new File("PolicyInformation.txt");
            Scanner input = new Scanner(file);

            // Read data from file
            while (input.hasNext()) {
                String policyNumber = input.nextLine().trim();
                String providerName = input.nextLine().trim();
                String firstName = input.nextLine().trim();
                String lastName = input.nextLine().trim();
                int age = Integer.parseInt(input.nextLine().trim());
                String smokingStatus = input.nextLine().trim();
                double height = Double.parseDouble(input.nextLine().trim());
                double weight = Double.parseDouble(input.nextLine().trim());

                // Create Policy object and add to list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                           age, smokingStatus, height, weight);
                policies.add(policy);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        }

        // Counters for smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Display all policy info
        for (Policy p : policies) {
            System.out.println("\nPolicy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder's First Name: " + p.getPolicyHolderFirstName());
            System.out.println("Policyholder's Last Name: " + p.getPolicyHolderLastName());
            System.out.println("Policyholder's Age: " + p.getPolicyHolderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println("Policyholder's Height: " + p.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + p.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", p.getBMI());
            System.out.printf("Policy Price: $%.2f\n", p.getPolicyPrice());

            // Count smokers/non-smokers
            if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display totals
        System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}

