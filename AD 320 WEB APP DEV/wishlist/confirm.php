<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>The book has been added to the wishlist</title>
        <link rel="stylesheet" type="text/css" href="styles/frame.css">
        <link rel="stylesheet" type="text/css" href="styles/main.css">
    </head>
    <body>
        <?php
        include './templates/Header_Nav.php';
        $temp = $_POST["name"];
        echo <<<CONTENT
        <main>
            <h3>$temp has been added to the wishlist.</h3>
            <h3>Redirect to HOME in 5 seconds...</h3>
        </main>
CONTENT;
        include './templates/footer.php';
        header("refresh:5;url=index.php");
        ?>
    </body>
</html>