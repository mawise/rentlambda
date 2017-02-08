package com.rentshape;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;


public class ApplicationData {

    public static Set<String> breakers = new HashSet<>();
    static {
        breakers.add("addr1-street");
        breakers.add("addr2-street");
        breakers.add("addr3-street");
        breakers.add("occupants");
        breakers.add("emp1-name");
        breakers.add("emp2-name");
        breakers.add("bankName");
        breakers.add("debt1-creditor");
        breakers.add("debt2-creditor");
        breakers.add("debt3-creditor");
        breakers.add("emergency1-name");
        breakers.add("reference1-name");
        breakers.add("car1-make");
        breakers.add("bankruptcy");
    }

    public static Map<String, String> fields = new LinkedHashMap<>();
    static {
        fields.put("lastName", "Last Name");
        fields.put("firstName", "First Name");
        fields.put("middleName", "Middle Name");
        fields.put("ssn", "Social Security Number");
        fields.put("otherNames", "Other names used");
        fields.put("homePhone", "Home phone number");
        fields.put("cellPhone", "Cell phone number");
        fields.put("workPhone", "Work phone number");
        fields.put("dob", "Date of birth");
        fields.put("email", "E-mail address");
        fields.put("idType", "Photo ID type");
        fields.put("idNumber", "Photo ID number");
        fields.put("idIssuer", "Issuing government");
        fields.put("idExp", "Exp. date");

        fields.put("addr1-street", "Present address");
        fields.put("addr1-city", "City");
        fields.put("addr1-state", "State");
        fields.put("addr1-zip", "Zip");
        fields.put("addr1-in", "Date in");
        fields.put("addr1-out", "Date out");
        fields.put("addr1-landlord", "Owner/Agent Name");
        fields.put("addr1-phone", "Owner/Agent Phone number");
        fields.put("addr1-reason", "Reason for moving out");
        fields.put("addr1-rent", "Current rent");

        fields.put("addr2-street", "Previous address");
        fields.put("addr2-city", "City");
        fields.put("addr2-state", "State");
        fields.put("addr2-zip", "Zip");
        fields.put("addr2-in", "Date in");
        fields.put("addr2-out", "Date out");
        fields.put("addr2-landlord", "Owner/Agent Name");
        fields.put("addr2-phone", "Owner/Agent Phone number");
        fields.put("addr2-reason", "Reason for moving out");

        fields.put("addr3-street", "Next previous address");
        fields.put("addr3-city", "City");
        fields.put("addr3-state", "State");
        fields.put("addr3-zip", "Zip");
        fields.put("addr3-in", "Date in");
        fields.put("addr3-out", "Date out");
        fields.put("addr3-landlord", "Owner/Agent Name");
        fields.put("addr3-phone", "Owner/Agent Phone number");
        fields.put("addr3-reason", "Reason for moving out");

        fields.put("occupants", "List proposed occupants");
        fields.put("pets", "Do you have pets?");
        fields.put("describePets", "Describe pets");
        fields.put("waterbed", "Do you have a waterbed?");
        fields.put("describeWaterbed", "Describe waterbed");
        fields.put("hearAbout", "How did you hear about this rental?");

        fields.put("emp1-name", "Current Employer Name");
        fields.put("emp1-title", "Job Title or Position");
        fields.put("emp1-dates", "Dates of Employment");
        fields.put("emp1-address", "Employer address");
        fields.put("emp1-cityStateZip", "City, State, Zip");
        fields.put("emp1-phone", "Employer/HR phone number");
        fields.put("emp1-supervisor", "Name of your supervisor/HR manager");
        fields.put("emp1-income", "Current gross income");

        fields.put("emp2-name", "Prior Employer Name");
        fields.put("emp2-title", "Job Title or Position");
        fields.put("emp2-dates", "Dates of Employment");
        fields.put("emp2-address", "Employer address");
        fields.put("emp2-cityStateZip", "City, State, Zip");
        fields.put("emp2-phone", "Employer/HR phone number");
        fields.put("emp2-supervisor", "Name of your supervisor/HR manager");

        fields.put("otherIncome", "Other Income");

        fields.put("bankName", "Name of your bank");
        fields.put("bankBranch", "Branch or address");
        fields.put("bankAccountNumber", "Account Number");

        fields.put("debt1-creditor", "Name of Creditor");
        fields.put("debt1-address", "Address");
        fields.put("debt1-phone", "Phone Number");
        fields.put("debt1-payment", "Monthly Payment Amount");

        fields.put("debt2-creditor", "Name of Creditor");
        fields.put("debt2-address", "Address");
        fields.put("debt2-phone", "Phone Number");
        fields.put("debt2-payment", "Monthly Payment Amount");

        fields.put("debt3-creditor", "Name of Creditor");
        fields.put("debt3-address", "Address");
        fields.put("debt3-phone", "Phone Number");
        fields.put("debt3-payment", "Monthly Payment Amount");

        fields.put("emergency1-name", "Emergency Contact Name");
        fields.put("emergency1-address", "Address: Street, City, State, Zip");
        fields.put("emergency1-relation", "Relationship");
        fields.put("emergency1-phone", "Phone");

        fields.put("emergency2-name", "Second Emergency Contact Name");
        fields.put("emergency2-address", "Address: Street, City, State, Zip");
        fields.put("emergency2-relation", "Relationship");
        fields.put("emergency2-phone", "Phone");

        fields.put("reference1-name", "Personal Reference Name");
        fields.put("reference1-address", "Address: Street, City, State, Zip");
        fields.put("reference1-length", "Length of Acquaintance");
        fields.put("reference1-occupation", "Occupation");
        fields.put("reference1-phone", "Phone");

        fields.put("reference2-name", "Second Personal Reference Name");
        fields.put("reference2-address", "Address: Street, City, State, Zip");
        fields.put("reference2-length", "Length of Acquaintance");
        fields.put("reference2-occupation", "Occupation");
        fields.put("reference2-phone", "Phone");

        fields.put("car1-make", "Make");
        fields.put("car1-model", "Model");
        fields.put("car1-year", "Year");
        fields.put("car1-plates", "License Number");

        fields.put("car2-make", "Make");
        fields.put("car2-model", "Model");
        fields.put("car2-year", "Year");
        fields.put("car2-plates", "License Number");

        fields.put("bankruptcy", "Have you ever filed for bankruptcy?");
        fields.put("evicted", "Have you ever been evicted or asked to move?");
        fields.put("drugs", "Have you ever been convicted of selling, distributing, or manufacturing illegal drugs?");
    }



    public static String UUID = "uuid";
    static ObjectMapper mapper = new ObjectMapper();

    private Map<String, String> data;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void newUuid(){
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    public ApplicationData(){
        data = new HashMap<>();
    }

    private ApplicationData(Map<String, String> data){
        this.data = data;
    }

    public void put(String field, String value){
        if (fields.keySet().contains(field)){
            data.put(field, value);
        }
    }

    public String get(String field){
        if (fields.keySet().contains(field)){
            return data.get(field);
        } else {
            return null;
        }
    }

    public String toJson(){
        try {
            if (null != uuid){
                data.put(UUID, uuid);
            }
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    public Item toItem(){
        Item item = new Item().withPrimaryKey(UUID, uuid);
        for (String field : fields.keySet()){
            if (data.containsKey(field)){
                String value = data.get(field);
                if (null != value && !"".equals(value)) {
                    item = item.withString(field, data.get(field));
                }
            }
        }
        return item;
    }

    public static ApplicationData fromJson(String json){
        try {
            Map<String, String> newData = mapper.readValue(
                    json, new TypeReference<HashMap<String, String>>() {});
            ApplicationData newApp = new ApplicationData(newData);
            if (newData.containsKey(UUID)) {
                newApp.setUuid(newData.get(UUID));
            }
            return newApp;
        } catch (IOException e) {
            return new ApplicationData();
        }
    }
}
