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

import br.edu.ifpb.resteasyapp.dao.PacienteDAO;
import br.edu.ifpb.resteasyapp.entidade.Paciente;

@Path("paciente")
public class PacienteController {

	
	@PermitAll
	@POST
	@Path("paciente/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	
	public Response insert(Paciente paciente) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			int idPaciente = PacienteDAO.getInstance().insert(paciente);
			
			paciente.setId(idPaciente);
			
			builder.status(Response.Status.OK).entity(paciente);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return builder.build();
	}
	
	@PermitAll
	@POST
	@Path("paciente/deletar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Paciente paciente) {
	
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			if (paciente != null) {
				
				int cod_u = PacienteDAO.getInstance().findPacienteByCPF(paciente.getCPF()).getId();
				PacienteDAO.getInstance().delete(cod_u);
				Paciente pacienteTeste = PacienteDAO.getInstance().findPacienteByCPF(paciente.getCPF());

				if (pacienteTeste == null) {

					
					builder.status(Response.Status.NO_CONTENT);

				} else {

					
					builder.status(Response.Status.NOT_IMPLEMENTED).entity(pacienteTeste);
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
	@Path("paciente/alterar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Paciente paciente) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			int cod_u = PacienteDAO.getInstance().findPacienteByCPF(paciente.getCPF()).getId();
			paciente.setId(cod_u);
			PacienteDAO.getInstance().updateByEntity(paciente);
			builder.status(Response.Status.OK).entity(paciente);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();

	}
	
	
	
	
}