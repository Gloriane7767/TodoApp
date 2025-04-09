package com.gloriane;

// File: AppRole.java
/*
 * Step 4: Create the AppRole Enum
 * This enum represents the roles a user can have in the TodoApp.
 */
public enum AppRole {
    ADMIN,
    USER;

    @Override
    public String toString() {
        return "Role: " + name();  // Override toString to return custom role name
    }
}

/*
Explanation: For enum, toString() is automatically provided, but we override it to format the role nicely (like Role: ADMIN). equals() and hashCode() are implicitly handled for enums since they are unique by design.
Summary

1. An AppUser represents a system user with an ID, username, password, and role.
2. The constructor initializes user details.
3. Getters provide access to private fields.
4. Setters allow modifying user details.
5. equals() and hashCode() help compare users and store them in collections.
6. toString() makes printing easier.
7. The AppRole enum defines ADMIN and USER roles, keeping roles fixed and easy to use.
*/
