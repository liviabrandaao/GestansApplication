package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.AutoAvaliacaoDAO;
import br.edu.ifpb.resteasyapp.dao.PacienteDAO;
import br.edu.ifpb.resteasyapp.entidade.AutoAvaliacao;
import br.edu.ifpb.resteasyapp.entidade.Paciente;


public class AutoAvaliacaoController {

	
	@PermitAll
	@POST
	@Path("autoAvaliacao/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(AutoAvaliacao autoAvaliacao) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			int idMedico = AutoAvaliacaoDAO.getInstance().insert(autoAvaliacao);
			
			autoAvaliacao.setId(idMedico);
			
			builder.status(Response.Status.OK).entity(autoAvaliacao);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return builder.build();
	}
	
	@PermitAll
	@GET
	@Path("autoAvaliacao/listar/crm/{crm}")
	@Produces("application/json")
	public Response getAutoAvaliacaoByCRM(@PathParam("crm") int crm) {
		
	
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			List<AutoAvaliacao> autoAvaliacoes = AutoAvaliacaoDAO.getInstance().getAutoAvaliacaoByCRM(crm); 
			
			if (!autoAvaliacoes.isEmpty()) {
				
				builder.status(Response.Status.OK);
				builder.entity(autoAvaliacoes);
				
			} else {
				
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
	
	@PermitAll
	@GET
	@Path("autoAvaliacao/listar/cpf/{cpf}")
	@Produces("application/json")
	public Response getAutoAvaliacaoByCPF(@PathParam("cpf") int cpf) throws SQLException {
		
	
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		List<AutoAvaliacao> autoAvaliacoes = AutoAvaliacaoDAO.getInstance().getAutoAvaliacaoByCPF(cpf); 
		
		if (!autoAvaliacoes.isEmpty()) {
			
			builder.status(Response.Status.OK);
			builder.entity(autoAvaliacoes);
			
		} else {
			
			builder.status(Response.Status.NOT_FOUND);
		}

		// Resposta
		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("autoAvaliacao/deletar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(AutoAvaliacao autoAvaliacao) {
	
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			if (autoAvaliacao != null) {
				
				int cod_u = AutoAvaliacaoDAO.getInstance().findAutoAvaliacaoById(autoAvaliacao.getId()).getId();
				AutoAvaliacaoDAO.getInstance().delete(cod_u);
				AutoAvaliacao autoAvaliacaoTeste = AutoAvaliacaoDAO.getInstance().findAutoAvaliacaoById(autoAvaliacao.getId());

				if (autoAvaliacaoTeste == null) {

					
					builder.status(Response.Status.NO_CONTENT);

				} else {

					
					builder.status(Response.Status.NOT_IMPLEMENTED).entity(autoAvaliacaoTeste);
				}
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("autoAvaliacao/alterar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(AutoAvaliacao autoAvaliacao) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			int cod_u = AutoAvaliacaoDAO.getInstance().findAutoAvaliacaoById(autoAvaliacao.getId()).getId();
			autoAvaliacao.setId(cod_u);
			AutoAvaliacaoDAO.getInstance().updateByEntity(autoAvaliacao);
			builder.status(Response.Status.OK).entity(autoAvaliacao);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();

	}
	
	
}
