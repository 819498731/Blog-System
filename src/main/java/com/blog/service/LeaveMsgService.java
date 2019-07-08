package com.blog.service;

import com.blog.domain.Comment;
import com.blog.domain.LeaveMsg;

import java.util.List;

public interface LeaveMsgService {

    List<LeaveMsg> allLeaveMsgs( int offset , int limit);

    int insertLeaveMsg(LeaveMsg leaveMsg);

    int countAllNum();

    boolean delById(Long id);

    List<LeaveMsg> queryAll();
}
