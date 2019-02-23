/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author AKTHEM
 */
public class produit {
    private int id;
    private String nom;
    private Float prix;
    private int quantite;
    private String image;
    private String type;
    private float prix_initial;

    public produit(int id, String nom, Float prix, float prix_initial, int quantite, String image, String categorie, String type) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prix_initial = prix_initial;
        this.quantite = quantite;
        this.image = image;
       this.categorie = categorie;
       this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix_initial() {
        return prix_initial;
    }

    public void setPrix_initial(float prix_initial) {
        this.prix_initial = prix_initial;
    }
    

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public produit(int id, String nom, Float prix, int quantite, String image, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.image = image;
        this.categorie = categorie;
    }
    private String categorie;

    public produit() {
    }
public produit( String nom, Float prix,int quantite, String image) {
        
        this.nom = nom;
        this.prix = prix;
        this.quantite=quantite;
        this.image = image;
        
    }
    public produit(int id, String nom, Float prix,int quantite, String image) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite=quantite;
        this.image = image;
        
    }
    public produit(int id, String nom, Float prix,String image) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image=image;
        
        
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Float getPrix() {
        return prix;
    }
     public int getQuantite() {
        return quantite;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
     public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "l'ID du pruduit est :  " + id +"\n"+ "le nom du produit est :  " + nom +"\n"+ "le prix du produit est :  " + prix +"\n"+ "le quantité du produit est : " + quantite +"\n";
    }
    
    
}
