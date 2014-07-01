<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="qAjax.js" ></script>
	<script src="js/jquery-1.8.0.min.js.js" ></script>
  </head>
  
  <body>
    <script type="text/javascript">
    
    function mclick(){
    	var p ={};
	    p.url="my";
	    p.action="post";
	    p.onSuccess=function(transport){
	    	alert(transport.responseText);
	    };
	    var j = new Ajax(p);
    }
    
    </script>
    <input type="button" onclick="mclick();" value="click">
    <img alt="33333" src="ff.png">
    <form action="my" method="post">
    	<input type="submit" value="sub">
    </form>
    <script type="text/javascript">
     document.write("<input type='text' value='ffffff'/>")
    </script>
    <% 
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null && cookies.length>0){
    		for(Cookie cookie :cookies)
	    	{
	    	
	    	%>
	    	<div><%=cookie.getName() %>=<%=cookie.getValue() %></div>
	    	<% 
	    	
	    	}
    	}
    
     %>
  </body>
</html>
