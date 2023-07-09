<?php
if (isset($_GET["password"])) {
    $password = $_GET["password"];
    if ($password == "aabza") {
        echo "Mot de passe trouvé";
    } else {
        echo "Ce n'est pas le bon mot de passe";
    }
} else {
    ?>
    <!DOCTYPE html>
    <html lang="fr">
    <head>
        <title>Document</title>
    </head>
    <body>
        <form method="GET">
            <input type="password" name="password">
            <input type="submit" value="Valider">
        </form>
    </body>
    </html>
<?php } ?>
