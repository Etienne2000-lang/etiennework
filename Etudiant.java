public class Etudiant {
  private String matricule;
  private String nom;
  private double note1;
  private double note2;
  private double note3;

  //INITIALISATION DES VARIABLES GBLOBALES dans le constructeur
  public Etudiant(String matricule, String nom, double note1, double note2, double note3) {
    this.matricule = matricule;
    this.nom = nom;
    this.note1 = note1;
    this.note2 = note2;
    this.note3 = note3;
  }

  //FONCTION CALCUL DE LA MOYENNE
  public double calmoy() {
    return (note1 + note2 + note3) / 3;
  }

  //DECLARATION DE LA FONCTION QUI VA RETOURNER LA MENTION DE CHAQUE MOYENNE
  public String mention() {
    double moy = calmoy();
    String mention;
    if (moy >= 16) mention = "Excellent";
    else if (moy >= 14) mention = "Bien";
    else if (moy >= 12) mention = "Assez bien";
    else if (moy >= 10) mention = "Passable";
    else mention = "Ajournée";

    return mention;
  }

  //AFFICHAGE ET RECUPERATION DES DONNEES
  public void affichage() {
    System.out.println("matricule de l'etudiant est : " + matricule);
    System.out.println(" nom de l etudiant" + nom);
    System.out.printf("Moyenne : %.2f\n", calmoy());
    System.out.println("Mention : " + mention());
    System.out.println("\n");
  }

  public String getMatricule() {
    return matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNotes(double note1, double note2, double note3) {
    this.note1 = note1;
    this.note2 = note2;
    this.note3 = note3;
  }
}

