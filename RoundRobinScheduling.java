import java.util.Scanner;
class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        Process current = head, prev = tail;
        do {
            if (current.processId == processId) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                prev.next = current.next;
                if (head == tail && head.processId == processId) head = tail = null;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void executeProcesses() {
        if (head == null) return;
        Process current = head;
        int timeElapsed = 0;
        while (head != null) {
            if (current.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, current.burstTime);
                current.burstTime -= executionTime;
                timeElapsed += executionTime;
                System.out.println("Executing Process ID: " + current.processId + " for " + executionTime + " units.");
                if (current.burstTime == 0) {
                    System.out.println("Process ID: " + current.processId + " completed.");
                    removeProcess(current.processId);
                }
            }
            current = current.next;
            if (head == null) break;
        }
        System.out.println("All processes executed. Total time: " + timeElapsed + " units.");
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Processes in Queue:");
        scheduler.displayProcesses();

        System.out.println("\nExecuting Round Robin Scheduling:");
        scheduler.executeProcesses();
    }
}
