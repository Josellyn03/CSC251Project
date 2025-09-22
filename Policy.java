// Policy.java
// Part 1 – Insurance Policy Class
// Name : Josellyn Zuniga

public class Policy {

    // fields for the policyholder
    private String policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    // no-arg constructor
    public Policy() {
        policyNumber = "";
        providerName = "";
        policyHolderFirstName = "";
        policyHolderLastName = "";
        policyHolderAge = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    // constructor with arguments
    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {

        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolderFirstName = firstName;
        this.policyHolderLastName = lastName;
        this.policyHolderAge = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // getters and setters
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyHolderFirstName() { return policyHolderFirstName; }
    public void setPolicyHolderFirstName(String firstName) { this.policyHolderFirstName = firstName; }

    public String getPolicyHolderLastName() { return policyHolderLastName; }
    public void setPolicyHolderLastName(String lastName) { this.policyHolderLastName = lastName; }

    public int getPolicyHolderAge() { return policyHolderAge; }
    public void setPolicyHolderAge(int age) { this.policyHolderAge = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // calculate BMI
    public double getBMI() {
        if (height == 0) return 0; // avoid divide by zero
        return (weight * 703) / (height * height);
    }

    // calculate policy price
    public double getPolicyPrice() {
        double price = 600; // base fee
        if (policyHolderAge > 50) price += 75; // extra if age > 50
        if (smokingStatus.equalsIgnoreCase("smoker")) price += 100; // extra if smoker
        double bmi = getBMI();
        if (bmi > 35) price += (bmi - 35) * 20; // extra if BMI > 35
        return price;
    }
}
