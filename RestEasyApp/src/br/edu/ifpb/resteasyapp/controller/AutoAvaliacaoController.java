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
import br.edu.ifpb.resteasyapp.entidade.AutoAvaliacao;

@Path("autoAvaliacao")
public class AutoAvaliacaoController {

	
	@PermitAll
	@POST
	@Path("/inserir")
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
	@Path("/listar")
	@Produces("application/json")
	public List<AutoAvaliacao> getAll() {

		List<AutoAvaliacao> autoAvaliacao = new ArrayList<AutoAvaliacao>();

		try {

			autoAvaliacao = AutoAvaliacaoDAO.getInstance().getAll();

		} catch (SQLException e) {

	}
		return autoAvaliacao;
	
	}
}
