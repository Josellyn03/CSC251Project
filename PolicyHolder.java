// PolicyHolder.java
// Represents the person associated with a Policy

public class PolicyHolder {

    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * Regular constructor to build a PolicyHolder object.
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {
        this.policyHolderFirstName = firstName;
        this.policyHolderLastName = lastName;
        this.policyHolderAge = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Creates a copy of an existing PolicyHolder object.
     */
    public PolicyHolder(PolicyHolder other) {
        this.policyHolderFirstName = other.policyHolderFirstName;
        this.policyHolderLastName = other.policyHolderLastName;
        this.policyHolderAge = other.policyHolderAge;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Calculates and returns BMI.
     */
    public double getBMI() {
        if (height == 0) return 0;
        return (weight * 703) / (height * height);
    }

    /**
     * toString for Project 3 — prints all PolicyHolder info.
     */
    public String toString() {
        return "Policyholder's First Name: " + policyHolderFirstName +
               "\nPolicyholder's Last Name: " + policyHolderLastName +
               "\nPolicyholder's Age: " + policyHolderAge +
               "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
               "\nPolicyholder's Height: " + height + " inches" +
               "\nPolicyholder's Weight: " + weight + " pounds" +
               String.format("\nPolicyholder's BMI: %.2f\n", getBMI());
    }
}
