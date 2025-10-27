// Policy.java
// Part 1 – Insurance Policy Class
// Name : Josellyn Zuniga

/**
 * The Policy class represents an insurance policy for a policyholder.
 * It stores information about the policy and the policyholder, 
 * and calculates BMI and policy price based on given data.
 */
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

    /**
     * No-argument constructor that initializes all fields to default values.
     */
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

    /**
     * Constructor with arguments to initialize all fields.
     * @param policyNumber the policy number
     * @param providerName the insurance provider's name
     * @param firstName the policyholder's first name
     * @param lastName the policyholder's last name
     * @param age the policyholder's age
     * @param smokingStatus the policyholder's smoking status ("smoker" or "non-smoker")
     * @param height the policyholder's height in inches
     * @param weight the policyholder's weight in pounds
     */
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

    /**
     * Returns the policy number.
     * @return the policy number
     */
    public String getPolicyNumber() { return policyNumber; }

    /**
     * Sets the policy number.
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    /**
     * Returns the provider name.
     * @return the provider name
     */
    public String getProviderName() { return providerName; }

    /**
     * Sets the provider name.
     * @param providerName the provider name to set
     */
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /**
     * Returns the policyholder's first name.
     * @return the policyholder's first name
     */
    public String getPolicyHolderFirstName() { return policyHolderFirstName; }

    /**
     * Sets the policyholder's first name.
     * @param firstName the first name to set
     */
    public void setPolicyHolderFirstName(String firstName) { this.policyHolderFirstName = firstName; }

    /**
     * Returns the policyholder's last name.
     * @return the policyholder's last name
     */
    public String getPolicyHolderLastName() { return policyHolderLastName; }

    /**
     * Sets the policyholder's last name.
     * @param lastName the last name to set
     */
    public void setPolicyHolderLastName(String lastName) { this.policyHolderLastName = lastName; }

    /**
     * Returns the policyholder's age.
     * @return the policyholder's age
     */
    public int getPolicyHolderAge() { return policyHolderAge; }

    /**
     * Sets the policyholder's age.
     * @param age the age to set
     */
    public void setPolicyHolderAge(int age) { this.policyHolderAge = age; }

    /**
     * Returns the policyholder's smoking status.
     * @return the smoking status ("smoker" or "non-smoker")
     */
    public String getSmokingStatus() { return smokingStatus; }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus the smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    /**
     * Returns the policyholder's height in inches.
     * @return the height in inches
     */
    public double getHeight() { return height; }

    /**
     * Sets the policyholder's height in inches.
     * @param height the height to set in inches
     */
    public void setHeight(double height) { this.height = height; }

    /**
     * Returns the policyholder's weight in pounds.
     * @return the weight in pounds
     */
    public double getWeight() { return weight; }

    /**
     * Sets the policyholder's weight in pounds.
     * @param weight the weight to set in pounds
     */
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * @return the BMI value
     */
    public double getBMI() {
        if (height == 0) return 0; // avoid divide by zero
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the policy price based on age, smoking status, and BMI.
     * @return the policy price
     */
    public double getPolicyPrice() {
        double price = 600; // base fee
        if (policyHolderAge > 50) price += 75; // extra if age > 50
        if (smokingStatus.equalsIgnoreCase("smoker")) price += 100; // extra if smoker
        double bmi = getBMI();
        if (bmi > 35) price += (bmi - 35) * 20; // extra if BMI > 35
        return price;
    }
}

