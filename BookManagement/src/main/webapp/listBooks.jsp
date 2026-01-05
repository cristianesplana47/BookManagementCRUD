<%@ page import="java.util.*,model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Management System</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>Book Management</header>

<div class="table-wrapper">
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>

        <%
        List<Book> books = (List<Book>) request.getAttribute("books");
        if (books != null && !books.isEmpty()) {
            for(Book b : books){
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getPrice() %></td>
            <td class="actions">
                <a href="update?id=<%=b.getId()%>">Edit</a>
                <a href="delete?id=<%=b.getId()%>">Delete</a>
            </td>
        </tr>
        <% 
            }
        } else {
        %>
        <tr>
            <td colspan="5" style="text-align:center;">No books found.</td>
        </tr>
        <%
        }
        %>
    </table>
</div>

<!-- Add Book button below the table -->
<button class="add-new" onclick="location.href='addBook.jsp'">+ Add Book</button>

</body>
</html>
