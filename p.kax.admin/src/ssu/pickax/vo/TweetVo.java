package ssu.pickax.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel(value="TweetInfo", description="트윗")
public class TweetVo extends Pagination {
	
	@JsonProperty("tweetSeq")
	private long tweet_seq;
	
	@JsonProperty("twitId")
	private long tweet_id;
	
	@JsonProperty("tweetKeyword")
	private String tweet_keyword;
	
	@JsonProperty("tweetUser")
	private String tweet_long;
	
	@JsonProperty("tweetText")
	private String tweet_text;
	
	@JsonProperty("tweetTime")
	private String tweet_time;

	public long getTweet_seq() {
		return tweet_seq;
	}

	public void setTweet_seq(long tweet_seq) {
		this.tweet_seq = tweet_seq;
	}

	public long getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(long tweet_id) {
		this.tweet_id = tweet_id;
	}

	public String getTweet_keyword() {
		return tweet_keyword;
	}

	public void setTweet_keyword(String tweet_keyword) {
		this.tweet_keyword = tweet_keyword;
	}

	public String getTweet_long() {
		return tweet_long;
	}

	public void setTweet_long(String tweet_long) {
		this.tweet_long = tweet_long;
	}

	public String getTweet_text() {
		return tweet_text;
	}

	public void setTweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}

	public String getTweet_time() {
		return tweet_time;
	}

	public void setTweet_time(String tweet_time) {
		this.tweet_time = tweet_time;
	}

	
	
}
