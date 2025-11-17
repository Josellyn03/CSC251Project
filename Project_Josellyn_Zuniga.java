// Project_Josellyn_Zuniga.java
// Part 3 – Insurance Policy
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

                // Create the PolicyHolder object
                PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                       smokingStatus, height, weight);

                // Create the Policy object and add to list
                Policy policy = new Policy(policyNumber, providerName, holder);
                policies.add(policy);

                // Skip blank line if present
                if (input.hasNextLine()) {
                    input.nextLine();
                }
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

            // Implicitly calls the toString() method
            System.out.println(p);

            // Count smokers/non-smokers
            if (p.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display totals
        System.out.println("\nThere were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non smoker is: " + nonSmokerCount);
    }
}
