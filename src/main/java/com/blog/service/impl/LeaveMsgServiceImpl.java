package com.blog.service.impl;

import com.blog.dao.LeaveMsgSDao;
import com.blog.domain.LeaveMsg;
import com.blog.service.LeaveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveMsgServiceImpl implements LeaveMsgService {

    @Autowired
    public LeaveMsgSDao leaveMsgSDao;
    @Override
    public List<LeaveMsg> allLeaveMsgs( int offset, int limit) {
        return leaveMsgSDao.queryAll( offset, limit);
    }

    @Override
    public int insertLeaveMsg(LeaveMsg leaveMsg) {
        return leaveMsgSDao.insert(leaveMsg);
    }

    @Override
    public int countAllNum() {
        return leaveMsgSDao.countAllNum();
    }

    @Override
    public boolean delById(Long id) {
        return  leaveMsgSDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public List<LeaveMsg> queryAll() {
        return leaveMsgSDao.queryAllMsg();
    }


}
