package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;

import br.edu.ifpb.resteasyapp.entidade.Medico;
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
	
public Paciente findPacienteByCPF(String cpf) throws SQLException{
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		
		Paciente paciente = null;
		
		try{
		
			String hql = "from Paciente x "	+ "where x.cpf = Paciente.getCPF ";
			
			Query query = (Query) session.createQuery(hql);
				
			paciente = (Paciente) ((org.hibernate.Query) query).uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return paciente;
	}
}

