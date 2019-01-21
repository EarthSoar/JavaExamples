package page;

import java.util.List;

import daomain.Employee;

public class PageResult {
	private List<?> listData;
	private Integer totalCount;

	private Integer currentPage;
	private Integer pageSize;

	private Integer beginPage = 1;
	private Integer prevPage;
	private Integer nextPage;
	private Integer totalPage;

	public PageResult(List<Employee> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		// ----------
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : currentPage;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;
		// ----------
	}

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
}
