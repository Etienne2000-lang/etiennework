import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    Etudiant[] classe = new Etudiant[5];

    for (int i = 0; i < 5; i++) {
      System.out.println("Saisie de l'étudiant n°" + (i + 1));
      System.out.print("Matricule de l'etudiant : ");
      String matricule = reader.next();
      System.out.print("Nom de l'etudiant : ");
      String nom = reader.next();
      System.out.print("Note 1 de l'etudiant : ");
      double note1 = reader.nextDouble();
      System.out.print("Note 2 de l'etudiant : ");
      double note2 = reader.nextDouble();
      System.out.print("Note 3 de l'etudiant : ");
      double note3 = reader.nextDouble();

      classe[i] = new Etudiant(matricule, nom, note1, note2, note3);
    }

    System.out.println("\nLA LISTE DES ETUDIANTS");
    for (Etudiant e : classe) {
      e.affichage();
    }
    calcularStats(classe);
    // TRI
    trierParMoyenne(classe);
    System.out.println("\nTRI");
    for (Etudiant e : classe) {
      e.affichage();
    }

    // RECHERCHE
    System.out.print("\nVeuillez entrer la matricule à rechercher : ");
    String mat = reader.next();

    Etudiant trouve = rechercherParMatricule(classe, mat);

    if (trouve != null) {
      System.out.println("Etudiant trouvé : " + trouve.getNom());

      // MODIFICATION
      System.out.println("Modification des différentes notes...");
      System.out.print("Nouvelle note 1 : ");
      double not1 = reader.nextDouble();
      System.out.print("Nouvelle note 2 : ");
      double not2 = reader.nextDouble();
      System.out.print("Nouvelle note 3 : ");
      double not3 = reader.nextDouble();
      modifierNotes(trouve, not1, not2, not3);
      System.out.println("Notes modifiées avec succès !");
    } else {
      System.out.println("Etudiant introuvable dans la liste");
    }
  }
  public static void calcularStats(Etudiant[] classe) {
    double Moy = 0;
    int eadmis = 0;
    Etudiant meilleur = classe[0];

    for (Etudiant et : classe) {
      double moy = et.calmoy();
      Moy += moy;

      if (moy >= 10) {
        eadmis++;
      }

      if (moy > meilleur.calmoy()) {
        meilleur = et;
      }
    }

    System.out.println("\n--- STATISTIQUES ---");
    System.out.printf("Moyenne générale de la classe est: %.2f%n", (Moy / 5));
    System.out.println("Meilleur étudiant est: " + meilleur.getNom() + " avec " + meilleur.calmoy());
    System.out.println("Nombre d'étudiants admis est: " + eadmis);
  }


  public static void trierParMoyenne(Etudiant[] classe) {
    for (int i = 0; i < classe.length - 1; i++) {
      for (int j = i + 1; j < classe.length; j++) {
        if (classe[i].calmoy() < classe[j].calmoy()) {
          Etudiant temp = classe[i];
          classe[i] = classe[j];
          classe[j] = temp;
        }
      }
    }
  }
  public static Etudiant rechercherParMatricule(Etudiant[] classe, String mat) {
    for (Etudiant e : classe) {
      if (e.getMatricule().equals(mat)) {
        return e;
      }
    }
    return null;
  }
  public static void modifierNotes(Etudiant e, double note1, double note2, double note3) {
    e.setNotes(note1, note2, note3);
  }
}