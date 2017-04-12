package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;

import com.mysql.cj.api.Session;

import br.edu.ifpb.resteasyapp.entidade.Medico;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class MedicoDAO extends GenericDao<Integer, Medico>{
	
private static MedicoDAO instance;
	
	public static MedicoDAO getInstance() {		
		instance = new MedicoDAO();		
		return instance;
	}
	
	@Override
	public List<Medico> getAll() throws SQLException {
		return super.getAll("Medico.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Medico.class;
	}

	@Override
	public Medico find(Medico entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
public Medico findMedicoByChave(String chave) throws SQLException{
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		
		Medico medico = null;
		
		try{
		
			String hql = "from Medico x "	+ "where x.chave = Medico.getChave ";
			
			Query query = (Query) session.createQuery(hql);
				
			medico = (Medico) ((org.hibernate.Query) query).uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return medico;
	}
}
