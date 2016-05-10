package com.RPS.service;

import com.RPS.dao.MessageDtoMapper;
import com.RPS.model.MessageDto;
import com.RPS.model.MessageDtoExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
@Service("messageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageDtoMapper messageDtoMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void save(MessageDto messageDto) {
        messageDtoMapper.insert(messageDto);
    }

    @Override
    public void deleteById(int id) {
        messageDtoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MessageDto> findByAcceptUserAndPage(String acceptUser,int pageNum,int pageSize) {
        MessageDtoExample messageDtoExample = new MessageDtoExample();
        MessageDtoExample.Criteria cr = messageDtoExample.createCriteria();
        cr.andAcceptUserEqualTo(acceptUser);
        PageHelper.startPage(pageNum, pageSize);
        List<MessageDto> messageDtos = messageDtoMapper.selectByExample(messageDtoExample);
        return messageDtos;
    }

    @Override
    public int findByAcceptUserAndIsSeeCount(String acceptUser, boolean isSee) {
        MessageDtoExample messageDtoExample = new MessageDtoExample();
        MessageDtoExample.Criteria cr = messageDtoExample.createCriteria();
        cr.andAcceptUserEqualTo(acceptUser);
        cr.andIsSeeEqualTo(isSee);
        int count = messageDtoMapper.countByExample(messageDtoExample);
        return count;
    }

    @Override
    public List<MessageDto> findByAcceptUserAndIsSee(String acceptUser, boolean isSee) {
        MessageDtoExample messageDtoExample = new MessageDtoExample();
        MessageDtoExample.Criteria cr = messageDtoExample.createCriteria();
        cr.andAcceptUserEqualTo(acceptUser);
        cr.andIsSeeEqualTo(isSee);
        List<MessageDto> messageDtos = messageDtoMapper.selectByExample(messageDtoExample);
        return messageDtos;
    }

    @Override
    public void update(MessageDto messageDto) {
        messageDtoMapper.updateByPrimaryKey(messageDto);
    }
}
