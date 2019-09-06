package com.antz;

import com.util.Base64Utils;
import com.util.HttpSend;
import com.util.TimeUtil;
import dao.impl.ContentDAOImpl;
import domain.Content;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendPaperSerlvet  extends HttpServlet {

    static ContentDAOImpl contentDAO = new ContentDAOImpl() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  Nothing todo
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Content contentDa = new Content() ;
        req.setCharacterEncoding("utf-8");
        String nowTime = TimeUtil.getDate() ;
        String getSend = req.getParameter("name") +"\r\n"+ req.getParameter("content") ;
        contentDa.setName(req.getParameter("name") );
        contentDa.setData(nowTime);
        contentDa.setContent(req.getParameter("content"));
        if (req.getParameter("content").length()>500){
            req.setAttribute("result","字数太多了！少发一点吧，纸不够了。");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        if ((req.getParameter("name")==null) && (req.getParameter("content")==null)){
            req.setAttribute("result","请不要发送空值");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        if ((req.getParameter("name").equals("")) && (req.getParameter("content").equals(""))){
            req.setAttribute("result","请不要发送空值");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        contentDa.setId(1L);

        contentDAO.save(contentDa);
        String content = Base64Utils.toBase64(getSend) ;

        String json = HttpSend.setUserBind(nowTime);
        String showapi_userid = "" ;
        String con = "showapi_userid\":(.*)}" ;
        Pattern ah = Pattern.compile(con);
        Matcher mr = ah.matcher(json);
        while (mr.find()) {
            showapi_userid = mr.group().replace("showapi_userid\":","").replace("}","") ;
        }
        String result = HttpSend.printPaper(content,showapi_userid,nowTime);

        String con1 = "\"showapi_res_error(.*)," ;
        Pattern ah1 = Pattern.compile(con1);
        Matcher mr1 = ah1.matcher(result);
        while (mr1.find()) {
            req.setAttribute("result",nowTime+" 发送完毕[Info] "+mr1.group());
        }

        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }


}
