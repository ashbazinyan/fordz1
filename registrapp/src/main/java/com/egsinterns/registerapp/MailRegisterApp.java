package com.egsinterns.registerapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by User on 2/18/2016.
 */
public class MailRegisterApp extends HttpServlet {
    public static List<String> listRegInfo=new ArrayList<String>();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();
        pw.println("<html><head>");
        pw.println("<title>Register Page</title></head><body>");
        pw.println("<h2>Please submit your information</h2>");
        pw.println("<form method=\"post\" action=\""+req.getContextPath()+
        "/mailregisterapp\">");
        pw.println("<table border=\"0\"><tr><td valign=\"top\">");
        pw.println("Your first name:</td> <td valign=\"top\">");
        pw.println("<input type=\"text\" name=\"firstname\" size=\"20\">");
        pw.println("</td></tr><tr><td valign=\"top\">");

        pw.println("Your last name:</td> <td valign=\"top\">");
        pw.println("<input type=\"text\" name=\"lastname\" size=\"20\">");
        pw.println("</td></tr><tr><td valign=\"top\">");

        pw.println("Your E-mail:</td> <td valign=\"top\">");
        pw.println("<input type=\"text\" name=\"email\" size=\"20\">");
        pw.println("</td></tr><tr><td valign=\"top\">");

        pw.println("<input type=\"submit\" value=\"Submit info\"></td></tr>");
        pw.println("</table></form>");
        pw.println("</body></html>");

    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Enumeration paramNames=req.getParameterNames();
        String param;
        boolean emptyEnum=false;
        if(!paramNames.hasMoreElements()) {
            emptyEnum = true;
        }
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();
        pw.println("<html><head>");
        pw.println("<title>Submited inforamation</title></head><body>");

        if(emptyEnum){
            pw.println("<h2>Sorry,the request does not contain any registrated parametrs</h2>");
            return;
        }else {
            pw.println("<h2>Here are the sumbitted parameter values </h2>");
        }

        while (paramNames.hasMoreElements()) {
            param = (String) paramNames.nextElement();
            pw.println("<strong>" + param +":"+ "</strong>" + req.getParameter(param));
            pw.println("<br />");
        }
        pw.println("</body></html>");
    }

}
