public class Programmeur {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String hobby;
    private String responsable;
    private int anNaissance;
    private double salaire;
    private double prime;

    // Constructor
    public Programmeur(int id, String nom, String prenom, String adresse, String pseudo, String hobby,
                       String responsable, int anNaissance, double salaire, double prime) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.pseudo = pseudo;
        this.hobby = hobby;
        this.responsable = responsable;
        this.anNaissance = anNaissance;
        this.salaire = salaire;
        this.prime = prime;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public int getAnNaissance() { return anNaissance; }
    public void setAnNaissance(int anNaissance) { this.anNaissance = anNaissance; }

    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    public double getPrime() { return prime; }
    public void setPrime(double prime) { this.prime = prime; }

    @Override
    public String toString() {
        return "Id : " + this.getId() + "\n" +
                "Nom : " + this.getNom() + "\n" +
                "Prénom : " + this.getPrenom() + "\n" +
                "Adresse : " + this.getAdresse() + "\n" +
                "Pseudo" + this.getPseudo() + "\n" +
                "Responsable : " + this.getResponsable() + "\n" +
                "Hobby : " + this.getHobby() + "\n" +
                "Naissance : " + this.getAnNaissance() + "\n" +
                "Salaire : " + this.getSalaire() + "\n" +
                "Prime : " + this.getPrime() + "\n" +
                "--------------------";
    }
}
