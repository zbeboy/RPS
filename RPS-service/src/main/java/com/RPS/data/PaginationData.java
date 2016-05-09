package com.RPS.data;

/**
 * Created by Administrator on 2016/5/9.
 */
public class PaginationData {
    private int totalPages;//总页数
    private int totalDatas;//数据总数
    private int pageNum;//当前页
    private int pageSize;//每页大小
    private int buttons;//显示多少个按钮

    public PaginationData() {
    }

    public PaginationData(int totalPages, int totalDatas, int pageNum, int pageSize, int buttons) {
        this.totalPages = totalPages;
        this.totalDatas = totalDatas;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.buttons = buttons;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalDatas() {
        return totalDatas;
    }

    public void setTotalDatas(int totalDatas) {
        this.totalDatas = totalDatas;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getButtons() {
        return buttons;
    }

    public void setButtons(int buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return "PaginationData{" +
                "totalPages=" + totalPages +
                ", totalDatas=" + totalDatas +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", buttons=" + buttons +
                '}';
    }
}
