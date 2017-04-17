package br.edu.ifpb.resteasyapp.dao;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import br.edu.ifpb.resteasyapp.entidade.AutoAvaliacao;

import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class AutoAvaliacaoDAO extends GenericDao<Integer, AutoAvaliacao>{
	
private static AutoAvaliacaoDAO instance;
	
	public static AutoAvaliacaoDAO getInstance() {		
		instance = new AutoAvaliacaoDAO();		
		return instance;
	}
	
	@Override
	public List<AutoAvaliacao> getAll() throws SQLException {
		return super.getAll("AutoAvaliacao.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return AutoAvaliacao.class;
	}

	@Override
	public AutoAvaliacao find(AutoAvaliacao entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateByEntity(AutoAvaliacao autoAvaliacao) {
		// TODO Auto-generated method stub
		
	}

	public AutoAvaliacao findAutoAvaliacaoById(Integer id) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		AutoAvaliacao autoAvaliacao = null;
		
		try{

			String hql = "from AutoAvaliacao p "
				+ "where p.id like :id";
			
			Query query = session.createQuery(hql);
			
			query.setParameter("id", "%" + id + "%");
			
			autoAvaliacao = (AutoAvaliacao) query.uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return autoAvaliacao;
	}

	public List<AutoAvaliacao> getAutoAvaliacaoByCRM(String crm) throws SQLException {
		
Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<AutoAvaliacao> AutoAvaliacoes = null;
		
		try {
			
			String hql = "from AutoAvaliacao as a"
					+ " where a.crm like :crm";
			
			Query query = session.createQuery(hql);
			query.setParameter("crm", "%" + crm + "%");
			
			AutoAvaliacoes = (List<AutoAvaliacao>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return AutoAvaliacoes;

	}

	public List<AutoAvaliacao> getAutoAvaliacaoByCPF(String cpf) throws SQLException {
		
Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<AutoAvaliacao> AutoAvaliacoes = null;
		
		try {
			
			String hql = "from AutoAvaliacao as a"
					+ " where a.cpf like :cpf";
			
			Query query = session.createQuery(hql);
			query.setParameter("cpf", "%" + cpf + "%");
			
			AutoAvaliacoes = (List<AutoAvaliacao>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return AutoAvaliacoes;

	}
		
	

	

	
}

