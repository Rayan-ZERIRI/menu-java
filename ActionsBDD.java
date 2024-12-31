public interface ActionsBDD {
    public List<Programmeur> getTousProgrammeurs();

    public Programmeur getProgrammeurInput(int id);

    public boolean supprimerProgrammeurInput(int id);

    public boolean ajouterProgrammeurInput(String nom, String prenom, int anNaissance, double salaire, double prime);

    public boolean modifierSalaireInput(int id, double salaire);

    public void terminerProgramme();
}
