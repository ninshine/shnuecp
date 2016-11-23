<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.shnuecp.domain.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<a>Products View</a><br>
<hr>


<table >
		<tr>
			<th width="15%">No.</th>
			<th width="40%">Name</th>
			<th width="15%">Price</th>
			<th width="30%">Add to cart</th>
		</tr>
<% 
List<ProductDescription> res = (List<ProductDescription>)request.getAttribute("itemlist"); 
ProductDescription pd = new ProductDescription();
Iterator<ProductDescription> iter = res.iterator();  
int id = 0;
String name=null;
int price =0;

while(iter.hasNext())  
{  
	pd = iter.next();
	id = pd.getId();
	name = pd.getName();
	price = pd.getPrice();
	%>
	<tr>
			<td><%=id %></td>
			<td><%=name %></td>
			<td><%=price %></td>
			<td><button id="add" type="button" onclick="javascript:window.location.href='addtocart.do?id=<%=id%>&name=<%=name%>&price=<%=price%>'">Add to cart</button></td>
	</tr>
	<%
}%>
</table>

<%
int pageCount = (int)request.getAttribute("pageCount");
int currentPage = (int)request.getAttribute("currentPage");
String keyword = (String)request.getAttribute("keyword");
for (int i=1; i<=pageCount; i++){
	if(i!=currentPage){%>
		<a href="search.do?currentPage=<%=i%>&keyword=<%=keyword%>"><%=i %></a>
	<%}else{%>
		<a><%=i %></a>
	<%}
}
%>

</body>
</html>