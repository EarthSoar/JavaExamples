package page;

/**
 * @author Willing
 * @date 2019/1/8
 */

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 封装了分页所需要的信息
 */
@Getter
public class PageResult {
    private List<?> listData;//结果集
    private Integer totalCount;//结果总数

    private Integer currentPage;//当前页，用户传入
    private Integer pageSize;//页面大小,用户传入

    private Integer beginPage = 1;//首页
    private Integer prevPage;//上一页  :需要计算
    private Integer nextPage;//下一页 ：需要计算
    private Integer totalPage;//总页数/末页   :需要计算

    private PageIndex pageIndex = null;
    private Integer beginIndex;
    private Integer endIndex;

    private List<Integer> pageItems = Arrays.asList(4,2,3,5);//每页显示多少数据-->下拉列表的值

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
}
