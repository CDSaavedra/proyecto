package Proyecto.java.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import Proyecto.java.Repository.UserRepository;
import Proyecto.java.modelos.Auth.Usuario;




@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        Usuario usuario = usuarioRepository.findByUsuario(username);
        
        if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
        
        if (encoder.matches(password, usuario.getPassword()) && usuario.isActivo()){
        	
        	List<SimpleGrantedAuthority> authorities = getAuthorities(usuario);

			User principal = 
					new User(
							usuario.getUsuario(), 
							usuario.getPassword(), 
							authorities);
    				
        	return new UsernamePasswordAuthenticationToken(principal, null, authorities);
        }
        
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private List<SimpleGrantedAuthority> getAuthorities(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRol().getName()));
		return authorities;
	}

}
