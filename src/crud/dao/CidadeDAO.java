/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;



import crud.modelo.Cidade;
import crud.modelo.Estado;

import java.awt.List;





/**
 *
 * @author crystian
 */
public class CidadeDAO {
	

  public List getCidades(){
	  List ls = new List();

      try {

		    String cidades = "";
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			EntityManager em = emf.createEntityManager();
			TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
			for (Cidade cidade : query.getResultList()) {
	            cidades = "";
	            cidades  += cidade.getId() + " - ";
	            cidades  += cidade.getNome() ;
	            ls.add(cidades);
			}
			em.close();
			emf.close();
			return ls;
      		} catch (Exception e) {
      			e.printStackTrace();
      			return ls;
      		}
             
              
    
      //  	
    //;
    }  
  
  
   
  public void addCidade(String nome, String estado) {
	  try {
  	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
  	  	EntityManager em = emf.createEntityManager();
			Cidade cidade = new Cidade();
			cidade.setNome(nome);
			Estado find = em.createQuery("from Estado where nome like :nome", Estado.class)
				        .setParameter("nome", estado).getSingleResult();
		
			cidade.setEstado(find);
			//cidade.setIdEstado(find.getId());
			
			
	  		em.getTransaction().begin();
	  		em.persist(cidade);
	  		em.getTransaction().commit();
	  		em.close();
	  		emf.close();
    } catch (Exception e ) {
  	  e.printStackTrace();	    		
    }

  }
  
  public List getCidade(String id) {
	  List ls = new List();
      try {
       
    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		   EntityManager em = emf.createEntityManager();
		   Cidade cidade = em.find(Cidade.class, Long.parseLong(id));
		       
	       ls.add(""+cidade.getId());
           ls.add(cidade.getNome());
           ls.add(cidade.getEstado().getNome());
           
           em.close();
	  	   emf.close();
           return ls;

          } catch (Exception e) {
  		    e.printStackTrace();
  		    return ls;
          }       
    	        
  } 
  public void updateCidade(String nome, String estado, String id) {
	  try {
	    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	 		 EntityManager em = emf.createEntityManager();
	 		 em.getTransaction().begin();
	 		 Cidade cidade = em.find(Cidade.class,Long.parseLong(id) );
	 		if (cidade != null) {
	 			cidade.setNome(nome);
	 			Estado find = em.createQuery("from Estado where nome like :nome", Estado.class)
				        .setParameter("nome", estado).getSingleResult();
		
	 			cidade.setEstado(find);
					
				em.persist(cidade);
	 			
	 		}
	 		em.getTransaction().commit();
	        em.close();
	    	emf.close();
	     } catch (Exception e) {
			    e.printStackTrace();
	     }
  

  }//fim update
  
  public void delCidade(String id) {
	  try {
     	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	 		 EntityManager em = emf.createEntityManager();
	 		 em.getTransaction().begin();
	 		 Cidade cidade = em.find(Cidade.class,Long.parseLong(id) );
	 		 if (cidade != null) {
	 			 em.remove(cidade);
	 		 }
	 		 em.getTransaction().commit();
	 		 em.close();
	 		 emf.close();
	 	     } catch (Exception e) {
			    e.printStackTrace();			     
	     }
  }// fim delete
  
  public List getComboCidades(){
	  List ls = new List();
	     try {

			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
				for (Cidade cidade : query.getResultList()) {
		            ls.add(cidade.getNome());
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
  
}
