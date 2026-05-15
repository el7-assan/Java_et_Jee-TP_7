package Partie_4;

public class Exercice_4 {
    public static double lireTransaction(double[] tab, int index) {
        return tab[index];
    }

    public static void main(String[] args) {
        double[] transactions = {10.5, 20.0, 35.7};
        double[] tabNull = null;

        System.out.println("--- Test Accès Ressource ---");
        
        // Test 1 : Indice invalide
        try {
            System.out.println(lireTransaction(transactions, 10));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur capturée : Indice 10 hors limites pour le tableau.");
        }

        // Test 2 : Tableau null
        try {
            System.out.println(lireTransaction(tabNull, 0));
        } catch (NullPointerException e) {
            System.out.println("Erreur capturée : Tentative d'accès à un tableau non initialisé (null).");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur d'indice.");
        }
    }
}
