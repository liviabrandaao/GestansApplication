package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.HibernateException;
import br.edu.ifpb.resteasyapp.entidade.Paciente;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class PacienteDAO extends GenericDao<Integer, Paciente>{
	
private static PacienteDAO instance;
	
	public static PacienteDAO getInstance() {		
		instance = new PacienteDAO();		
		return instance;
	}
	
	@Override
	public List<Paciente> getAll() throws SQLException {
		return super.getAll("Paciente.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Paciente.class;
	}

	@Override
	public Paciente find(Paciente entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
public Paciente findPacienteByCPF(int cpf) throws SQLException{
		
Session session = HibernateUtil.getSessionFactory().openSession();
	
	Paciente paciente = null;
	
	try{

		String hql = "from Paciente p "
			+ "where p.cpf like :cpf";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("cpf", "%" + cpf + "%");
		
		paciente = (Paciente) query.uniqueResult();
		
	} catch(HibernateException hibernateException){
		
		session.getTransaction().rollback();
		
		throw new SQLException(hibernateException);
	
	} finally {
		session.close();
	}
	return paciente;
}

public void updateByEntity(Paciente paciente) {
	// TODO Auto-generated method stub
	
}
}

