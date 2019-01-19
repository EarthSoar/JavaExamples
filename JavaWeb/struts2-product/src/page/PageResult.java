package page;

import java.util.List;

public class PageResult {
	private List<?> listData;  //结果集 ： 通过SQL语句查询出来的
	private Integer totalCount;//数据总数: 通过SQL查询出来

	private Integer currentPage; //当前页 .用户传入的
	private Integer pageSize; //每页显示多少数据,用户传入

	private Integer beginPage = 1;//首页 
	private Integer prevPage;//上一页  :需要计算
	private Integer nextPage;//下一页 ：需要计算
	private Integer totalPage;//总页数/末页   :需要计算
	
	private Integer beginIndex;
	private Integer endIndex;
	private PageIndex pageIndex = null;



	//通过构造器给页面结果对象设置值
	public PageResult(List<?> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	
		totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		prevPage = currentPage >= 2 ? currentPage - 1 : 1;
		nextPage = currentPage <= totalPage - 1 ? currentPage + 1 : totalPage;
		pageIndex= PageIndex.getPageIndex(3, currentPage, totalPage);
		this.beginIndex = pageIndex.getBeginIndex();
		this.endIndex = pageIndex.getEndIndex();
	}
	
	
	
	//设置getter方法,供jsp的el表达式调用

	public List<?> getListData() {
		return listData;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getBeginPage() {
		return beginPage;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getBeginIndex() {
		return beginIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}
	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
	}

}
