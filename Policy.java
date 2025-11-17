// Policy.java
// Part 1 – Insurance Policy Class
// Name : Josellyn Zuniga

// Updated Policy.java for Project 3
// Uses a PolicyHolder object instead of storing person details here

public class Policy {

    private String policyNumber;
    private String providerName;
    private PolicyHolder holder;

    // static counter for Project 3
    private static int policyCount = 0;

    /**
     * Constructs a Policy object.
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param holder the PolicyHolder object associated with the policy
     */
    public Policy(String policyNumber, String providerName, PolicyHolder holder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;

        // store a COPY for security
        this.holder = new PolicyHolder(holder);

        policyCount++;
    }

    /**
     * Returns the policy number.
     * @return the policy number
     */
    public String getPolicyNumber() { 
        return policyNumber; 
    }

    /**
     * Returns the provider name.
     * @return the provider name
     */
    public String getProviderName() { 
        return providerName; 
    }

    /**
     * Returns a COPY of the PolicyHolder to avoid security issues.
     * @return a PolicyHolder copy
     */
    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(holder);
    }

    /**
     * Calculates and returns the policy price.
     * Uses the PolicyHolder's age, smoking status, and BMI.
     * @return the policy price
     */
    public double getPolicyPrice() {

        double price = 600; // base fee

        if (holder.getAge() > 50)
            price += 75;

        if (holder.getSmokingStatus().equalsIgnoreCase("smoker"))
            price += 100;

        double bmi = holder.getBMI();
        if (bmi > 35)
            price += (bmi - 35) * 20;

        return price;
    }

    /**
     * Returns the number of Policy objects created.
     * @return total policies created
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Returns a formatted string containing all policy information.
     * Calls the PolicyHolder's toString().
     */
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName + "\n" +
               holder.toString() +
               String.format("Policy Price: $%.2f\n", getPolicyPrice());
    }
}


