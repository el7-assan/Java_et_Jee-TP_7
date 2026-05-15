# TP 7 Java – Les Exceptions
## NOM : EL OMARI LAHCEN  
## Lien vers le projet : https://github.com/el7-assan/Java_et_Jee-TP_7.git


#### Pour réaliser ce document, j’ai rédigé le contenu dans un fichier Markdown (.md), puis je l’ai converti en format PDF à l’aide d’une extension de Visual Studio Code.


## Partie 1 : Gestion des erreurs de paiement

### Classe `Exercice_1.java`
```java
package Partie_1;

public class Exercice_1 {
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
        try {
            double nouveauSolde = effectuerPaiement(1500.0, soldeInitial);
            System.out.println("Paiement réussi. Nouveau solde : " + nouveauSolde);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de saisie : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur métier : " + e.getMessage());
        } finally {
            System.out.println("Fin de la transaction");
        }
    }
}
```

**Réponses aux questions :**
*   **Q3 : Pourquoi le bloc finally est exécuté dans tous les cas ?**  
    Le bloc `finally` est conçu pour garantir l'exécution de certaines instructions (comme la fermeture de fichiers ou de connexions), qu'une exception ait été levée ou non, et même si un bloc `catch` a traité l'erreur.
*   **Q4 : Différence entre erreur technique et erreur métier :**
    *   **Erreur technique :** Liée à une défaillance du système ou de l'infrastructure (ex: `NullPointerException`, base de données inaccessible).
    *   **Erreur métier :** Liée aux règles spécifiques de l'application (ex: solde insuffisant, âge minimum non atteint).

---

## Partie 2 : Gestion locale des exceptions

### Classe `Exercice_2.java`
```java
package Partie_2;

public class Exercice_2 {
    public static double lireMontant(String valeur) {
        try {
            double montant = Double.parseDouble(valeur);
            if (montant < 0) throw new IllegalArgumentException("Négatif non autorisé.");
            return montant;
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Valeur non numérique.");
            return 0.0;
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
            return 0.0;
        }
    }
}
```

**Réponses aux questions :**
*   **Q6 : Différence entre exception automatique et lancée manuellement :**  
    Une exception **automatique** est générée par la JVM (ex: division par zéro). Une exception **manuelle** est lancée par le développeur avec le mot-clé `throw` pour signaler une condition invalide définie par lui.

---

## Partie 3 : Propagation des exceptions

### Classe `Exercice_3.java`
```java
package Partie_3;

public class Exercice_3 {
    public static double lireMontant(String valeur) throws NumberFormatException, IllegalArgumentException {
        double montant = Double.parseDouble(valeur);
        if (montant < 0) throw new IllegalArgumentException("Négatif.");
        return montant;
    }

    public static void main(String[] args) {
        try {
            lireMontant("abc");
        } catch (Exception e) {
            System.out.println("Capturé dans main : " + e.getMessage());
        }
    }
}
```

**Réponses aux questions :**
*   **Q10 : Que se passe-t-il si aucune gestion n'est effectuée dans main ?**  
    Le programme s'arrête brutalement (crash) et affiche la trace de l'erreur (Stack Trace) à l'utilisateur.
*   **Q11 : Quand préférer la propagation ?**  
    Il est préférable de propager une exception lorsque la méthode actuelle ne sait pas comment résoudre l'erreur ou lorsque la décision de gestion doit être prise par un niveau supérieur (ex: afficher une alerte UI).

---

## Partie 4 : Accès à une ressource interne

### Classe `Exercice_4.java`
```java
package Partie_4;

public class Exercice_4 {
    public static double lireTransaction(double[] tab, int index) {
        return tab[index];
    }

    public static void main(String[] args) {
        try {
            double[] t = {10.0};
            lireTransaction(t, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice invalide !");
        } catch (NullPointerException e) {
            System.out.println("Tableau null !");
        }
    }
}
```

**Réponses aux questions :**
*   **Q14 : Que se passe-t-il si l'index est valide mais le tableau est plus petit que prévu ?**  
    Si l'index demandé est supérieur ou égal à la taille réelle du tableau (`tab.length`), une exception `ArrayIndexOutOfBoundsException` sera levée, même si l'index semble "logiquement" valide dans le contexte de l'application.
