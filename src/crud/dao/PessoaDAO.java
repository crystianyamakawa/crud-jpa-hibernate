package crud.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import crud.modelo.Banco;
import crud.modelo.Cidade;
import crud.modelo.Estado;
import crud.modelo.Pessoa;

public class PessoaDAO {

	 public List getPessoas(){
		 List ls = new List();
	      try {

			    String pessoas = "";
			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Pessoa> query = em.createQuery("from Pessoa", Pessoa.class);
				for (Pessoa pessoa : query.getResultList()) {
 					 pessoas = "";
		             pessoas += pessoa.getId() + " - ";
		             pessoas += pessoa.getNome() + " - ";
		             pessoas += pessoa.getTelefone() ;
		             ls.add(pessoas);
				}
				em.close();
				emf.close();
				return ls;
	      		} catch (Exception e) {
	      			e.printStackTrace();
	      			return ls;
	      		}
		 
		 
		 
	               
	    }  
	  
	  
	  public void addPessoa(String nome, String telefone, String endereco, String cidade)throws SQLException {
		  try {
	    	  	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	    	  	EntityManager em = emf.createEntityManager();
	  			Pessoa pessoa = new Pessoa();
	  			pessoa.setNome(nome);
	  			pessoa.setTelefone(telefone);
	  			pessoa.setEndereco(endereco);
	  			Cidade find = em.createQuery("from Cidade where nome like :nomeCidade", Cidade.class)
	  					        .setParameter("nomeCidade", cidade).getSingleResult();
	 			pessoa.setCidade(find);
	 		
	  			em.getTransaction().begin();
		  		em.persist(pessoa);
		  		em.getTransaction().commit();
		  		em.close();
		  		emf.close();
	      } catch (Exception e ) {
	    	  e.printStackTrace();	
	    	  throw new SQLException(e); 
	      }

	  }
	  
	  public List getPessoa(String id) {
		  List ls = new List();
		     try {

				    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
					EntityManager em = emf.createEntityManager();
					Pessoa pessoa = em.find(Pessoa.class, Long.parseLong(id));
		            ls.add("" + pessoa.getId());
			        ls.add(pessoa.getNome());
			        ls.add(pessoa.getTelefone());
			        ls.add(pessoa.getEndereco());				        
			        ls.add(pessoa.getCidade().getNome());

					em.close();
					emf.close();
				    return ls;
		      		} catch (Exception e) {
		      			// TODO Auto-generated catch block
		      			e.printStackTrace();
		      			return ls;
		      		} 	  
	          

				
	  } 
	  public void updatePessoa(String nome, String telefone,String endereco, String cidade, String id) throws SQLException {
		  try {
		    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		 		 EntityManager em = emf.createEntityManager();
		 		 em.getTransaction().begin();
		 		 Pessoa pessoa = em.find(Pessoa.class,Long.parseLong(id) );
		 		if (pessoa != null) {
		 			pessoa.setNome(nome);
		 			pessoa.setTelefone(telefone);
		 			pessoa.setEndereco(endereco);
		 			Cidade find = em.createQuery("from Cidade where nome like :nomeCidade", Cidade.class).setParameter("nomeCidade", cidade).getSingleResult();
		 			pessoa.setCidade(find);
		 			
		 		}
		 		em.getTransaction().commit();
		        em.close();
		    	emf.close();
		     } catch (Exception e) {
				    e.printStackTrace();
				    throw new SQLException(e); 
		     }

	  }//fim update
	  
	  public void delPessoa(String id) {
		  List ls = new List();
	      try {
	       
	    	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
			   EntityManager em = emf.createEntityManager();
			   em.getTransaction().begin();
		 	   Pessoa pessoa = em.find(Pessoa.class, Long.parseLong(id));
			   if (pessoa != null) {
		 			 em.remove(pessoa);
		 		 }
			   em.getTransaction().commit();
	           em.close();
		  	   emf.close();
	          } catch (Exception e) {
	  		    e.printStackTrace();
	          }
	  }// fim delete
	  
	  public List getComboPessoa(){
		  List ls = new List();
	     try {

			    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
				EntityManager em = emf.createEntityManager();
				TypedQuery<Pessoa> query = em.createQuery("from Pessoa", Pessoa.class);
				for (Pessoa pessoa : query.getResultList()) {
		            ls.add(pessoa.getNome());
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
