package com.tomalen.springlanuch.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/28
 * 返回的分页数据模型
 */
@Data
public class paginitionDTO<T> {

    private List<T> data;
    private boolean showPrev;//展示上一页
    private boolean showFirst;//展示第一页
    private boolean showEnd;//展示最后一页
    private boolean showNext;//展示下一页

    //展示当前页
    private Integer page;
    //展示总列表页
    private List<Integer> pages = new ArrayList<>(0);
    //总页数
    private Integer totalPage;

    /**
     * 计算分页信息
     * @param total
     * @param page
     * @param size
     */
    public void setPaginition(Integer total, Integer page, Integer size) {
        //计算页码总数
        Integer totalPages;
        if((total % size) == 0) {
            totalPages = total / size;
        }else{
            totalPages = total / size + 1;
        }
        this.totalPage = totalPages;
        //当前类的page等于传入的page
        this.page = page;
        //判断page小于1时和page大于总页码数时的前端展示
        if(page < 1) {
            page = 1;
        }
        if(page > totalPages) {
            page = totalPages;
        }
        //计算页码的变化数, 每次都有7页
        pages.add(page);
        //当当前页减一大于0，就把当前页添加
        for(int i = 1;i <= 3;i ++ ) {
            if(page - i > 0) {
                pages.add(0,page - i);
            }
            //当当前页 + 1小于总页码数时，把当前页添加进显示的总页
            if(page + i <= totalPages) {
                pages.add(page + i);
            }
        }

        //判断是否有有上一页
        if(page == 1) {
            showPrev = false;
        }else {
            showPrev = true;
        }

        //判断是否有下一页
        if(page == totalPages) {
            showNext = false;
        }else{
            showNext = true;
        }

        //判断第一页
        if(pages.contains(1)) {
            showFirst = false;
        }else {
            showFirst = true;
        }

        //展示最后一页
        if(pages.contains(totalPages)) {
            showEnd = false;
        }else{
            showEnd = true;
        }
    }
}
