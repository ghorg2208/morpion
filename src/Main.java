import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Grille grille = new Grille();

        while (true) {
            grille.initialiserGrille();
            char joueurActuel = 'X';

            while (!grille.partieTerminee()) {
                grille.afficherGrille();
                int ligne = demanderCoordonnee("ligne", scanner) -1 ;
                int colonne = demanderCoordonnee("colonne", scanner) -1;

                if (grille.getCase(ligne, colonne) == '.') {
                    grille.setCase(ligne, colonne, joueurActuel);
                    if (grille.conditionVictoire(joueurActuel)) {
                        System.out.println("Le joueur " + joueurActuel + " a gagné !");
                        grille.afficherGrille();
                        break;
                    }
                    joueurActuel = grille.joueurSuivant(joueurActuel);
                } else {
                    System.out.println("Case déjà occupée, choisissez une autre case !");
                }
            }

            if (grille.grillePleine() && !grille.partieTerminee()) {
                System.out.println("Match nul !");
            }

            if (!rejouer(scanner)) {
                break;
            }
        }
    }

    private static int demanderCoordonnee(String coordonnee, Scanner scanner) {
        int valeur;
        do {
            System.out.print("Entrez la " + coordonnee + " souhaitée (1 à 3) : ");
            valeur = scanner.nextInt();
            scanner.nextLine();
        } while (valeur < 1 || valeur > 3);
        return valeur;
    }

    private static boolean rejouer(Scanner scanner) {
        System.out.print("Voulez-vous rejouer ? (O/N) : ");
        String reponse = scanner.nextLine();
        return reponse.equalsIgnoreCase("O");
    }
}