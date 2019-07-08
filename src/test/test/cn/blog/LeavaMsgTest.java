package test.cn.blog;

import com.blog.dao.CommentDao;
import com.blog.dao.LeaveMsgSDao;
import com.blog.domain.Comment;
import com.blog.domain.LeaveMsg;
import com.blog.service.LeaveMsgService;
import com.blog.service.impl.CommentServiceImpl;
import com.blog.service.impl.LeaveMsgServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class LeavaMsgTest {
    ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-dao.xml");

/*
     CommentDao commentDao=(CommentDao)context.getBean("commentDao");
*/
     LeaveMsgSDao leaveMsgSDao=(LeaveMsgSDao)context.getBean("leaveMsgSDao");
    @Test
    public void test1(){
      /*  LeaveMsg leaveMsg=new LeaveMsg();
        leaveMsg.setName("mmmhq");
        leaveMsg.setTimes(new Date());
        System.out.println(new Date());
        leaveMsg.setMessage("dafggdasrfgrfdddddddddddddddddddddaaaaaaaaaaaaaa");
        leaveMsg.setEmail("184846565");
        System.out.println("---------------------------------------------"+leaveMsg.toString());
        leaveMsgSDao.insert(leaveMsg);*/
        leaveMsgSDao.deleteByPrimaryKey((long)3);
    /*  Comment comment=new Comment();
      comment.setArticleId((long)93);
      comment.setContent("adggggggggggggggggggfsag");
      comment.setDate(new Date());
      comment.setName("hhhh");
      comment.setEmail("154563223@qq.com");
      commentDao.insert(comment);*/


    }
}
