<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Movie movie= (Movie) request.getAttribute("Movie"); %>
<div>
<table>
<form action="edit-movie" method="post" enctype="multipart/form-data">
<tr>
<input type="hidden" value="<%=movie.getId()%>"  name="id">
</tr>
<tr>
    <td><label for="">Movie Name:</label></td>
    <td><input type="text" name="M_Name" required value="<%=movie.getName() %>"></td>
   </tr>
   <tr>
    <td><label for="">Movie Language:</label></td>
    <td><select name="L_Name" >
    	<option selected value="<%=movie.getLanguage()%>"> <%=movie.getLanguage()%></option>
        <option >English</option>
        <option >Kannada</option>
        <option >Hindi</option>
        <option >Telugu</option>
    </select>
    </td>
   </tr>
   <tr>
    <td><label for="">Rating:</label></td>
    <td> <input type="text" name="Rating" value="<%=movie.getRating() %>"></td>
    </tr>   
    <tr>
        <td><label for="">Image</label></td>
        <td><input type="file" name="image" id=""></td>
        <td><img height="75px" width="75px" alt="<%=movie.getName()%>" src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getImage()) %>"></td>
    </tr>
    <tr>
        <td><label for="">Genre</label></td>
        <td><select name="Genre" >
        <option disabled selected value="<%=movie.getGenre() %>"><%=movie.getGenre() %></option>
        <option value="Comedy">Comedy</option>
        <option value="Horror">Horror</option>
        <option value="Action">Action</option>
        <option>Thriller</option>
        </select></td>
    </tr>
    <tr>
    <td>
    <button>Add</button>
    </td>
    </tr>
</form>
</table>
</div>
</body>
</html>