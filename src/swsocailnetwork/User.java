package swsocailnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    int Id;
    String Name;
    String Password;
    List<User> Friends;
    List<User> FriendsRequested;  // requests that i sent
    List<User> FriendsRecieved;   // requests that i recived
    List<User> FriendsSent;
    List<Post> TimeLine;
    List<Post> Posts;
    List YourPosts;
    Scanner scanner;
    int credite ;
    
    User(){}

    User(int id, String name, String password) {
        Id = id;
        Name = name;
        Password = password;
        scanner = new Scanner(System.in);

        FriendsRequested = new ArrayList<>();
        FriendsRecieved = new ArrayList<>();
        Friends = new ArrayList<>();
        Friends = new ArrayList<>();
        FriendsSent = new ArrayList<>();
        TimeLine = new ArrayList<>();
        Posts = new ArrayList<>();
        credite = 1000;
    }

    boolean sendRequest(String personName, List<User> all) {
        int personId = -1;
        for (User user : all) {
            System.out.println("his anea " + user.getName());
            if (user.getName().equals(personName)) {
                if (user != null) {
                    this.FriendsRequested.add(user);
                    personId = all.indexOf(user);
                    all.get(personId).FriendsRecieved.add(this);

                    for (int i = 0; i < all.get(personId).FriendsRecieved.size(); i++) {
                        System.out.println("requestion of person = " + all.get(personId).FriendsRecieved.get(i).getName());
                    }
                    return true;
                    //break;
                }
            }
        }
        if (personId == -1) {            
            System.out.println("this person not found");
            return false;
        }
        return false;
    }

    void showRequests(List<User> all) {
        for (User recived : FriendsRecieved) {
            System.out.println(recived.getName());
            /*System.out.println("Enter 1 for accept and 0 for refuse ");
            if (scanner.nextInt() == 1) {

                System.out.println("you accepted the request of " + recived.getName());
                //acceptRequest(temp, all);

            }*/
        }
    }

    void acceptRequest(String personName, List<User> all) {
        int personId = -1;
        for (User user : all) {
            System.out.println("his anea " + user.getName());
            if (user.getName().equals(personName)) {
                personId = all.indexOf(user);
                break;

            }
        }

        this.Friends.add(all.get(personId));
        this.FriendsRecieved.remove(all.get(personId));
        // now i want to remove the request from the sender
        for (User sender : all) {
            if (sender.getId() == personId) {
                sender.FriendsRequested.remove(this);
                sender.Friends.add(this);
            }
        }

    }
    
    
    void upgrade(){
        this.credite -= 99;
        System.out.println("you have now "+this.credite+" $");
    }
    
    void TimeLine(){
        for (User friend : Friends) {            
            for (Post post : friend.Posts) {
                this.TimeLine.add(post);
                System.out.println(post.name);
                System.out.println(post.description);
                System.out.println(post.image);
            }
        }
    }

    void showFriends() {
        for (User friend : this.Friends) {
            if (friend != null) {
                System.out.println(friend.getName());
            }
        }
    }

    void SharePost() {

    }

    String getName() {
        return Name;
    }

    String getPass() {
        return Password;
    }

    int getId() {
        return Id;
    }

}
