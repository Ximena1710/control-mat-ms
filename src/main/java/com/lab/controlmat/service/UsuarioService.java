package com.lab.controlmat.service;

import com.lab.controlmat.dto.Credenciales;
import com.lab.controlmat.entity.Persona;

public interface UsuarioService {

	public int findExistUsuario(Credenciales credenciales);
}
