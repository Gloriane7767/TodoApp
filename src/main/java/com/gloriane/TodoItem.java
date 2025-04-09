package com.gloriane;

/*
 * Step 2: What it represents: A task created by someone.
 * These variables store task details
 */
public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private MyDate deadline;
    private boolean done;
    private Person creator;

    // Constructor: This constructor creates a task.
    public TodoItem(int id, String title, String taskDescription, MyDate deadline, Person creator) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.creator = creator;
        this.done = false; // Initially not done
    }


    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public MyDate getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }

    // Setter methods
    // Makes sure the task deadline is not in the past.
    // Set the task title, ensuring it's not empty or null
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty())  // add ()
            throw new IllegalArgumentException("Title should not be null or empty");
        this.title = title;
    }

    // Set the task deadline, ensuring it's not in the past
    public void setDeadline(MyDate deadline) {
        MyDate today = new MyDate(2025, 4, 4);
        if (deadline.isBefore(today)) throw new IllegalArgumentException("Deadline cannot be in the past");
        this.deadline = deadline;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }
    // Returns a short summary of the task.
    public String getSummary() {
        return "Task ID: " + id + ", Title: " + title + ", Due: " + deadline + ", Done: " + done;
    }
}

/*
Your TodoItem class looks well-structured, but I noticed a small issue in the comment for the setTitle method where it says // add (), which is unnecessary. Otherwise, the class follows good practices for encapsulation and validation.

Here are a few suggestions for improving and enhancing your TodoItem class:

1. Enhance Validation:
While you've already added validation for the title and deadline, it's a good practice to also check for other potential edge cases in the setters. For example:

The taskDescription should not be null or empty.

For the creator, ensure that it's not null, since every task needs a creator.

Example:

java
Copy
Edit
public void setTaskDescription(String taskDescription) {
    if (taskDescription == null || taskDescription.trim().isEmpty()) {
        throw new IllegalArgumentException("Task description should not be null or empty");
    }
    this.taskDescription = taskDescription;
}

public void setCreator(Person creator) {
    if (creator == null) {
        throw new IllegalArgumentException("Creator cannot be null");
    }
    this.creator = creator;
}
2. Override toString() Method:
For easier debugging and logging, consider overriding the toString() method to provide a more readable string representation of the TodoItem.

java

Copy

Edit
@Override
public String toString() {
    return "TodoItem [id=" + id + ", title=" + title + ", deadline=" + deadline + ", done=" + done + ", creator=" + creator.getFullName() + "]";
}
3. Enhance getSummary() Method:
Instead of directly concatenating the fields in getSummary(), you might want to make it more readable and handle done status by returning a more user-friendly string, such as "Completed" or "Pending".

Example:

java

Copy

Edit
public String getSummary() {
    return "Task ID: " + id + ", Title: " + title + ", Due: " + deadline + ", Status: " + (done ? "Completed" : "Pending");
}
4. Add equals() and hashCode() Methods (Optional):
If you need to compare two TodoItem objects or store them in collections like HashSet or HashMap, it might be helpful to override the equals() and hashCode() methods. You can base the equality on the id field to ensure that two tasks with the same id are considered equal.

Example:

java

Copy

Edit
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    TodoItem todoItem = (TodoItem) obj;
    return id == todoItem.id;
}

@Override
public int hashCode() {
    return Integer.hashCode(id);
}

 // Optional: Override equals and hashCode methods for better object comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TodoItem todoItem = (TodoItem) obj;
        return id == todoItem.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
Recap:
Added validation for taskDescription and creator setters.

Enhanced getSummary() method to show the task status (Completed or Pending).

Overridden toString() for better object representation.

Optional equals() and hashCode() methods for object comparison and use in collections.

With these improvements, your TodoItem class is now more robust and maintainable! Let me know if you need further assistance.
 */