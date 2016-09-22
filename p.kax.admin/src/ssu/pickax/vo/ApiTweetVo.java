package ssu.pickax.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel(value="TweetInfo", description="트윗")
public class ApiTweetVo {
	
	@JsonProperty("twitSeq")
	private long twit_seq;
	
	@JsonProperty("twitId")
	private long twit_id;
	
	@JsonProperty("twitKeyword")
	private String twit_keyword;
	
	@JsonProperty("twitUser")
	private String twit_long;
	
	@JsonProperty("twitText")
	private String twit_text;
	
	@JsonProperty("twitTime")
	private String twit_time;

	public long getTwit_seq() {
		return twit_seq;
	}

	public void setTwit_seq(long twit_seq) {
		this.twit_seq = twit_seq;
	}

	public long getTwit_id() {
		return twit_id;
	}

	public void setTwit_id(long twit_id) {
		this.twit_id = twit_id;
	}

	public String getTwit_keyword() {
		return twit_keyword;
	}

	public void setTwit_keyword(String twit_keyword) {
		this.twit_keyword = twit_keyword;
	}

	public String getTwit_long() {
		return twit_long;
	}

	public void setTwit_long(String twit_long) {
		this.twit_long = twit_long;
	}

	public String getTwit_text() {
		return twit_text;
	}

	public void setTwit_text(String twit_text) {
		this.twit_text = twit_text;
	}

	public String getTwit_time() {
		return twit_time;
	}

	public void setTwit_time(String twit_time) {
		this.twit_time = twit_time;
	}
	
	
	
}
