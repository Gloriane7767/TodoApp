package com.gloriane;

import java.util.Objects; // Importing the Objects class

public class AppUser {
    private String username;
    private String password;
    private AppRole role; // Now role is an enum

    // Constructor to create a new user with a role
    public AppUser(String username, String password, AppRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Getter for role
    public AppRole getRole() {
        return role;
    }

    // Setter for role (if we want to change user’s role later)
    public void setRole(AppRole role) {
        this.role = role;
    }

    // Display user info
    /*public void printUserDetails() {
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
        System.out.println("Moderator: " + role);// Will print ADMIN, USER, etc.
        */

    // Overriding equals method to check equality based on username, password, and role
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check if the references are the same (optimization)
        if (o == null || getClass() != o.getClass()) return false; // Check if the object is null or not the same class
        AppUser appUser = (AppUser) o; // Cast object to AppUser
        return Objects.equals(username, appUser.username) &&
                Objects.equals(password, appUser.password) &&
                role == appUser.role; // Check if username, password, and role are the same
    }

    // Overriding hashCode to return a unique integer based on username, password, and role
    @Override
    public int hashCode() {
        return Objects.hash(username, password, role); // Generates a hash code based on these fields
    }

    // Overriding toString to provide a meaningful string representation of the object
    @Override
    public String toString() {
        return "AppUser{username='" + username + "', role=" + role + '}';
    }

    // Display user info
    public void printUserDetails() {
        System.out.println(this.toString()); // Calls the overridden toString method
    }
    }


