class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeByItemId(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchItem(int itemId, String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item: " + temp.itemName + " | ID: " + temp.itemId + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void displayItems() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + " | ID: " + temp.itemId + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        inventory.addAtBeginning("Laptop", 101, 5, 50000);
        inventory.addAtEnd("Mouse", 102, 10, 500);
        inventory.addAtEnd("Keyboard", 103, 7, 1500);
        inventory.addAtPosition(2, "Monitor", 104, 3, 10000);

        System.out.println("All Items:");
        inventory.displayItems();

        System.out.println("\nUpdating Quantity for Mouse:");
        inventory.updateQuantity(102, 15);
        inventory.displayItems();

        System.out.println("\nSearching for Item by ID 103:");
        inventory.searchItem(103, "");

        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nRemoving Item Keyboard:");
        inventory.removeByItemId(103);
        inventory.displayItems();
    }
}
