import java.util.Arrays;
import java.util.Scanner;

public class Grille {

    private char[][] grille = new char[3][3];

    public void initialiserGrille() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grille[i], '.');
        }
    }

    public void afficherGrille() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public char getCase(int ligne, int colonne) {
        return grille[ligne][colonne];
    }

    public void setCase(int ligne, int colonne, char joueur) {
        grille[ligne][colonne] = joueur;
    }

    public char joueurSuivant(char joueurActuel) {
        if (joueurActuel == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }



    public boolean grillePleine() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean conditionVictoire(char joueur) {
        // Vérification des lignes
        for (int i = 0; i < 3; i++) {
            if (grille[i][0] == joueur && grille[i][1] == joueur && grille[i][2] == joueur) {
                return true;
            }
        }
        // Vérification des colonnes
        for (int j = 0; j < 3; j++) {
            if (grille[0][j] == joueur && grille[1][j] == joueur && grille[2][j] == joueur) {
                return true;
            }
        }
        // Vérification des diagonales
        if (grille[0][0] == joueur && grille[1][1] == joueur && grille[2][2] == joueur) {
            return true;
        }
        if (grille[0][2] == joueur && grille[1][1] == joueur && grille[2][0] == joueur) {
            return true;
        }
        return false;
    }

    public boolean partieTerminee() {
        return conditionVictoire('X') || conditionVictoire('O') || grillePleine();
    }


}