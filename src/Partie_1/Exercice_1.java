package Partie_1;

public class Exercice_1 {
    /**
     * Effectue un paiement en vérifiant le solde et le montant.
     * @throws Exception Exception métier si le solde est insuffisant ou montant invalide.
     */
    public static double effectuerPaiement(double montant, double solde) throws Exception {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être strictement positif.");
        }
        if (montant > solde) {
            throw new Exception("Solde insuffisant pour effectuer cette transaction.");
        }
        return solde - montant;
    }

    public static void main(String[] args) {
        double soldeInitial = 1000.0;
        double[] montantsATester = {500.0, -10.0, 1500.0};

        for (double m : montantsATester) {
            System.out.println("\nTentative de paiement de : " + m + " MAD");
            try {
                double nouveauSolde = effectuerPaiement(m, soldeInitial);
                System.out.println("Paiement réussi. Nouveau solde : " + nouveauSolde + " MAD");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur de saisie : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur métier : " + e.getMessage());
            } finally {
                // Bloc exécuté dans tous les cas pour le nettoyage ou log de fin
                System.out.println("Fin de la transaction");
            }
        }
    }
}
