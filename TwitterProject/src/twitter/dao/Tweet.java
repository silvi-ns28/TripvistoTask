/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.dao;

/**
 *
 * @author Silviana
 */
public class Tweet {
    private int idTweet;
    private String text;
    private User user;
    private String date;

    public Tweet(int idTweet, String text, User user, String date) {
        this.idTweet = idTweet;
        this.text = text;
        this.user = user;
        this.date = date;
    }
    
    public int getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(int idTweet) {
        this.idTweet = idTweet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
