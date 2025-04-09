package com.gloriane;

/*
 * Step 1: A person who creates or is assigned to a task.
 * This class represents a person with a first name, last name, and email.
 * These are private fields, meaning only this class can access them directly. We use getters and setters to work with them from outside the class.
 */

// Step 1: Create the Person Class
    public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor: This is a constructor — a special method that runs when we create a new person using new Person(...).
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id; // Assign the given id to this person's id
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter methods: These are getter methods, allowing other parts of the program to read the values.
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods: These are setter methods — used to change the values. It also checks if the input is valid.
    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("First Name should not be null or empty");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty())throw new IllegalArgumentException("Last Name should not be null or empty");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(email == null) throw new IllegalArgumentException("Email should not be null");
        this.email = email;
    }

    // Method to Returns the full name of the person by joining first and last name.
    public String getFullName() {
        return firstName + " " + lastName;
    }
}


/*
Your Person class looks well-structured. You have implemented standard OOP practices like encapsulation with private fields, constructors, and getter/setter methods. Additionally, you’ve included validation in the setters for firstName, lastName, and email, which is a great way to ensure data integrity.
Here are a few suggestions for improvement or considerations:
1. toString() method: You might want to override the toString() method to provide a readable string representation of a Person object, which will be useful for debugging or logging.
Example:
@Override
public String toString() {
    return "Person{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "'}";
}

2. equals() and hashCode() methods: If you plan to use Person objects in collections like HashSet or HashMap, overriding equals() and hashCode() would be important for proper object comparison.

Example:
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return id == person.id;
}

@Override
public int hashCode() {
    return Objects.hash(id);
}

3. Improve Date Validation:
In your setDeadline() method, you create a MyDate object with a hardcoded date (2025, 4, 4). For better flexibility, it might be useful to use LocalDate.now() (from java.time) to get the current date dynamically.
public void setDeadline(MyDate deadline) {
    MyDate today = MyDate.fromLocalDate(LocalDate.now());  // Assuming MyDate has a method to convert from LocalDate
    if (deadline.isBefore(today)) throw new IllegalArgumentException("Deadline cannot be in the past");
    this.deadline = deadline;
}

4. JavaDoc comments: It’s always a good practice to add JavaDoc comments to your methods, especially for classes like
Person, which might be reused in different contexts. This will help other developers (or your future self) understand the purpose and usage of the class and methods.
Example:
/**
 * Sets the title of the task.
 * @param title The title to set for the task. Must not be null or empty.
 * @throws IllegalArgumentException if the title is null or empty.

public void setTitle(String title) {
    if (title == null || title.trim().isEmpty()) {
        throw new IllegalArgumentException("Title should not be null or empty");
    }
    this.title = title;
}

5. Null Check for creator:
It might be good to add validation for the creator field in the setCreator() method. You could check if the creator is null to ensure that every task is assigned a valid creator.

Example:
 public void setCreator(Person creator) {
    if (creator == null) throw new IllegalArgumentException("Creator cannot be null");
    this.creator = creator;
}

6. Improvement to getSummary():
The getSummary() method looks good, but you might want to include whether the task is done or not in a more detailed format.

Example:
public String getSummary() {
    return "Task ID: " + id + ", Title: " + title + ", Description: " + taskDescription + ", Due: " + deadline + ", Status: " + (done ? "Completed" : "Pending");
}
These are minor suggestions, and your current implementation already adheres to solid object-oriented principles.
Let me know if you need further help with this!

 Recap:
Validation for lastName and email.

toString() method for easy printing of a Person object.

equals() and hashCode() methods for object comparison and usage in collections.

getFullName() method for combining firstName and lastName.

With these updates, your Person class will be more robust, maintainable, and easier to work with. Let me know if you have any more questions!
 */







