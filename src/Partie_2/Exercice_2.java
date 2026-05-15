package Partie_2;

public class Exercice_2 {
    /**
     * Lit un montant à partir d'une chaîne et gère les erreurs localement.
     */
    public static double lireMontant(String valeur) {
        try {
            double montant = Double.parseDouble(valeur);
            if (montant < 0) {
                // Exception lancée manuellement pour une règle métier
                throw new IllegalArgumentException("Montant négatif non autorisé.");
            }
            return montant;
        } catch (NumberFormatException e) {
            // Exception générée automatiquement par la JVM lors du parsing
            System.out.println("Erreur locale : '" + valeur + "' n'est pas un nombre valide.");
            return 0.0; // Valeur par défaut
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur locale métier : " + e.getMessage());
            return 0.0; // Valeur par défaut
        }
    }

    public static void main(String[] args) {
        System.out.println("Résultat Test 1 : " + lireMontant("150.0"));
        System.out.println("Résultat Test 2 : " + lireMontant("abc"));
        System.out.println("Résultat Test 3 : " + lireMontant("-20.0"));
    }
}
