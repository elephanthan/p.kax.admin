package ssu.pickax.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties({"total_item_num", "total_page_num", "page_per_item_num", "present_page", "present_first_item_idx", "present_last_item_idx", "page_bar_idx_num", "page_bar_first_num", "page_bar_last_num"})
public class Pagination{
	
	//총 item 수 
	@ApiModelProperty(value="전체 검색 결과의 수", hidden=true)
	private int total_item_num;
	
	//총 페이지 수 
	@ApiModelProperty(value="보여줄 수 있는 페이지 수", hidden=true)
	private int total_page_num;
	
	//페이지당 item 수 
	@ApiModelProperty(value="한 페이지에 출력될 리스트 수", hidden=true)
	private int page_per_item_num = 10;
	
	//현재 페이지
	@ApiModelProperty(value="현제 페이지", hidden=true)
	private int present_page = 1;
	
	
	//현재 페이지 처음
	@ApiModelProperty(hidden=true)
	private int present_first_item_idx;
	
	//현재 페이지 마지막
	@ApiModelProperty(hidden=true)
	private int present_last_item_idx;
	
	//페이지 바 수 개수
	@ApiModelProperty(hidden=true)
	private int page_bar_idx_num = 5;
	
	//페이지 바 처음 수 
	@ApiModelProperty(hidden=true)
	private int page_bar_first_num;
	
	//페이지 바 마지막 수 
	@ApiModelProperty(hidden=true)
	private int page_bar_last_num;
	
	public Pagination(){
		
	}
	
	public Pagination(Pagination target){
		this.total_item_num = target.total_item_num;
		this.total_page_num = target.total_item_num;
		this.page_per_item_num = target.page_per_item_num;
		this.present_page = target.present_page;
		this.present_first_item_idx = target.present_first_item_idx;
		this.present_last_item_idx = target.present_last_item_idx;
		this.page_bar_idx_num = target.page_bar_idx_num;
		this.page_bar_first_num = target.page_bar_first_num;
		this.page_bar_last_num = target.page_bar_last_num;
	}
	
	public int getTotal_item_num() {
		return total_item_num;
	}
	
	public void setTotal_item_num(int total_item_num) {
		this.total_item_num = total_item_num;
	}
	
	public int getTotal_page_num() {
		int tmp = total_item_num / page_per_item_num;
		
		//if(tmp%page_per_item_num>0)
		if(total_item_num%page_per_item_num>=1)
			tmp+=1;
		
		//if(tmp == 0)
		//	tmp = 1;
		
		return tmp;
	}
	
	public void setTotal_page_num(int total_page_num) {
		this.total_page_num = total_page_num;
	}
	
	public int getPage_per_item_num() {
		return page_per_item_num;
	}     
	
	public void setPage_per_item_num(int page_per_item_num) {
		this.page_per_item_num = page_per_item_num;
	}
	
	public int getPresent_page() {
		return present_page;
	}
	
	public void setPresent_page(int present_page) {
		this.present_page = present_page;
	}
	
	public int getPresent_first_item_idx() {
		
		int res;
		//res = total_item_num - page_per_item_num * (present_page - 1) - (page_per_item_num - 1);
		res  = 1 + (present_page - 1) * page_per_item_num;
		
		if(res <= 0)
			res = 1;
		
		return res;
		
	}
	
	public void setPresent_first_item_idx(int present_first_item_idx) {
		this.present_first_item_idx = present_first_item_idx;
	}
	
	public int getPresent_last_item_idx() {
		
		int res;
		//res = total_item_num - page_per_item_num * (present_page - 1);
		res  = present_page * page_per_item_num;
		
		if(res <= 0)
			res = page_per_item_num;
		
		return res;
		
	}
	
	public void setPresent_last_item_idx(int present_last_item_idx) {
		this.present_last_item_idx = present_last_item_idx;
	}

	public int getPage_bar_first_num() {
		int tmp = page_bar_idx_num / 2;
		int res = present_page - tmp;
		
		if(present_page + tmp > getTotal_page_num()){
			int a = present_page + tmp - getTotal_page_num();
			res -= a;
		}
			
		if(res < 1)
			res = 1;
		
		return res;
	}

	public void setPage_bar_first_num(int page_bar_first_num) {
		this.page_bar_first_num = page_bar_first_num;
	}
	
	public int getPage_bar_last_num() {
		int tmp = page_bar_idx_num / 2;
		int res = present_page + tmp;
		
		if(getTotal_page_num()<=page_bar_idx_num){
			res = getTotal_page_num();
		}
		else{
			if(res < page_bar_idx_num)
				res = page_bar_idx_num;
				
			if(res >= getTotal_page_num())
				res = getTotal_page_num();
		}
		
		return res;
	}

	public void setPage_bar_last_num(int page_bar_last_num) {
		this.page_bar_last_num = page_bar_last_num;
	}

	public int getPage_bar_idx_num() {
		return page_bar_idx_num;
	}

	public void setPage_bar_idx_num(int page_bar_idx_num) {
		this.page_bar_idx_num = page_bar_idx_num;
	}

	@Override
	public String toString() {
		return "Pagination [total_item_num=" + total_item_num
				+ ", total_page_num=" + total_page_num + ", page_per_item_num="
				+ page_per_item_num + ", present_page=" + present_page
				+ ", present_first_item_idx=" + present_first_item_idx
				+ ", present_last_item_idx=" + present_last_item_idx
				+ ", page_bar_idx_num=" + page_bar_idx_num
				+ ", page_bar_first_num=" + page_bar_first_num
				+ ", page_bar_last_num=" + page_bar_last_num + "]";
	}
}
