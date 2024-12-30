public class Programmeur {
    private int id;
    private String nom;
    private String prenom;
    private int anNaissance;
    private double salaire;
    private double prime;

    // Constructor
    public Programmeur(int id, String nom, String prenom, int anNaissance, double salaire, double prime) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
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

    public int getAnNaissance() { return anNaissance; }
    public void setAnNaissance(int anNaissance) { this.anNaissance = anNaissance; }

    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    public double getPrime() { return prime; }
    public void setPrime(double prime) { this.prime = prime; }

    @Override
    public String toString() {
        return "Programmeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", anNaissance=" + anNaissance +
                ", salaire=" + salaire +
                ", prime=" + prime +
                '}';
    }
}

