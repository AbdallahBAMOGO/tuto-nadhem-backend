package com.bamos.tuto;

import com.bamos.tuto.model.Categorie;
import com.bamos.tuto.model.Produit;
import com.bamos.tuto.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class TutoApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateProduit(){
        Produit prod = new Produit("iphone x", 453.32, new Date());
        produitRepository.save(prod);
    }

    @Test
    public void testFindProduit(){
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);

        Optional<Produit> op = produitRepository.findById(1L);
        System.out.println(op.get());
    }

    @Test
    public void testUpdateProduit(){
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(500.5);
        produitRepository.save(p);
    }

    @Test
    public void testDeleteProduit(){
        produitRepository.deleteById(1L);
    }

    @Test
    public void testListerTousProduits(){
        List<Produit> produitList = produitRepository.findAll();

        for (Produit p: produitList){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomProduit(){
        List<Produit> prods = produitRepository.findByNomProduit("iphone x");
        for (Produit p : prods){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomProduitContains(){
        List<Produit> prods = produitRepository.findByNomProduitContains("iphone x");
        for (Produit p : prods){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomPrix(){
        List<Produit> prods = produitRepository.findByNomPrix("iphone x",453.32);
        for (Produit p : prods){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomPrixOther(){
        List<Produit> prods = produitRepository.findByNomPrixOther("iphone x",453.32);
        for (Produit p : prods){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorie(){
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods){
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorieIdCat(){
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods){
            System.out.println(p);
        }
    }

}
