package swsocailnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWSocailNetwork {

    static List<User> AllUsers;
    static int id = 0;
    static int CurrentUserId = -1;

    public SWSocailNetwork() {
        AllUsers = new ArrayList<>();
        
        User hassan =new User(0, "hassan", "221");
        hassan.Posts.add(new Post("post1", "hello my first post", ""));
        hassan.Posts.add(new Post("post2", "hello my second post", ""));
        
        User mo =new User(0, "mo", "332");
        mo.Posts.add(new Post("moPost", "hello my first post", ""));
        mo.Posts.add(new Post("moPost2", "happy year", ""));
        
        
        AllUsers.add(hassan);
        AllUsers.add(mo);

    }
    
    
    
    
    public static boolean signUp(String s1 ,String s2){
        System.out.println(" entered 77 ");
        if(AllUsers!=null){
            System.out.println(" entered 0 ");
            for(User user: AllUsers){               
                System.out.println("enteredd 1 ");
                if(user.getName().equals(s1) && user.getPass().equals(s2)){
                    System.out.println("enteredl 2 ");
                    return false;
                    
                }
            }
            
        }
        return true;
    }
    
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        SWSocailNetwork sa = new SWSocailNetwork();
        /*AllUsers = new ArrayList<User>();

        User hassan =new User(0, "hassan", "221");
        hassan.Posts.add(new Post("post1", "hello my first post", ""));
        hassan.Posts.add(new Post("post2", "hello my second post", ""));
        
        User mo =new User(0, "mo", "332");
        mo.Posts.add(new Post("moPost", "hello my first post", ""));
        mo.Posts.add(new Post("moPost2", "happy year", ""));
        
        
        AllUsers.add(hassan);
        AllUsers.add(mo);
*/
        String name;
        String pass;

        String log = "countinue";
        while (!log.equalsIgnoreCase("break")) {

            System.out.println("for Sign Up/In enter 1 or 2 ");
            int input = scanner.nextInt();

            if (input == 1) {
                System.out.println("Enter your name ");
                name = scanner2.nextLine();
                System.out.println("Enter your password");
                pass = scanner2.nextLine();
                System.out.println("signUp(name,pass) + "+signUp(name,pass));
                if(signUp(name,pass)==true){
                    AllUsers.add(new User(CurrentUserId, name, pass));
                    CurrentUserId = AllUsers.size() - 1;
                }else{
                    System.out.println("this account already exist");
                }

            } else if (input == 2) {
                System.out.println("Enter your name ");
                name = scanner2.nextLine();
                System.out.println("Enter your Pass ");
                pass = scanner2.nextLine();

                for (User AllUser : AllUsers) {
                    if (AllUser.getName().equals(name) && AllUser.getPass().equals(pass)) {
                        System.out.println("successful registration");
                        //CurrentUserId = AllUser.getId();
                        CurrentUserId = AllUsers.indexOf(AllUser);
                        break;
                    } else {
                        System.out.println("your name or pass is incorrect");
                        CurrentUserId =-1;
                    }
                }
            }
            int input2 = 0;
            do {
                if (CurrentUserId != -1) {

                    System.out.println("you can");
                    System.out.println("    1- send Request \n    2- show requestions \n    3-show friends  "
                            + "\n    4-accept request \n    5-upgrade registration "
                            + "\n    6-TimeLine  \n    0- finish ");
                    input2 = scanner.nextInt();
                    if (input2 == 1) {
                        System.out.println("Enter the name of your friend");
                       boolean send = AllUsers.get(CurrentUserId).sendRequest(scanner2.nextLine(), AllUsers);
                        System.out.println(">>>>>>>>>>>>>>>> "+send);
                    } else if (input2 == 2) {
                        System.out.println("this is freinds requests");
                        AllUsers.get(CurrentUserId).showRequests(AllUsers);
                    }else if(input2==3){
                        System.out.println("number of friends "+AllUsers.get(CurrentUserId).Friends.size());
                        AllUsers.get(CurrentUserId).showFriends();
                    }else if(input2==4){
                        System.out.println("Enter request name to accept");                        
                        AllUsers.get(CurrentUserId).acceptRequest(scanner2.nextLine(), AllUsers);
                    }else if(input2==5){                        
                        AllUsers.get(CurrentUserId).upgrade();
                    }else if(input2==6){                        
                        AllUsers.get(CurrentUserId).TimeLine();
                    }

                }
            } while (input2 != 0);
            System.out.println("Enter break to finish");
            log = scanner2.nextLine();
        }

    }
}
