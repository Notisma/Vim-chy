package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeEffacer extends CommandeDocument {


    public CommandeEffacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : ajouter;texte");
            return;
        }
        try {
            this.document.effacer(Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2]));
        }catch (NumberFormatException e) {
            System.err.println("erreur string à la place d'un int");
            return;
        }
        super.executer();
    }

}