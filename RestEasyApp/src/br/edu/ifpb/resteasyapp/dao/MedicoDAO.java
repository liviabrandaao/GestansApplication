package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;

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
	
public Medico findMedicoByCRM(String crm) throws SQLException{
		
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Medico medico = null;
	
	try{

		String hql = "from Medico p "
			+ "where p.crm like :crm";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("crm", "%" + crm + "%");
		
		medico = (Medico) query.uniqueResult();
		
	} catch(HibernateException hibernateException){
		
		session.getTransaction().rollback();
		
		throw new SQLException(hibernateException);
	
	} finally {
		session.close();
	}
	return medico;
}

public void updateByEntity(Medico medico) {
	// TODO Auto-generated method stub
	
}





	
}

