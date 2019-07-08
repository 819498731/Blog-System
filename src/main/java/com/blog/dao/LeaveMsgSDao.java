package com.blog.dao;

import com.blog.domain.Comment;
import com.blog.domain.LeaveMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveMsgSDao {

    int insert(LeaveMsg leaveMsg);

    List<LeaveMsg> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int updateByPrimaryKey(LeaveMsg leaveMsg);

    int countAllNum();

    int deleteByPrimaryKey(Long id);

    List<LeaveMsg> queryAllMsg();

}
