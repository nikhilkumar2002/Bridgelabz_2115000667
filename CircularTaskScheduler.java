class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task currentTask;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeByTaskId(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId && head.next == head) {
            head = null;
            return;
        }
        Task temp = head, prev = null;
        while (temp.taskId != taskId) {
            if (temp.next == head) return;
            prev = temp;
            temp = temp.next;
        }
        if (temp == head) {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        } else {
            prev.next = temp.next;
        }
    }

    public void viewCurrentTask() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + " | Name: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + " | Name: " + temp.taskName + " | Due Date: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class CircularTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtBeginning(1, "Task A", 3, "2025-02-15");
        scheduler.addAtEnd(2, "Task B", 2, "2025-02-16");
        scheduler.addAtEnd(3, "Task C", 1, "2025-02-17");
        scheduler.addAtPosition(2, 4, "Task D", 3, "2025-02-18");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearching for tasks with priority 3:");
        scheduler.searchByPriority(3);

        System.out.println("\nRemoving Task B:");
        scheduler.removeByTaskId(2);
        scheduler.displayTasks();
    }
}
