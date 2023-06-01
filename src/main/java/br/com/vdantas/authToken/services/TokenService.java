package br.com.vdantas.authToken.services;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.vdantas.authToken.model.Usuario;

@Service
public class TokenService {
	
	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${app.jwtExpirationMs}")
	private int jwtExpirationMs;	

	public String gerarToken(Usuario usuario) {		
		return JWT.create()
				.withSubject(usuario.getUsername())
				.withClaim("id", usuario.getId())
				.withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))
				.sign(Algorithm.HMAC256(jwtSecret));
	}

}
