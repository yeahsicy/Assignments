<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Create a book</title>
        <link rel="stylesheet" type="text/css" href="styles/frame.css">
        <link rel="stylesheet" type="text/css" href="styles/form.css">
    </head>
    <body>
        <?php
        include './templates/Header_Nav.php';
        echo<<<SUB
        <main>
            <form action="confirm.php" method="post">
                Book Name: <br>
                <input type="text" name="name" required><br>
                Author: <br>
                <input type="text" name="author" required><br>
                Genre: <br>
                <input type="radio" name="genre" value="non-fiction">
                non-fiction
                <input type="radio" name="genre" value="horror">
                horror
                <input type="radio" name="genre" value="mystery">
                mystery
                <input type="radio" name="genre" value="classic">
                classic
                <input type="radio" name="genre" value="other">
                other
                <br>
                ISBN: <br>
                <input type="number" name="isbn"><br>
                <input type="submit">
            </form>
        </main>
SUB;
        include './templates/footer.php';
        ?>
    </body>
</html>
