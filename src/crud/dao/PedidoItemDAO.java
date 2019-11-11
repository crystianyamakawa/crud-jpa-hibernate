package crud.dao;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import crud.modelo.Pedido;
import crud.modelo.PedidoItem;
import crud.modelo.Pessoa;
import crud.modelo.Produto;

public class PedidoItemDAO {

	public List getPedidoItems(String pedidoId){
			  List ls = new List();

		      try {
//					System.out.println("Inicio Itens");  
				    String items = "";
				    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
					EntityManager em = emf.createEntityManager();
					Pedido pedido = em.find(Pedido.class, Long.parseLong(pedidoId));
//					System.out.println("Itens");   
					//for (PedidoItem item : pedido.getItems()) {
						
					TypedQuery<PedidoItem> query = em.createQuery("from PedidoItem where pedido = :pedido", PedidoItem.class).setParameter("pedido", pedido);
					//TypedQuery<PedidoItem> query = em.createQuery("from PedidoItem" , PedidoItem.class);
					for (PedidoItem item : query.getResultList()) {
					    items = "";
					    //items  += item.getPedido().toString() + " - ";
			            items  += item.getId() + " - ";
			            items  += item.getProduto().getNome() + " - ";
			            items  += item.getQuantidade() + " - ";
			            items  += item.getValor() ;
			            System.out.println(items);        		
			            ls.add(items);
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
		  
		  
		   
		  public void addPedidoItem(String produto,int quantidade, float valor,String pedidoId) {
			  try {
		  	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		  	  	EntityManager em = emf.createEntityManager();
					PedidoItem item = new PedidoItem();
					Produto find = em.createQuery("from Produto where nome like :nomeProduto", Produto.class).setParameter("nomeProduto", produto).getSingleResult();
		 		    item.setProduto(find);
		 		    item.setQuantidade(quantidade);
					item.setValor(valor);
					Pedido pedido = em.find(Pedido.class, Long.parseLong(pedidoId));
					item.setPedido(pedido);
					
			  		em.getTransaction().begin();
			  		em.persist(item);
			  		em.getTransaction().commit();
			  		em.close();
			  		emf.close();
		    } catch (Exception e ) {
		  	  e.printStackTrace();	    		
		    }

		  }
		  
		  public List getPedidoItem(String id) {
			  List ls = new List();
		      try {
		       
		    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				   EntityManager em = emf.createEntityManager();
				   PedidoItem item = em.find(PedidoItem.class, Long.parseLong(id));
				       
			       ls.add(""+item.getId());
		           ls.add(item.getProduto().getNome());
		           ls.add(""+item.getQuantidade());
		           ls.add(""+item.getValor());
		           
		           em.close();
			  	   emf.close();
		           return ls;

		          } catch (Exception e) {
		  		    e.printStackTrace();
		  		    return ls;
		          }       
		    	        
		  } 
		  public void updatePedidoItem(String produto,int quantidade, float valor, String idPedido,String idItem) {
			  try {
			    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			 		 EntityManager em = emf.createEntityManager();
			 		 em.getTransaction().begin();
			 		 PedidoItem item = em.find(PedidoItem.class,Long.parseLong(idItem) );
			 		if (item != null) {
			 			
						Produto find = em.createQuery("from Produto where nome like :nome", Produto.class).setParameter("nome", produto).getSingleResult();
			 		    item.setProduto(find);
			 		    item.setQuantidade(quantidade);
						item.setValor(valor);
						Pedido pedido = em.find(Pedido.class,Long.parseLong(idPedido) );
					 	item.setPedido(pedido);
			 		    
			 		}
			 		em.persist(item);
			 	 	em.getTransaction().commit();
			        em.close();
			    	emf.close();
			     } catch (Exception e) {
					    e.printStackTrace();
			     }
		  

		  }//fim update
		  
		  public void delPedidoItem(String id) {
			  try {
		     	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			 		 EntityManager em = emf.createEntityManager();
			 		 em.getTransaction().begin();
			 		 PedidoItem item = em.find(PedidoItem.class,Long.parseLong(id) );
			 		 if (item != null) {
			 			 em.remove(item);
			 		 }
			 		 em.getTransaction().commit();
			 		 em.close();
			 		 emf.close();
			 	     } catch (Exception e) {
					    e.printStackTrace();			     
			     }
		  }// fim delete
		  


}
