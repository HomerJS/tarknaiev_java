package com.tarknaiev.home_4_regex;

/**
 * The type Model person.
 *
 * @author ihor Tarknaiev
 */
public class ModelPerson {
    private String lastName;
    private String firstName;
    private String secondName;
    private String nickName;
    private String comment;
    private String group;
    private String phone;
    private String phoneMob;
    private String phoneMob2;
    private String email;
    private String skype;
    private String postcode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String createdAt;
    private String updatedAt;

    /**
     * Match input data and regex
     *
     * @param regex      the regex
     * @param inputValue the input value
     * @return Boolean boolean
     */
    public boolean validate(String regex, String inputValue) {
        return inputValue.matches(regex);
    }

    /**
     * Set data to an object's fields
     *
     * @param fieldName  the field name
     * @param inputValue the input value
     */
    public void setData(String fieldName, String inputValue) {
        try {
            this.getClass().getDeclaredField(fieldName).set(this, inputValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates string with all data
     *
     * @return String string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Last name: ").append(this.getLastName()).append("\n")
                .append("First name: ").append(this.getFirstName()).append("\n");
        return builder.toString();
    }

    /**
     * Generates string with full name
     *
     * @return String string
     */
    public String getFullName() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getLastName()).append(" ").append(this.getFirstName().toUpperCase().charAt(0)).append(".");
        return builder.toString();
    }

    /**
     * Generates string with full address
     *
     * @return String string
     */
    public String getFullAddress() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getPostcode()).append(", ").append(this.getCity()).append("\n")
                .append(this.getStreet()).append(" ").append(this.getHouseNumber()).append("/").append(this.getFlatNumber());
        return builder.toString();
    }

    /**
     * Gets last name.
     *
     * @return String last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets second name.
     *
     * @return the second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets second name.
     *
     * @param secondName the second name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * Gets nick name.
     *
     * @return the nick name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets nick name.
     *
     * @param nickName the nick name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets group.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets group.
     *
     * @param group the group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets phone mob.
     *
     * @return the phone mob
     */
    public String getPhoneMob() {
        return phoneMob;
    }

    /**
     * Sets phone mob.
     *
     * @param phoneMob the phone mob
     */
    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    /**
     * Gets phone mob 2.
     *
     * @return the phone mob 2
     */
    public String getPhoneMob2() {
        return phoneMob2;
    }

    /**
     * Sets phone mob 2.
     *
     * @param phoneMob2 the phone mob 2
     */
    public void setPhoneMob2(String phoneMob2) {
        this.phoneMob2 = phoneMob2;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets skype.
     *
     * @return the skype
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Sets skype.
     *
     * @param skype the skype
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }

    /**
     * Gets postcode.
     *
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets postcode.
     *
     * @param postcode the postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets house number.
     *
     * @return the house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets house number.
     *
     * @param houseNumber the house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets flat number.
     *
     * @return the flat number
     */
    public String getFlatNumber() {
        return flatNumber;
    }

    /**
     * Sets flat number.
     *
     * @param flatNumber the flat number
     */
    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
