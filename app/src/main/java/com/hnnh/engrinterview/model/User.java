package com.hnnh.engrinterview.model;

import java.io.Serializable;

public class User implements Serializable{
    String firstName;
    String lastName;
    String favFoodName;
    int favNumber;

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

    public String getFavFoodName() {
        return favFoodName;
    }

    public void setFavFoodName(String favFoodName) {
        this.favFoodName = favFoodName;
    }

    public int getFavNumber() {
        return favNumber;
    }

    public void setFavNumber(int favNumber) {
        this.favNumber = favNumber;
    }

}
