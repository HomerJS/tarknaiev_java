package com.tarknaiev.home_4_regex.model;

public enum Field {
    FIRST_NAME("firstName", "first name", "[a-zA-Z]"),
    LAST_NAME("lastName", "last name", "[a-zA-Z]"),
    SECOND_NAME("secondName", "second name", "[a-zA-Z]"),
    NICK_NAME("nickName", "nick", "^[a-zA-Z0-9]+$"),
    COMMENT("comment", "comment", "[^a-zA-Z0-9]"),
    GROUP("group", "group", "^[1-9]+[0-9]*$"),
    PHONE("phone", "phone", "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)"),
    PHONE_MOB("phoneMob", "mobile phone", "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)"),
    PHONE_MOB2("phoneMob2", "mobile phone2 (optional)", "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)"),
    EMAIL("email", "e-mail", "^[\\\\w\\\\-]+(\\\\.[\\\\w\\\\-]+)*@([A-Za-z0-9-]+\\\\.)+[A-Za-z]{2,4}$"),
    SKYPE("skype", "skype", "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}"),
    POSTCODE("postcode", "postcode", "[0-9]\\{5\\}(-[0-9]\\{4\\})?"),
    CITY("city", "city", "[A-Z][a-z]"),
    STREET("street", "street", "[A-Z][a-z]"),
    HOUSE_NUMBER("houseNumber", "house", "^[1-9]+[0-9]*$"),
    FLAT_NUMBER("flatNumber", "flat", "^[1-9]+[0-9]*$"),
    CREATED_AT("createdAt", "created_at", "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{2}|(19|20)\\d{2})$"),
    UPDATED_AT("updatedAt", "updated_at", "^(\\d{1,2})\\/(\\d{1,2})\\/(\\d{2}|(19|20)\\d{2})$");

    private final String fieldName;
    private final String fieldPublicName;
    private final String fieldRegex;

    Field(String fieldName, String fieldPublicName, String fieldRegex) {
        this.fieldName = fieldName;
        this.fieldPublicName = fieldPublicName;
        this.fieldRegex = fieldRegex;
    }
    public String getName() { return fieldName; }
    public String getPublicName() { return fieldPublicName; }
    public String getRegex() { return fieldRegex; }
}
