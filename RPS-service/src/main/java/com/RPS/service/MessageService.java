package com.RPS.service;

import com.RPS.model.MessageDto;

import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
public interface MessageService {
    /**
     * 保存消息
     * @param messageDto
     */
    void save(MessageDto messageDto);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据接收者分页查询
     * @param acceptUser
     */
    List<MessageDto> findByAcceptUserAndPage(String acceptUser,int pageNum,int pageSize);

    /**
     * 总数
     * @param acceptUser
     * @return
     */
    int findByAcceptUserAndIsSeeCount(String acceptUser,boolean isSee);

    /**
     * 根据接收者分页查询 和是否已看
     * @param acceptUser
     * @param isSee
     * @return
     */
    List<MessageDto> findByAcceptUserAndIsSee(String acceptUser,boolean isSee);

    /**
     * 更新
     * @param messageDto
     */
    void update(MessageDto messageDto);
}
