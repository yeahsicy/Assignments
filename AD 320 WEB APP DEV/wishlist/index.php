<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Wishlist</title>
        <link rel="stylesheet" type="text/css" href="styles/frame.css">
        <link rel="stylesheet" type="text/css" href="styles/main.css">
    </head>
    <body>
        <?php
        include './templates/Header_Nav.php';
        echo<<<DES
        <main>
            <h3>Welcome! To add a book to your wishlist, please click CREATE button.</h3>
        </main>
DES;
        include './templates/footer.php';
        ?>
    </body>
</html>
