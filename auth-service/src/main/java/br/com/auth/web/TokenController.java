package br.com.auth.web;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.auth.domain.User;
import br.com.auth.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class TokenController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@PostMapping("/")
	public String auth(@RequestBody User user) throws ServletException {
		User userLogged = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		validateAuth(userLogged);
		return Jwts.builder().setSubject(user.getEmail()).signWith(SignatureAlgorithm.HS512, "chave").compact();
	}

	private void validateAuth(User userLogged) throws ServletException {
		if (userLogged == null) {
			throw new ServletException("Usuário ou senha inválido.");
		}
	}
		
}
