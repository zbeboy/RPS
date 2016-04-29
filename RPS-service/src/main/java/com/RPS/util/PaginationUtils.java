package com.RPS.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/29.
 */
public class PaginationUtils<T> {

    /**
     * pagination data
     * @param list
     * @param pageNum
     * @return
     */
    public Map<String, Object> paginationData(List<T> list, Integer pageNum) {
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> map = new HashMap<String, Object>();

        int totalPages = pageInfo.getPages();
        map.put("dataInfo", list);
        map.put("totalPages", totalPages);
        if (totalPages < 7) {
            map.put("visiablePages", totalPages);
        } else {
            map.put("visiablePages", 7);
        }
        map.put("startPage", pageNum);

        return map;
    }
}
