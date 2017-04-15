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

import br.edu.ifpb.resteasyapp.dao.MedicoDAO;
import br.edu.ifpb.resteasyapp.entidade.Medico;


public class MedicoController {

	
	@PermitAll
	@POST
	@Path("medico/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Medico medico) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			int idMedico = MedicoDAO.getInstance().insert(medico);
			
			medico.setId(idMedico);
			
			builder.status(Response.Status.OK).entity(medico);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("medico/deletar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Medico medico) {
	
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			if (medico != null) {
				
				int cod_u = MedicoDAO.getInstance().findMedicoByChave(medico.getChave()).getId();
				MedicoDAO.getInstance().delete(cod_u);
				Medico medicoTeste = MedicoDAO.getInstance().findMedicoByChave(medico.getChave());

				if (medicoTeste == null) {

					
					builder.status(Response.Status.NO_CONTENT);

				} else {

					
					builder.status(Response.Status.NOT_IMPLEMENTED).entity(medicoTeste);
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
	@Path("medico/alterar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Medico medico) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			int cod_u = MedicoDAO.getInstance().findMedicoByChave(medico.getChave()).getId();
			medico.setId(cod_u);
			MedicoDAO.getInstance().updateByEntity(medico);
			builder.status(Response.Status.OK).entity(medico);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();

	}
	
	@PermitAll
	@POST
	@Path("medico/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(Medico medico) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			Medico medicoRecebido = MedicoDAO.getInstance().findMedicoByChave(medico.getChave());
			

			
			if (medicoRecebido.getSenha().equals(medico.getSenha())){
				
				builder.status(Response.Status.OK).entity(medicoRecebido);
			
			} else {
				
				if (medicoRecebido.getSenha() == null || medicoRecebido.getSenha().isEmpty()){
				
					builder.status(Response.Status.EXPECTATION_FAILED).entity(medicoRecebido);
				
				} else {
					
					builder.status(Response.Status.BAD_REQUEST).entity(medicoRecebido);
				}
			}

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
	
}