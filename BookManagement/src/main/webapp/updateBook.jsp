<%@ page import="model.Book" %>
<%
Book b = (Book) request.getAttribute("book");
if (b == null) {
%>
    <h2 style="text-align:center; color:#ff6b6b;">
        Book not found.
    </h2>
    <div style="text-align:center;">
        <a href="list">Back to List</a>
    </div>
<%
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>Update Book Details</header>

<form action="update" method="post">

    <input type="hidden" name="id" value="<%= b.getId() %>">

    <div class="field">
        <input type="text" name="title" value="<%= b.getTitle() %>" placeholder=" " required>
        <label>Book Title</label>
    </div>

    <div class="field">
        <input type="text" name="author" value="<%= b.getAuthor() %>" placeholder=" " required>
        <label>Author Name</label>
    </div>

    <div class="field">
        <input type="number" step="0.01" name="price" value="<%= b.getPrice() %>" placeholder=" " required>
        <label>Book Price</label>
    </div>

    <button type="submit">Update Book</button>

</form>

</body>
</html>
