package br.edu.ifpb.resteasyapp.dao;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.AutoAvaliacao;

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
}