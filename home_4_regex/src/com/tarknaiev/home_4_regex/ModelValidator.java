package com.tarknaiev.home_4_regex;

import java.util.Arrays;

public class ModelValidator {
    public static final String[] fieldNameList = {
            "firstName",
            "lastName",
            "secondName",
            "nickName",
            "comment",
            "group",
            "phone",
            "phoneMob",
            "phoneMob2",
            "email",
            "skype",
            "postcode",
            "city",
            "street",
            "houseNumber",
            "flatNumber",
            "createdAt",
            "updatedAt"
    };

    public static final String[] fieldPublicNameList = {
            "first name",
            "last name",
            "second name",
            "nick",
            "comment",
            "group",
            "phone",
            "mobile phone",
            "mobile phone2 (optional)",
            "email",
            "skype",
            "postcode",
            "city",
            "street",
            "house",
            "flat",
            "created at",
            "updated at"
    };

    public static final String[] fieldRegexList = {
            "[a-zA-Z]", //first name
            "[a-zA-Z]", //last name
            "[a-zA-Z]", //second name
            "[^a-zA-Z0-9]", //nick
            "[^a-zA-Z0-9]", //comment
            "^[1-9]+[0-9]*$", //group
            "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)", //phone
            "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)", //mobile phone
            "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)", //mobile phone
            "^[\\\\w\\\\-]+(\\\\.[\\\\w\\\\-]+)*@([A-Za-z0-9-]+\\\\.)+[A-Za-z]{2,4}$", //email
            "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}", //skype
            "[0-9]\\{5\\}(-[0-9]\\{4\\})?", //postcode
            "[A-Z][A-Z]", //city
            "[A-Z][A-Z]", //street
            "^[1-9]+[0-9]*$", //house
            "^[1-9]+[0-9]*$", //flat
            "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{2}|(19|20)\\d{2})$", //created at
            "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{2}|(19|20)\\d{2})$" //updated at
    };


    private String fieldName;
    private String publicName;
    private String regex;

    /**
     * Constructor
     *
     * @param fieldName
     */
    ModelValidator(String fieldName) {
        int fieldIndex = Arrays.asList(ModelValidator.fieldNameList).indexOf(fieldName);
        this.publicName = ModelValidator.fieldPublicNameList[fieldIndex];
        this.fieldName = fieldName;
        this.regex = ModelValidator.fieldRegexList[fieldIndex];
    }

    /**
     * Generate object data for testing
     *
     * @override
     * @return String
     */
    public String toString(){
        return "field name: "+ this.getFieldName() + "\n"
                + "public name: "+ this.getPublicName() + "\n"
                + "regex: "+ this.getRegex() + "\n";
    }

    /**
     * @return String
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * @return String
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return String
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * @param publicName
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }
}
