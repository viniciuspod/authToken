package br.com.vdantas.authToken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vdantas.authToken.model.Usuario;
import br.com.vdantas.authToken.model.dto.Login;
import br.com.vdantas.authToken.services.TokenService;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value = "/auth")
	public String authCreateToken(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =  
				new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());
		
		Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		Usuario usuario = (Usuario) authentication.getPrincipal();
		
		return  tokenService.gerarToken(usuario);
		
	}
}
