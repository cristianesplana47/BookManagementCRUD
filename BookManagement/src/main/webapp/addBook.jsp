<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>Add Book</header>

<form id="addForm" action="add" method="post">

    <div class="field">
        <input type="text" name="title" placeholder=" " required>
        <label>Book Title</label>
    </div>

    <div class="field">
        <input type="text" name="author" placeholder=" " required>
        <label>Author Name</label>
    </div>

    <div class="field">
        <input type="number" name="price" placeholder=" " required>
        <label>Price</label>
    </div>

    <!-- Save button below the form -->
    <button type="submit">Save Book</button>
</form>

</body>
</html>
