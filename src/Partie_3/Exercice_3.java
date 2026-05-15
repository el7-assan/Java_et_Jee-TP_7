package Partie_3;

public class Exercice_3 {
    /**
     * Lit un montant et propage les exceptions à l'appelant.
     */
    public static double lireMontant(String valeur) throws NumberFormatException, IllegalArgumentException {
        double montant = Double.parseDouble(valeur);
        if (montant < 0) {
            throw new IllegalArgumentException("Montant négatif non autorisé.");
        }
        return montant;
    }

    public static void main(String[] args) {
        String input = "invalide";
        
        System.out.println("--- Début du programme (Gestion centralisée dans main) ---");
        try {
            double res = lireMontant(input);
            System.out.println("Montant lu : " + res);
        } catch (NumberFormatException e) {
            System.out.println("Main a capturé une erreur technique : Format incorrect.");
        } catch (IllegalArgumentException e) {
            System.out.println("Main a capturé une erreur métier : " + e.getMessage());
        }
        System.out.println("--- Fin du programme ---");
    }
}
