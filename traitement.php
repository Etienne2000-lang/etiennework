
<?php
// la condition if permet de vérifier si le bouton envoyer a été cliqué
if (isset($_POST['envoyer'])) {

    // Récupération et sécurisation des données entrer dans le formulaire
    $nom     = htmlspecialchars(trim($_POST['nom']));
    $prenom  = htmlspecialchars(trim($_POST['prenom']));
    $age     = htmlspecialchars(trim($_POST['age']));
    $email   = htmlspecialchars(trim($_POST['email']));

    // Vérification si tous les champs ont été remplis
    if (!empty($nom) && !empty($prenom) && !empty($age) && !empty($email)) {

        echo "<h2>Bienvenue $nom $prenom</h2>";
        echo "<p>Vous avez $age ans.</p>";

    } else {
        echo "<p style='color:red;'>Tous les champs sont obligatoires.</p>";
    }

} else {
    echo "<p style='color:red;'>Accès non autorisé. Le bouton n'a pas été cliqué.</p>";
}
?>

