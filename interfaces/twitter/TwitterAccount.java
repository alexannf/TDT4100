package interfaces.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
	
	private final String userName;

	private List<TwitterAccount> follows = new ArrayList<TwitterAccount>();
	private List<TwitterAccount> followers = new ArrayList<TwitterAccount>();

	private List<Tweet> tweets = new ArrayList<Tweet>();

	public TwitterAccount(String username) {
		this.userName = username;
	}

	public String toString() {
		return "[Username: " + getUserName() + " - " 
				+ getTweetCount() + " tweet(s) - " 
				+ getFollowerCount() + " Follower(s)]";
	}

	public String getUserName() {
		return userName;
	}

	public void follow(TwitterAccount otherUser) {
		if (this == otherUser) {
			throw new IllegalStateException("You cannot follow yourself.");
		}
		if (! follows.contains(otherUser)) {
			follows.add(otherUser);
			otherUser.followers.add(this);
		}
	}

	public void unfollow(TwitterAccount otherUser) {
		if (follows.contains(otherUser)) {
			follows.remove(otherUser);
			otherUser.followers.remove(this);
		}
	}

	public boolean isFollowing(TwitterAccount otherUser) {
		return follows.contains(otherUser);
	}

	public boolean isFollowedBy(TwitterAccount otherUser) {
		return followers.contains(otherUser);
	}

	public void tweet(String text) {
		tweets.add(new Tweet(this, text));
	}

	public void retweet(Tweet tweet) {
		tweets.add(new Tweet(this, tweet));
	}

	public Tweet getTweet(int i) {
		return tweets.get(tweets.size() - i);
	}

	public int getTweetCount() {
		return tweets.size();
	}

	public int getRetweetCount() {
		int count = 0;
		for (Tweet tweet : tweets) {
			count += tweet.getRetweetCount();
		}
		return count;
	}

	public int getFollowerCount(){
		return followers.size();
	}
	
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> c){
		if(c==null) {
			return this.followers;
		}
		else {
			List<TwitterAccount> followersCopy = 
					new ArrayList<TwitterAccount>(this.followers);
			// this sorts the arraylist but does not return anything
			Collections.sort(followersCopy, c);
			// followersCopy should at this point be sorted properly
			return followersCopy;
		}
	}
	
	public static void main(String[] args) {
		
		TwitterAccount alex = new TwitterAccount("alexalex9494");
		TwitterAccount seb = new TwitterAccount("sebsig");
		TwitterAccount nils = new TwitterAccount("nilsern123");
		TwitterAccount bob = new TwitterAccount("bobman123");
		TwitterAccount truls = new TwitterAccount("trulsboy99");
		TwitterAccount vidar = new TwitterAccount("vidar");
		
		
		alex.follow(seb);
		seb.follow(alex);
		alex.follow(nils);
		nils.follow(alex);
		seb.follow(nils);
		bob.follow(alex);
		truls.follow(alex);
		vidar.follow(alex);
		
		vidar.tweet("first tweet");
		vidar.tweet("second tweet");
		truls.tweet("my first tweet");
		
		System.out.println("unsorted");
		System.out.println(alex.getFollowers(null));
		System.out.println();
		System.out.println("sorted by username");
		System.out.println(alex.getFollowers(new UserNameComparator()));
		System.out.println();
		System.out.println("unsorted");
		System.out.println(alex.getFollowers(null));
		System.out.println();
		System.out.println("sorted by followers");
		System.out.println(alex.getFollowers(new FollowersCountComparator()));
		System.out.println();
		System.out.println("unsorted");
		System.out.println(alex.getFollowers(null));
		System.out.println();
		System.out.println("sorted by most tweets");
		System.out.println(alex.getFollowers(new TweetsCountComparator()));
		
	}

}
