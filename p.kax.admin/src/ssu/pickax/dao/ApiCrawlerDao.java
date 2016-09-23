package ssu.pickax.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssu.pickax.vo.TweetVo;

@Repository
public class ApiCrawlerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<TweetVo> getTweets(TweetVo searchQuery) {
		return this.sqlSession.selectList("crawler.getTweets",searchQuery);
	}

}
