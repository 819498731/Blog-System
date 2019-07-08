package com.blog.web;

import com.blog.domain.Article;
import com.blog.domain.LeaveMsg;
import com.blog.service.impl.LeaveMsgServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class LeaveMsgController {
    @Autowired
    public LeaveMsgServiceImpl leaveMsgService;

    @RequestMapping("/api/messageboard")
    public ModelAndView leaveMsgList(@RequestParam(required = true, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView("messageboard");
        PageHelper.startPage(page, pageSize);
        List<LeaveMsg> leaveMsgs = leaveMsgService.queryAll();
        PageInfo<LeaveMsg> pageInfo = new PageInfo<LeaveMsg>(leaveMsgs);
        modelAndView.addObject("leaveMsgs", leaveMsgs);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }


    @RequestMapping(value = "/api/leaveMsgBoard/add", method = RequestMethod.POST)
    public @ResponseBody Object addMessage(HttpServletRequest request) {
        LeaveMsg leaveMsg = new LeaveMsg();
        leaveMsg.setName(request.getParameter("name"));
        leaveMsg.setMessage(request.getParameter("message"));
        leaveMsg.setEmail(request.getParameter("email"));
        leaveMsg.setTimes(new Date());
        HashMap<String, String> res = new HashMap<>();
        if(leaveMsgService.insertLeaveMsg(leaveMsg)>0){
            res.put("stateCode","1");
        }else {
            res.put("stateCode","0");
        }
        return res;
    }
    @RequestMapping("/admin/leavemsgs/list")
    public ModelAndView msgBoardList(@RequestParam(required=true,defaultValue="1") Integer page, @RequestParam(required=false,defaultValue="10") Integer pageSize){
        PageHelper.startPage(page, pageSize);
        List<LeaveMsg> leavemsgs=leaveMsgService.queryAll();
        PageInfo<LeaveMsg> pageInfo=new PageInfo<LeaveMsg>(leavemsgs);
        ModelAndView modelAndView=new ModelAndView("/admin/leaveMsgs_list");
        modelAndView.addObject("leavemsgs",leavemsgs);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/api/leaveMsgs/del", method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request) {
        long id=Integer.parseInt(request.getParameter("id"));
        boolean result=leaveMsgService.delById(id);
        HashMap<String, String> res = new HashMap<String, String>();
        if (result){
            res.put("stateCode", "1");
        }else {
            res.put("stateCode", "0");
        }
        return res;
    }

}

