package com.codeinbp.hr.model;

public class Hire {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String serialNumber;
    private String hireDate;
    private String contractType;
    private String photo;


    public Hire() {

    }

    public Hire(int id, String firstName, String lastName, String email, String serialNumber, String hireDate, String contractType, String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.serialNumber = serialNumber;
        this.hireDate = hireDate;
        this.contractType = contractType;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Hire{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", contractType='" + contractType + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


}
