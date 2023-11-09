package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRedo extends CommandeDocument {


    public CommandeRedo(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 1) {
            System.err.println("Format attendu : redo");
            return;
        }
        this.document.redo();
        super.executer();
    }

}