package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Permet de remplacer ou de supprimer du contenu en donnant 2 index, et le nouveau texte qui va entre ces 2
 */
public class CommandeInserer extends CommandeDocument {

    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : inserer;<index>;<nouveau texte>");
            return;
        }
        int index = 0;
        try {
            index = Integer.parseInt(parameters[1]);
        } catch (NumberFormatException e) {
            System.err.println("L'index doit être un nombre !");
            return;
        }
        this.document.inserer(index, parameters[2]);
        super.executer();
    }

}
