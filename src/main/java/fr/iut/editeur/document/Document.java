package fr.iut.editeur.document;

public class Document {
    private String etatPrecedent;
    private String etatSuivant;
    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public String getEtatPrecedent() {
        return etatPrecedent;
    }
    public void setEtatPrecedent(){
        etatPrecedent = getTexte();
    }
    public String getEtatSuivant(){
        return etatSuivant;
    }
    public void setEtatSuivant(){
        etatSuivant = getTexte();
    }

    public void ajouter(String texte) {
        setEtatPrecedent();
        this.texte += texte;
    }
    public void remplacer(int start, int end, String remplacement) {
        setEtatPrecedent();
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        setEtatPrecedent();
        String texteMaj = texte.substring(start, end);
        texteMaj = texteMaj.toUpperCase();
        remplacer(start, end, texteMaj);
    }

    public void effacer(int start, int end){
        setEtatPrecedent();
        remplacer(start, end, " ");
    }

    public void clear(){
        setEtatPrecedent();
        remplacer(0, this.texte.length(), "a");
    }

    public void undo(){
        if(getEtatPrecedent() != null) {
            setEtatSuivant();
            remplacer(0, this.texte.length(), getEtatPrecedent());
            this.etatPrecedent = null;
        }
        else{
            System.err.println("erreur undo null");
        }
    }

    public void redo(){
        if(getEtatSuivant() != null){
            setEtatPrecedent();
            remplacer(0, this.texte.length(), getEtatSuivant());
            this.etatSuivant = null;
        }
        else{
            System.err.println("erreur redo null");
        }
    }

    @Override
    public String toString() {
        return this.texte;
    }
}
