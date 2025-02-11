import java.util.Scanner;
class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int maxHistory;
    private int historySize;

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.historySize = 0;
        this.current = new TextState("");
    }

    public void type(String newText) {
        TextState newState = new TextState(current.content + newText);
        newState.prev = current;
        current.next = newState;
        current = newState;
        historySize++;

        if (historySize > maxHistory) {
            trimHistory();
        }
    }

    private void trimHistory() {
        TextState temp = current;
        while (historySize > maxHistory && temp.prev != null) {
            temp = temp.prev;
            historySize--;
        }
        temp.prev = null;
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void displayCurrentState() {
        System.out.println("Current State: " + current.content);
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor(10);

        while (true) {
            System.out.println("\n1. Type text\n2. Undo\n3. Redo\n4. Display current state\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    editor.type(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}