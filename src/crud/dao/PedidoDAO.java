package crud.dao;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import crud.modelo.Cidade;
import crud.modelo.Estado;
import crud.modelo.Pedido;
import crud.modelo.Pessoa;

public class PedidoDAO {
	 public List getPedidos(){
		  List ls = new List();

	      try {

			    String pedidos = "";
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Pedido> query = em.createQuery("from Pedido", Pedido.class);
				for (Pedido pedido : query.getResultList()) {
		            pedidos = "";
		            pedidos  += pedido.getId() + " - ";
		            pedidos  += pedido.getCliente().getNome() + " - ";
		            pedidos  += pedido.getValor() ;
		  		            		
		            ls.add(pedidos);
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
	  
	  
	   
	  public void addPedido(String data,String cliente, float valor) {
		  try {
	  	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	  	  	EntityManager em = emf.createEntityManager();
				Pedido pedido = new Pedido();
				pedido.setDtPedido(data);
				Pessoa find = em.createQuery("from Pessoa where nome like :nomePessoa", Pessoa.class).setParameter("nomePessoa", cliente).getSingleResult();
	 		    pedido.setCliente(find);
				
				pedido.setValor(valor);
				
				
		  		em.getTransaction().begin();
		  		em.persist(pedido);
		  		em.getTransaction().commit();
		  		em.close();
		  		emf.close();
	    } catch (Exception e ) {
	  	  e.printStackTrace();	    		
	    }

	  }
	  
	  public List getPedido(String id) {
		  List ls = new List();
	      try {
	       
	    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			   EntityManager em = emf.createEntityManager();
			   Pedido pedido = em.find(Pedido.class, Long.parseLong(id));
			       
		       ls.add(""+pedido.getId());
		       ls.add(""+pedido.getDtPedido());
	           ls.add(pedido.getCliente().getNome());
	           ls.add(""+pedido.getValor());
	           
	           em.close();
		  	   emf.close();
	           return ls;

	          } catch (Exception e) {
	  		    e.printStackTrace();
	  		    return ls;
	          }       
	    	        
	  } 
	  public void updatePedido(String data, String cliente, float valor, String id) {
		  try {
		    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		 		 EntityManager em = emf.createEntityManager();
		 		 em.getTransaction().begin();
		 		 Pedido pedido = em.find(Pedido.class,Long.parseLong(id) );
		 		if (pedido != null) {
		 			
					Pessoa find = em.createQuery("from Pessoa where nome like :nomePessoa", Pessoa.class).setParameter("nomePessoa", cliente).getSingleResult();
		 		    pedido.setCliente(find);
					pedido.setDtPedido(data);
					pedido.setValor(valor);
					
		 		}
		 		em.persist(pedido);
		 		em.getTransaction().commit();
		        em.close();
		    	emf.close();
		     } catch (Exception e) {
				    e.printStackTrace();
		     }
	  

	  }//fim update
	  
	  public void delPedido(String id) {
		  try {
	     	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		 		 EntityManager em = emf.createEntityManager();
		 		 em.getTransaction().begin();
		 		 Pedido pedido = em.find(Pedido.class,Long.parseLong(id) );
		 		 if (pedido != null) {
		 			 em.remove(pedido);
		 		 }
		 		 em.getTransaction().commit();
		 		 em.close();
		 		 emf.close();
		 	     } catch (Exception e) {
				    e.printStackTrace();			     
		     }
	  }// fim delete
	  

}
