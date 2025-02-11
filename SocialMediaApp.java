import java.util.ArrayList;
class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaNetwork {
    private User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            ArrayList<Integer> mutual = new ArrayList<>(user1.friendIds);
            mutual.retainAll(user2.friendIds);
            System.out.println("Mutual Friends: " + mutual);
        }
    }

    public void searchUser(int userId, String name) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        }
    }

    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();

        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 24);
        network.addUser(3, "Charlie", 23);
        network.addUser(4, "David", 26);

        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(3, 4);

        System.out.println("Displaying Alice's friends:");
        network.displayFriends(1);

        System.out.println("\nMutual friends between Alice and Bob:");
        network.findMutualFriends(1, 2);

        System.out.println("\nSearching for Charlie:");
        network.searchUser(3, "Charlie");

        System.out.println("\nCounting friends of Bob:");
        network.countFriends(2);
    }
}
