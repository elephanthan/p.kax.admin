package ssu.pickax.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ssu.pickax.service.ApiCrawlerService;
import ssu.pickax.vo.ApiCommonVo;
import ssu.pickax.vo.ApiPaginationListVo;
import ssu.pickax.vo.TweetVo;

@Controller
@RequestMapping("/apis/crawler/*")
@Api(value="crawler", produces="application/json", protocols="http/https(권장)", tags={"수집기 API"})
public class ApiCrawlerController {
	
	@Resource
	ApiCrawlerService apiCrawlerService;
	
	/**
	 * 트위터 수집기 조회
	 * @param twit_keyword
	 * @return 해당 TweetVo List
	 */
	@ApiOperation(value="트윗 조회", notes="트윗내역을 조회합니다. 데이터를 입력할 경우 해당조건에 일치하는 로그를 조회합니다.(현재는 keyword만 지원)",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value={@ApiResponse(code=200, message="성공적으로 조회했습니다."),
					 @ApiResponse(code=400, message="입력 데이터 값의 형식이 유효하지 않습니다"),
					 @ApiResponse(code=401, message="토큰 인증 실패"),
					 @ApiResponse(code=405, message="해당 요청을 지원하지 않습니다"),
					 @ApiResponse(code=406, message="해당 미디어 타입을 지원하지 않습니다 (application/json만 지원)"),
					 @ApiResponse(code=500, message="해당 요청을 처리중 서버에서 오류가 발생하였습니다")})
	@RequestMapping(value="/tweet/{keyword}", method=RequestMethod.GET)
	@ResponseBody
	public ApiCommonVo<ApiPaginationListVo<TweetVo>> getTweets(HttpServletResponse response,
															  @ApiParam(value="트윗 키워드", required=true) @PathVariable("keyword") String keyword,
															  @ApiParam(value="한 페이지에 출력될 리스트 수 (1 ~ 100)", required=false) @Size(min=1, max=100) @RequestParam(defaultValue="10", required=false) Integer result,
															  @ApiParam(value="페이지 번호", required=false) @RequestParam(defaultValue="1", required=false) Integer pageNo){
		TweetVo searchQuery = new TweetVo();
		searchQuery.setTweet_keyword(keyword);
		searchQuery.setPage_per_item_num(result);
		searchQuery.setPresent_page(pageNo);
		ApiCommonVo<ApiPaginationListVo<TweetVo>> returnData = apiCrawlerService.getTweets(searchQuery);
		response.setStatus(returnData.getStatus_code());
		
		return returnData;
	}
	
}
