package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {
	
	public TwitterAccount(String userName) {
		this.userName = userName;
		this.followers = new ArrayList<TwitterAccount>();
		this.following = new ArrayList<TwitterAccount>();
		this.tweets = new ArrayList<Tweet>();
	}
	
	private String userName;
	private List<TwitterAccount> followers;
	private List<TwitterAccount> following;
	private List<Tweet> tweets;
	private int tweetCount;
	private int retweetCount;
	
	public String getUserName() {
		return userName;
	}
	
	public void follow(TwitterAccount acc) {
		this.following.add(acc);
		acc.followers.add(this);
	}
	
	public void unfollow(TwitterAccount acc) {
		if(isFollowing(acc)) {
			this.following.remove(acc);
			acc.followers.remove(this);			
		}
	}
	
	public boolean isFollowing(TwitterAccount acc) {
		if(this.following.contains(acc)) {
			return true;
		}
		return false;
	}
	
	public boolean isFollowedBy(TwitterAccount acc) {
		if(this.followers.contains(acc)) {
			return true;
		}
		return false;
	}
	
	public void tweet(String tText) {
		this.tweets.add(new Tweet(this,tText));
		this.tweetCount++;
	}
	
	public void retweet(Tweet tweet) {
		this.tweets.add(new Tweet(this,tweet));
		this.tweetCount++;
		tweet.getOwner().retweetCount++;
//		this.retweetCount++;
	}
	
	public Tweet getTweet(int i) {
		return this.tweets.get(tweets.size()-i);
	}
	
	public int getTweetCount() {
		return this.tweetCount;
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	
	
	@Override
	public String toString() {
		return userName;
	}

	public static void main(String[] args) {
		TwitterAccount alex = new TwitterAccount("@alexalex9494");
		TwitterAccount seb = new TwitterAccount("sebsig");
		TwitterAccount nils = new TwitterAccount("nilsern123");
		
		seb.tweet("sebastians first tweet");
		alex.retweet(seb.getTweet(1));
		System.out.println(alex.getRetweetCount());
		System.out.println(seb.getRetweetCount());
		nils.retweet(seb.getTweet(1));;
		System.out.println(seb.getTweet(1));
		System.out.println(seb.getRetweetCount());
		System.out.println(alex.getTweetCount());
		System.out.println(nils.getTweetCount());

	}

}
