package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Paciente;

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
}

