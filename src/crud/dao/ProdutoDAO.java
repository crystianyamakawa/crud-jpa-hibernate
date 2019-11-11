package crud.dao;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import crud.modelo.Pessoa;
import crud.modelo.Produto;


public class ProdutoDAO {

	  public List getProdutos(){
		  List ls = new List();

	      try {

			    String produtos = "";
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Produto> query = em.createQuery("from Produto", Produto.class);
				for (Produto produto : query.getResultList()) {
		            produtos = "";
		            produtos  += produto.getId() + " - ";
		            produtos  += produto.getNome() + " - ";
		            produtos  += produto.getValor() ;
		  		            		;;
		            ls.add(produtos);
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
	  
	  
	   
	  public void addProduto(String nome, float valor) {
		  try {
	  	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	  	  	EntityManager em = emf.createEntityManager();
				Produto produto = new Produto();
				produto.setNome(nome);
				produto.setValor(valor);
				
				
		  		em.getTransaction().begin();
		  		em.persist(produto);
		  		em.getTransaction().commit();
		  		em.close();
		  		emf.close();
	    } catch (Exception e ) {
	  	  e.printStackTrace();	    		
	    }

	  }
	  
	  public List getProduto(String id) {
		  List ls = new List();
	      try {
	       
	    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			   EntityManager em = emf.createEntityManager();
			   Produto produto = em.find(Produto.class, Long.parseLong(id));
			       
		       ls.add(""+produto.getId());
	           ls.add(produto.getNome());
	           ls.add(""+produto.getValor());
	           
	           em.close();
		  	   emf.close();
	           return ls;

	          } catch (Exception e) {
	  		    e.printStackTrace();
	  		    return ls;
	          }       
	    	        
	  } 
	  public void updateProduto(String nome, float valor, String id) {
		  try {
		    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		 		 EntityManager em = emf.createEntityManager();
		 		 em.getTransaction().begin();
		 		 Produto produto = em.find(Produto.class,Long.parseLong(id) );
		 		if (produto != null) {
		 			produto.setNome(nome);
		 			produto.setValor(valor);
					
		 		}
		 		em.persist(produto);
		 		em.getTransaction().commit();
		        em.close();
		    	emf.close();
		     } catch (Exception e) {
				    e.printStackTrace();
		     }
	  

	  }//fim update
	  
	  public void delProduto(String id) {
		  try {
	     	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		 		 EntityManager em = emf.createEntityManager();
		 		 em.getTransaction().begin();
		 		 Produto produto = em.find(Produto.class,Long.parseLong(id) );
		 		 if (produto != null) {
		 			 em.remove(produto);
		 		 }
		 		 em.getTransaction().commit();
		 		 em.close();
		 		 emf.close();
		 	     } catch (Exception e) {
				    e.printStackTrace();			     
		     }
		  }// fim delete
	  
	  public List getComboProdutos(){
		  List ls = new List();
		     try {

				    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
					EntityManager em = emf.createEntityManager();
					TypedQuery<Produto> query = em.createQuery("from Produto", Produto.class);
					for (Produto produto : query.getResultList()) {
			            ls.add(produto.getNome());
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
	  public List getComboProduto(){
		  List ls = new List();
	     try {

			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Produto> query = em.createQuery("from Produto", Produto.class);
				for (Produto produto: query.getResultList()) {
		            ls.add(produto.getNome());
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
