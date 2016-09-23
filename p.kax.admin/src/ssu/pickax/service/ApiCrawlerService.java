package ssu.pickax.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ssu.pickax.dao.ApiCrawlerDao;
import ssu.pickax.vo.ApiCommonVo;
import ssu.pickax.vo.ApiPaginationListVo;
import ssu.pickax.vo.TweetVo;

@Service
public class ApiCrawlerService {
	
	private static final Logger logger = Logger.getLogger(ApiCrawlerService.class);

	@Resource ApiCrawlerDao apiCrawlerDao;
	
	@Resource
	HttpServletRequest request;
	
	public ApiCommonVo<ApiPaginationListVo<TweetVo>> getTweets(TweetVo searchQuery) {
		long startTime = System.nanoTime();
		List<TweetVo> tweets = apiCrawlerDao.getTweets(searchQuery);
		long elapsedTime = System.nanoTime() - startTime;
		String log = "[API crawler 트윗 조회] 성공("
				+ "처리시간: " +elapsedTime + ", searchQuery: " + searchQuery
				+ "ip: " + request.getRemoteAddr() + ")";
		logger.info(log);
		return new ApiCommonVo<ApiPaginationListVo<TweetVo>>(HttpServletResponse.SC_OK, "TWEET", null, new ApiPaginationListVo<TweetVo>(tweets, searchQuery));
	}

}
