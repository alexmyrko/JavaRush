package com.javarush.task.task20.task2002_;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayedName() {
            return this.name;
        }
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())  return false;

        User o = (User) obj;
        if (isMale != o.isMale) return false;
        if (firstName != null ? !firstName.equals(o.firstName) : o.firstName != null)  return false;
        if (lastName != null ? !lastName.equals(o.lastName) : o.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(o.birthDate) : o.birthDate != null) return false;
        return country == o.country;

    }

}