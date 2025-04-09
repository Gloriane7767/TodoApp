package com.gloriane;

public class TodoItemTask {
    private int id;
    private TodoItem todoItem;
    private Person assignee;

    // Constructor
    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    // Setter methods
    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    // Tells whether this task has been assigned yet.
    public boolean isAssigned() {
        return assignee != null;
    }

    public String getDeadlineString() {
        return todoItem.getDeadline().toString(); // Get deadline as text
    }

}

/*
💡 What class is this in?
This method is inside the TodoItemTask class — which represents a task that has been assigned to someone.

🧱 Let's break it down part by part:
🔹 public String getDeadlineString()
public: Means this method can be used outside the class.

String: This method will return a text value (not a number or object).

getDeadlineString(): The name of the method. It's like saying: “Hey! Give me the deadline in a string (text) format.”

🔹 return todoItem.getDeadline().toString();
This is one line doing three things, step by step:

todoItem
This is a variable inside the TodoItemTask class.
It holds the actual task (an object of type TodoItem).

getDeadline()
This is a method from the TodoItem class.
It gives us the deadline of the task, which is an object of type MyDate.

.toString()
This is a method from the MyDate class.
It turns the date (e.g., 5, 4, 2025) into a readable string like "5/4/2025".

🎯 So, what does the full line do?
It asks the TodoItem for its deadline, and

Then asks the deadline to convert itself into a text string, and

Returns that string.

🧠 Imagine this in real life:
Let’s say the todoItem is like a file folder for a task.

You open the folder → (todoItem)

You look for the deadline inside → (getDeadline())

You write it down neatly → (toString())


 */
/*
It looks like you’re working on the logic for creating tasks, assigning them, and viewing task details. However, I noticed a couple of issues in your code that need to be fixed:

1. Access Modifiers:
In the code you provided, private static TodoItemTask currentTask = null; and other methods are outside the class. This will result in a syntax error. You need to ensure that these methods and variables are inside a valid class, such as your Main class.

2. TodoItemTask Missing Import:
Since you are using TodoItemTask in your code, make sure that TodoItemTask is either imported or defined within the same package. If TodoItemTask is in another file, make sure the class is correctly imported.

3. Method for getDeadlineString() Missing:
In your code, you are calling getDeadlineString() on a TodoItem object, but TodoItem doesn't have a method named getDeadlineString(). You should implement this method in TodoItem to return a string representation of the deadline.

4. setAssignee() Method Missing in TodoItemTask:
Your code references currentTask.setAssignee(assignee), but the TodoItemTask class doesn't include this method. You will need to define the setAssignee() method in TodoItemTask.

5. Minor Code Formatting:
You should ensure consistent formatting for readability and correctness.

Here’s how you could fix and improve the code:

Required Additions
TodoItem class - Add getDeadlineString() method:
java

Copy

Edit
public class TodoItem {
    // existing fields and methods...

    // Method to return the deadline as a string
    public String getDeadlineString() {
        return deadline.toString();  // assuming MyDate class has a valid toString method
    }
}
TodoItemTask class - Add setAssignee() method:
java

Copy

Edit
public class TodoItemTask {
    private int id;
    private TodoItem todoItem;
    private Person assignee;

    // Constructor, getters, and other methods...

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public Person getAssignee() {
        return assignee;
    }

    public boolean isAssigned() {
        return assignee != null;
    }

    // Getters and other methods...
}
Recap of Changes:
Added getDeadlineString() method in the TodoItem class.

Added setAssignee() method in the TodoItemTask class.

Ensured currentTask and methods are inside the Main class.

Let me know if you'd like further assistance!
 */