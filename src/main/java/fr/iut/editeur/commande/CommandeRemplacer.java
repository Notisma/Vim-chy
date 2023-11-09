package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {
    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 4) {
            System.err.println("Format attendu : remplacer;1;2;texte");
            return;
        }

        String texte = parameters[3];
        try {
            this.document.remplacer(Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2]), texte);
        }catch (NumberFormatException e) {
            System.err.println("erreur string à la place d'un int");
            return;
        }
        super.executer();
    }
}
