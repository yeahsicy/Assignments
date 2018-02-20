<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Find Book</title>
    </head>
    <body>
        <?php
        echo <<<FORM
        <form action="index.php" method="get">
            Search ISBN: 
            <input type="text" name="isbn" title="Invalid ISBN! " pattern="(?:(?=.{17}$)97[89][ -](?:[0-9]+[ -]){2}[0-9]+[ -][0-9]|97[89][0-9]{10}|(?=.{13}$)(?:[0-9]+[ -]){2}[0-9]+[ -][0-9Xx]|[0-9]{9}[0-9Xx])">
            <input type="submit">
        </form>
FORM;
        $isbn = $_GET["isbn"];
        if ($isbn == NULL)
            exit();
        $url = "https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn";
        $init = curl_init();

        curl_setopt($init, CURLOPT_URL, $url);
        curl_setopt($init, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($init, CURLOPT_FOLLOWLOCATION, true);
        curl_setopt($init, CURLOPT_HTTPGET, true);

        $data = curl_exec($init);
        curl_close($init);
        $info = json_decode($data);
        if ($info->totalItems == 0) {
            echo "<br>Not found! ";
            exit();
        }

        function ListInfo($list) {
            foreach ($list as $key => $value) {
                if (is_array($value) || is_object($value)) {
                    echo "$key: <br>";
                    ListInfo($value);
                } else
                    echo "$key: $value <br><br>";
            }
        }

        ListInfo($info->items[0]);
        ?>
    </body>
</html>
