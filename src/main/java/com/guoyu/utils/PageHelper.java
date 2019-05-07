package com.guoyu.utils;


/**
 * 分页工具类，使用方法：
 * 1.先设置页码pageNum
 * 2.再设置每页记录数pageSize
 * 3.最后，设置总的记录数totlNum
 *
 * @author guguoyu
 * @since 2019/1/10
 * @since java 1.8
 */
public class PageHelper {
    //默认第一页
    private final static Integer DEFAULT_PAGE_NUM = 1;
    //默认每页数为10
    private final static Integer DEFAULT_PAGE_SIZE = 10;
    //页码，即第几页
    private Integer pageNum;
    //每页记录数
    private Integer pageSize;
    //总共多少条记录数
    private Long totalNum;
    //总页数，即总共多少页
    private Long pageTotal;


    public void setPageNum(Integer pageNum) {
        //如果pageNum为null或者<=0，则默认查询第1页
        if (null == pageNum || pageNum <= 0) {
            this.pageNum = DEFAULT_PAGE_NUM;
            return;
        }
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        //如果pageSize为null或者<=0的情况，则每页数默认10条记录
        if (null == pageSize || pageSize <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
            return;
        }
        this.pageSize = pageSize;
    }

    /**
     * 1.设置总记录数的属性值
     * 2.计算总页数
     *
     * @param totalNum 总记录数
     */
    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
        //计算总页数
        if (this.totalNum % pageSize == 0) {
            this.pageTotal = this.totalNum / pageSize;
        } else {
            this.pageTotal = (this.totalNum / pageSize) + 1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageIndex() {
        //如果页码pageNum超过总页数，则设置页码pageNum为第1页
        if (pageNum > pageTotal) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        return (pageNum - 1) * pageSize;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public Long getTotalNum() {
        return totalNum;
    }
}
