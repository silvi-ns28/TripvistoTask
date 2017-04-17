/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import twitter.dao.Tweet;
import twitter.dao.User;

/**
 *
 * @author Silviana
 */
public class MainClass {
    private List<Tweet> timeline = new ArrayList<>();
    private User user1;
    private User user2;
    private User user3;

    public MainClass() {
        user1 = new User(1, "User1", "Brian");
        user2 = new User(2, "User2", "Reina");
        user3 = new User(3, "User3", "Gerald");
        
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        DateFormat hour = new SimpleDateFormat("HH");
//        Date date = new Date();
//        System.out.println(dateFormat.format(date));
//        System.out.println(hour.format(date));
        
        Tweet tweet1u1 = new Tweet(1, "So hot today! ~Fiuhh", user1, null);
        Tweet tweet2u3 = new Tweet(2, "I really need holiday :(", user3, null);
        Tweet tweet3u2 = new Tweet(3, "Just got a new puppy, he is sooo cute ^^", user2, null);
        timeline.add(tweet2u3);
        timeline.add(tweet1u1);
        timeline.add(tweet3u2);
    }

    public void setFollowingUser() {
        List<User> following = new ArrayList<>();
        //following user1
//        following.add(user2);
        following.add(user3);
        user1.setFollowing(following);
        //following user2
        following = new ArrayList<>();
        following.add(user1);
        following.add(user3);
        user2.setFollowing(following);
        //following user3
        following = new ArrayList<>();
        following.add(user1);
        following.add(user2);
        user3.setFollowing(following);
    }
    
    public List<Tweet> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Tweet> timeline) {
        this.timeline = timeline;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public User getUser3() {
        return user3;
    }
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MainClass main = new MainClass();
        main.setFollowingUser();
        
        List<Tweet> timelineMain = main.getTimeline();
        int input = 0;
        int idTweet = 4;
        User currentUser = main.getUser1();
        List<User> followingUser = currentUser.getFollowing();
        
        List<Tweet> listTweet = new ArrayList<>();
        for (int i = 0; i < followingUser.size(); i++) {
            User user = followingUser.get(i);

            for (int j = 0; j < timelineMain.size(); j++) {
                User tweetUser = timelineMain.get(j).getUser();
                if(user.getIdUser() == tweetUser.getIdUser() || tweetUser.getIdUser() == currentUser.getIdUser()) {
                    if (!listTweet.contains(timelineMain.get(j))) {
                        listTweet.add(timelineMain.get(j));
                    }                            
                }
            }
        }
        
        while(input != -1) {
            System.out.println("================================================");
            System.out.println("Name : "+ currentUser.getName());
            System.out.println("Username : @"+ currentUser.getUsername());
            System.out.println("Following : "+ followingUser.size());
            System.out.println("================================================");
            System.out.println("!!!!!Menu!!!!!");
            System.out.println("1. Posting tweet");
            System.out.println("2. Display timeline");
            System.out.println("3. Exit");
            System.out.print("Input : ");
            input = scan.nextInt();
            
            if(input == 1) {
                System.out.print("What's Happening? : ");
                String text = scan.nextLine();
                text = scan.nextLine();
                if(text.length() <= 144) {
                    Tweet currentTweet = new Tweet(idTweet, text, currentUser, null);
                    listTweet.add(currentTweet);
                } else {
                    System.out.println("Max. 144 character");
                }
                
            } else if (input == 2) {
                for (int k = 0; k < listTweet.size(); k++) {
                    User user = listTweet.get(k).getUser();
                    System.out.println("||"+user.getName()+" @"+ user.getUsername());
                    System.out.println("||"+listTweet.get(k).getText());
                    System.out.println("================================================");
                }     
            } else {
                input = -1;
            }
        }
        
        
        
        
    }
    
}
