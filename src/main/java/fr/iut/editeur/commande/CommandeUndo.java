package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeUndo extends CommandeDocument {


    public CommandeUndo(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 1) {
            System.err.println("Format attendu : undo");
            return;
        }
        this.document.undo();
        super.executer();
    }

}