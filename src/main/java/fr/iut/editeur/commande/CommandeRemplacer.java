package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {
    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : ajouter;texte");
            return;
        }

        String texte = parameters[1];
        try {
            this.document.remplacer(Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2]), texte);
        }catch (NumberFormatException e) {
            System.err.println("erreur string à la place d'un int");
            return;
        }
        super.executer();
    }
}
