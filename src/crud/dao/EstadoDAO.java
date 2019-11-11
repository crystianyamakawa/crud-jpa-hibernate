/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;



import crud.modelo.Estado;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author crystian
 */
public class EstadoDAO {
	

  public List getEstados(){
	  List ls = new List();
      try {

		    String estados = "";
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			EntityManager em = emf.createEntityManager();
			TypedQuery<Estado> query = em.createQuery("from Estado", Estado.class);
			for (Estado estado : query.getResultList()) {
	            estados = "";
	            estados += estado.getId() + " - ";
	            estados += estado.getSigla() + " - ";
	            estados += estado.getNome() ;
	            ls.add(estados);
			}
			em.close();
			emf.close();
			return ls;
      		} catch (Exception e) {
      			e.printStackTrace();
      			return ls;
      		}
    }  
  
  public List getComboEstados(){
	  List ls = new List();
     try {

		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			EntityManager em = emf.createEntityManager();
			TypedQuery<Estado> query = em.createQuery("from Estado", Estado.class);
			for (Estado estado : query.getResultList()) {
	            ls.add(estado.getNome());
			}
			em.close();
			emf.close();
		    return ls;
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      			return ls;
      		}
    }  
  
  public void addEstado(String sigla, String nome) throws SQLException  {
      try {
    	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
    	  	EntityManager em = emf.createEntityManager();
  			Estado estado = new Estado();
  			estado.setNome(nome);
  			estado.setSigla(sigla);
	  		em.getTransaction().begin();
	  		em.persist(estado);
	  		em.getTransaction().commit();
	  		em.close();
	  		emf.close();
      } catch (Exception e ) {
    	  e.printStackTrace();	
    	  throw new SQLException(e); 
    	  
      		
      }

  }
  
  public List getEstado(String id) {
	  List ls = new List();
      try {
       
    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		   EntityManager em = emf.createEntityManager();
		   Estado estado = em.find(Estado.class, Long.parseLong(id));

	       ls.add(""+estado.getId());
           ls.add(estado.getSigla());
           ls.add(estado.getNome());
           em.close();
	  	   emf.close();
           return ls;

          } catch (Exception e) {
  		    e.printStackTrace();
  		    return ls;
          }
  } 
  public void updateEstado(String sigla, String nome, String id) throws SQLException {
     try {
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
 		 EntityManager em = emf.createEntityManager();
 		 em.getTransaction().begin();
 		 Estado estado = em.find(Estado.class,Long.parseLong(id) );
 		if (estado != null) {
 			estado.setSigla(sigla);
 			estado.setNome(nome);
 		}
 		em.getTransaction().commit();
        em.close();
    	emf.close();
     } catch (Exception e) {
		    e.printStackTrace();
		    throw new SQLException(e); 
     }

  }//fim update
  
  public void delEstado(String id) {
	  try {
        	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	 		 EntityManager em = emf.createEntityManager();
	 		 em.getTransaction().begin();
	 		 Estado estado = em.find(Estado.class,Long.parseLong(id) );
	 		 if (estado != null) {
	 			 em.remove(estado);
	 		 }
	 		 em.getTransaction().commit();
	 		 em.close();
	 		 emf.close();
	 	     } catch (Exception e) {
			    e.printStackTrace();			     
	     }
  }// fim delete
  
  
}
