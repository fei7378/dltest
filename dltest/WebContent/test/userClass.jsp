<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@page import = "main.classperson" import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String name = (String)request.getSession().getAttribute("name");
if(name==null){
	name="非法登录";
//	request.getRequestDispatcher("/index").forward(request, response);
}else{
	name = "欢迎："+name;
}
%>
<title><%=name %></title>
</head>
<body style="color: #999999">

 <div class="login_form">
       <form action="/denlu/servlet">
<input type="submit" name="Submit" value="退出登录" /> 

</form>
</div>
<!--  <form id="Login" name="Login" method="post" onsubmit="" action="/denlu/index">
				
					<span>姓名：</span>
					<input type="text" id="name" name="name" class="login_input" >
               
				
					<span>班级：</span>
					<input type="text" id="class" name="class" class="login_input" >
                                        <span id="password-msg" class="error"></span>
				
					<span>学号：</span>
					<input type="text" id="num" name="num" class="login_input" >
                                        <span id="password-msg" class="error"></span>
			
					<input type="reset" name="Reset" value="清空" />
					<input type="submit" name="Submit" value="增加" /> 
			                     
           </form>-->
            <form id="Login" name="Login" method="post" onsubmit="" action="/dltest/index">
				
					<span>请输入班级编号：</span>
					<input type="text" id="finum" name="finum" class="login_input" >
 
					<input type="reset" name="Reset" value="清空" />
					<input type="submit" name="Submit" value="查询" /> 
			             <!--  <span></span>      -->  
           
           </form>
           
              <table>  
        <tr>  
            <th>行号</th>  
            <th>姓名</th>  
            <th>班级</th>  
             <th>学号<th> 
        </tr>  
  
        <c:forEach items="${key_list}" var="usr" varStatus="idx">  
        <tr>  
                <td>${usr.id}</td><td>${usr.name}</td><td>${usr.classnum}</td><td>${usr.number}</td>  
            </tr>  
        </c:forEach>  
       
    </table> 
           
          
       
       
       
</body>
</html>