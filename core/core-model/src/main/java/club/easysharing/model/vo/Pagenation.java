package club.easysharing.model.vo;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Pagenation
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-02 11:39:09
 */
public class Pagenation<T> {
    /* 当前页号 */
    private int pageNum;
    /* 页面大小 */
    private int pageSize;
    /* 记录总数 */
    private long dataCount;
    /* 页面总数 */
    private int pageCount;
    /* 数据集合 */
    private List<T> dataList;

    public Pagenation(int pageNum, int pageSize, long dataCount, int pageCount) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.pageCount = pageCount;
    }

    public Pagenation(int pageNum, int pageSize, long dataCount, int pageCount, List<T> dataList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.pageCount = pageCount;
        this.dataList = dataList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public Pagenation setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Pagenation setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getDataCount() {
        return dataCount;
    }

    public Pagenation setDataCount(long dataCount) {
        this.dataCount = dataCount;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Pagenation setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public Pagenation setDataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }
}
