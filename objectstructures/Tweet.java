package objectstructures;

public class Tweet {
	
	// new, original tweet
	public Tweet(TwitterAccount tAcc, String newTweetText){
		this.tText = newTweetText;
		this.tOwner = tAcc;
	}
	
	// tweet is the tweet that we retweet
	public Tweet(TwitterAccount tAcc, Tweet tweet) {
		// we get recursive calls all the way up to the actual original
		Tweet originalTweet = tweet.getOriginalTweet();
		// it can't be the owner of the retweet or the 
		// tweet making the tweet
		if(tweet.getOwner() == tAcc ||
				(originalTweet != null && 
				originalTweet.getOwner() == tOwner )) {
			throw new IllegalArgumentException(
					"you can't retweet your own tweet");
		}
		this.tText = tweet.getText();
		this.tOwner = tAcc;
		tweet.retweetCount += 1;
		this.originalTweet = tweet;
	}
	
	private String tText;
	private TwitterAccount tOwner;
	private int retweetCount =0;
	private Tweet originalTweet = null;
	
	public String getText() {
		return this.tText;
	}
	
	public TwitterAccount getOwner() {
		return this.tOwner;
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	
	public Tweet getOriginalTweet() {
		return this.originalTweet;
	}

	@Override
	public String toString() {
		return ""+this.getText()+"\n-"+this.getOwner();
	}
	public static void main(String[] args) {
		TwitterAccount tAcc1 = new TwitterAccount("Alex");
		TwitterAccount tAcc2 = new TwitterAccount("Sebastian");
		TwitterAccount tAcc3 = new TwitterAccount("Fredrik");
		
		Tweet origTweet = new Tweet(tAcc1,"dette er min første tweet");
		System.out.println(origTweet.getText());
		System.out.println(origTweet.getOwner());
		Tweet retweet1 = new Tweet(tAcc2, origTweet);
		Tweet retweet2 = new Tweet(tAcc3, retweet1);
		System.out.println(retweet2.getOriginalTweet());
		
		

	}

}
