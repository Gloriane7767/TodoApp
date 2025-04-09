package com.gloriane;

import java.util.Scanner;

// What it represents: The main program that the user runs.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TodoItemTask currentTask = null; // We’re declaring a variable called currentTask. Right now, it points to nothing

    public static void main(String[] args) {
        // Create users with roles
        AppUser user1 = new AppUser("gloriane", "pass123", AppRole.ADMIN);
        AppUser user2 = new AppUser("james", "password", AppRole.USER);
        AppUser user3 = new AppUser("gloriane", "pass123", AppRole.ADMIN); // Same as user1

        // Print user details (calls toString method)
        user1.printUserDetails();
        user2.printUserDetails();

        // Compare users using equals method
        System.out.println("\nComparing user1 and user3: " + user1.equals(user3)); // true
        System.out.println("Comparing user1 and user2: " + user1.equals(user2)); // false

        // Comparing hashCodes
        System.out.println("user1 hashCode: " + user1.hashCode());
        System.out.println("user3 hashCode: " + user3.hashCode()); // Same hashCode as user1

        // Inside createTask(...) → Filling the box

            Person creator = new Person(1, "Gloriane", "Foncha", "gloriane@example.com");

            while (true) {
                System.out.println("\n--- Task Manager ---");
                System.out.println("1. Create a Task");
                System.out.println("2. Assign a Task");
                System.out.println("3. View Task Details");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }

                switch (choice) {
                    case 1:
                        createTask(creator);
                        break;
                    case 2:
                        assignTask();
                        break;
                    case 3:
                        viewTaskDetails();
                        break;
                    case 4:
                        System.out.println("Exiting the app.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        // Method to create a new task
        // Step A: Get user input. We are asking the user for the following

        private static void createTask (Person creator){
            System.out.println("\n--- Create Task ---"); // Display a heading to tell the user we're creating a task

            System.out.print("Enter task title: "); // Ask the user to type the title
            String title = scanner.nextLine(); // Read the title entered by the user

            System.out.print("Enter task description: "); // Ask for a short description of the task
            String description = scanner.nextLine(); // Read the description

            System.out.print("Enter task deadline (day): "); // Ask user to enter a date in parts
            int day = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter task deadline (month): ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter task deadline (year): ");
            int year = Integer.parseInt(scanner.nextLine());

            // Create a MyDate object using the entered day, month, and year
            MyDate deadline = new MyDate(day, month, year);

            // Create a TodoItem (task) using the provided info
            TodoItem todoItem = new TodoItem(1, title, description, deadline, creator); // Now we create a TodoItem using the data we just gathered.

            // Use the TodoItem to create a TodoItemTask object, and store it in currentTask
            // The third argument is null because no one is assigned yet
            currentTask = new TodoItemTask(1, todoItem, null);
            System.out.println("✅ Task created successfully!"); // Let the user know the task was created
        }

        // Assign task to someone
        // Method to assign a task to a person
        private static void assignTask() {
            // Check if a task has been created yet
            if (currentTask == null) {
                System.out.println("No task available to assign. Please create a task");
            }

            System.out.print("Enter assignee name: "); // Ask for first name
            String firstName = scanner.nextLine(); // Read first name

            System.out.print("Enter assignee last name: "); // Ask for last name
            String lastName = scanner.nextLine(); // Read last name

            System.out.print("Enter assignee email: "); // Ask for email
            String email = scanner.nextLine(); // Read email

            // Create a new Person object using the assignee’s details
            Person assignee = new Person(2, firstName, lastName, email); //  We create a new Person who will be assigned the task.

            // Set the new person as the assignee of the current task
            currentTask.setAssignee(assignee); //  Boom! We set the assignee inside the currentTask

            // Display the name of the person the task was assigned to
            System.out.println("✅ Task assigned to " + assignee.getFullName());
        }

        // View task info
        // This method shows the details of the current task to the user
        private static void viewTaskDetails() {

            // First, we check if a task has been created
            // If currentTask is still null, that means no task exists yet
            if (currentTask == null) {
                System.out.println("No task created yet."); // Tell the user
                return; // Stop the method here
            }

            // If a task exists, we now display its details
            System.out.println("\n--- Task Details ---"); // Heading for clarity

            // Show the task's ID by calling currentTask.getId()
            System.out.println("Task ID: " + currentTask.getId());

            // Show the title of the TodoItem inside currentTask
            System.out.println("Title: " + currentTask.getTodoItem().getTitle());

            // Show the description of the task
            System.out.println("Description: " + currentTask.getTodoItem().getTaskDescription());

            // Show the deadline of the task. We use .toString() to make it readable
            System.out.println("Deadline: " + currentTask.getTodoItem().getDeadline().toString());

            // Check if the task is marked as done. If yes, show "Yes", else show "No"
            System.out.println("Done: " + (currentTask.getTodoItem().isDone() ? "Yes" : "No"));

            // Check if someone has been assigned to the task
            if (currentTask.isAssigned()) {
                // If yes, print their full name using getAssignee().getFullName()
                System.out.println("Assigned to: " + currentTask.getAssignee().getFullName());
            } else {
                // If no one is assigned, tell the user that
                System.out.println("Not yet assigned.");
            }
        }
    }


/*
This declares a variable called currentTask.
It is of type TodoItemTask, which is a class you created to wrap a to-do item and its assignee.
Initially, it is set to null, which means there is no task yet.
Later, when the user creates a task, we will store it in this variable so the app can track it.

Here, you are creating a new Person object.
This person is the creator of the task — you’re pretending it’s Gloriane.
You’re passing id, firstName, lastName, and email to the Person class constructor.

This starts an infinite loop. The menu will keep showing again and again until the user chooses to exit.
Inside this loop is where the user chooses what they want to do.

This block prints the main menu options for the user to choose from.
You're asking the user to enter a number (1 to 4).
scanner.nextLine() reads the input as a string.
Integer.parseInt(...) converts that string to an integer.
If the user enters something that’s not a number, the try-catch block handles the error and shows a friendly message.

A switch statement checks what number the user chose (1–4).
Based on that, it will run a specific part of the code.

If the user picks option 1, the program runs createTask(...) and passes the creator (Gloriane) to it.
That method will create a new task and assign it to the currentTask variable.

Option 2 runs the assignTask() method.
It assigns a person to the currentTask (if one has been created).

Option 3 calls viewTaskDetails() to print the details of the current task.

Option 4 prints an exit message and stops the program using return.

If the user types anything other than 1–4, they get an error message.
 */

/*
Your Main class is looking good and serves as a simple command-line interface (CLI) for task management. The flow of operations for creating, assigning, and viewing tasks is logical and easy to follow. You’ve also effectively utilized methods to keep the code modular and organized. Here are a few suggestions to further improve your code:

1. Handle Task Creation and ID Assignment More Dynamically:
Right now, you're hardcoding the task ID as 1 when creating a new TodoItem and TodoItemTask. This can be problematic because each task will have the same ID. Instead, you could use a counter or generate IDs dynamically to ensure each task has a unique ID.

For example, you could add a static idCounter in your Main class to keep track of task IDs:
 private static int taskIdCounter = 1;  // Start with ID 1

private static TodoItem createTaskObject(String title, String description, MyDate deadline, Person creator) {
    TodoItem todoItem = new TodoItem(taskIdCounter++, title, description, deadline, creator);
    return todoItem;

    This way, each task will get a unique ID.

2. Improve viewTaskDetails Method:
The method is doing great in terms of showing task details. However, it would be more useful if you also showed the
task's status (whether it's completed or not).

You could enhance the output by including something like:
System.out.println("Status: " + (currentTask.getTodoItem().isDone() ? "Completed" : "Pending"));

3. Handle MyDate Object More Robustly:
Currently, you’re using MyDate to store the deadline, which seems to be a custom class. Ensure that the MyDate class has proper validation in place for the date format (e.g., month should be between 1 and 12, day should
be valid for that month). If you're using MyDate for comparison in setDeadline(), it’s also important to ensure that it implements equals() and hashCode() properly if you plan to store or compare MyDate objects in collections.

4. Validation on Input Fields:
While you’re doing well in taking user input, you might want to add some input validation to prevent invalid or empty values. For example, ensure that the user doesn't input an empty task title or description:
if (title == null || title.trim().isEmpty()) {
    System.out.println("Title cannot be empty.");
    return;

    5. Enhance User Feedback:
When creating or assigning a task, you could improve user interaction by confirming the success of the action with more detailed feedback:

System.out.println("Task Created: " + todoItem.getTitle() + " (Deadline: " + deadline + ")");
This will give the user more detailed feedback immediately after the action.

6. Consider Using List<TodoItemTask> for Multiple Tasks:
Right now, you're only dealing with a single task using the currentTask variable. It might be useful to store multiple tasks in a collection (like a List<TodoItemTask>) so that users can create and manage multiple tasks instead of just one.

For example, add a list to hold all tasks:

private static List<TodoItemTask> tasks = new ArrayList<>();
Then, you can modify the createTask method to add new tasks to the list:
tasks.add(currentTask);
7. Refactor Main to Support Multiple Tasks:
If you want to handle multiple tasks, modify the viewTaskDetails() and assignTask() methods to allow selecting a task from the list.

Example for viewTaskDetails():

private static void viewTaskDetails() {
    if (tasks.isEmpty()) {
        System.out.println("No tasks created yet.");
        return;
    }

    System.out.print("Enter task ID to view details: ");
    int taskId = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    TodoItemTask task = findTaskById(taskId);
    if (task == null) {
        System.out.println("Task with ID " + taskId + " not found.");
    } else {
        System.out.println("Task Details: " + task.getTodoItem().getTitle());
    }
}

private static TodoItemTask findTaskById(int taskId) {
    for (TodoItemTask task : tasks) {
        if (task.getId() == taskId) {
            return task;
        }
    }
    return null;
}
8. Option to Exit Gracefully:
Consider adding a confirmation step before exiting the app to prevent accidental exits:

System.out.print("Are you sure you want to exit? (y/n): ");
String confirm = scanner.nextLine();
if ("y".equalsIgnoreCase(confirm)) {
    System.out.println("Exiting the app.");
    return;
}
Final Thoughts:
These enhancements will help make your task manager more flexible, user-friendly, and maintainable. Your current code structure is solid, and these suggestions will add more functionality and polish to the application. Let me know if you need help implementing any of these improvements!
}
 */
/*
Breakdown of the Methods:
createTask(Person creator):

This method asks for the title, description, and deadline of a task. It then creates a new TodoItem with the provided information and a TodoItemTask instance that gets stored in the currentTask variable.

assignTask(Person creator):

This method allows you to assign an assignee to the task. If no task has been created yet (currentTask == null), it displays a message and returns. Otherwise, it asks for the assignee's name and email, creates a new Person instance for the assignee, and assigns them to the task.

viewTaskDetails():

This method displays details of the currently created task, such as task ID, title, description, deadline, and whether the task is assigned.

Additional Notes:
Scanner Handling: Since scanner.nextInt() leaves a newline character in the input buffer, we consume it using scanner.nextLine() after reading integers.

Checking if Task Exists: Before attempting to assign a task or view its details, we ensure that a task exists by checking if currentTask is null.

This should now work correctly with the rest of your classes! Let me know if you need further adjustments.
 */