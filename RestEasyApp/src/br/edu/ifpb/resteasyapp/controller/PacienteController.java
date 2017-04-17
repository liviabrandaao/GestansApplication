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
import br.edu.ifpb.resteasyapp.dao.PacienteDAO;
import br.edu.ifpb.resteasyapp.entidade.Medico;
import br.edu.ifpb.resteasyapp.entidade.Paciente;

@Path("paciente")
public class PacienteController {

	
	@PermitAll
	@POST
	@Path("/cadastrar")
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
	@Path("/deletar")
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
	@Path("/alterar")
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
	
	@PermitAll
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(Paciente cpf, Paciente senha) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			Paciente pacienteRecebido = PacienteDAO.getInstance().findPacienteByCPF(cpf.getCPF());
			

			
			if (pacienteRecebido.getSenha().equals(cpf.getSenha())){
				
				builder.status(Response.Status.OK).entity(pacienteRecebido);
			
			} else {
				
				if (pacienteRecebido.getSenha() == null || pacienteRecebido.getSenha().isEmpty()){
				
					builder.status(Response.Status.EXPECTATION_FAILED).entity(pacienteRecebido);
				
				} else {
					
					builder.status(Response.Status.BAD_REQUEST).entity(pacienteRecebido);
				}
			}

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
	
	
	
}
