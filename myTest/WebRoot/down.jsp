 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    <title>222</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  <body>
 <script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
 <script  type="text/javascript">
 function tt(){
  var url ="downFileServlet";
 	 document.getElementById("iframe").src=url;
 	//alert($("#iframe").html());
 //	location.href=url;
 }
 	
 
 </script>
   <iframe id="iframe" style="display:none;" ></iframe>
   <input type="button" onclick="tt()" value="tttt"/>
  </body>
</html>
