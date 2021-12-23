

package Proyecto.java.Services;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Proyecto.java.Repository.UserRepository;
import Proyecto.java.modelos.Auth.Usuario;

import java.util.ArrayList;



@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository usuarioRepository;
	
	public UsuarioDetailsServiceImpl(UserRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioEx = usuarioRepository.findByUsuario(username);
        if (usuarioEx == null) {
        	throw new UsernameNotFoundException(String.format("El usuario no ha sido creado %s", username));
        }
        List<SimpleGrantedAuthority> roles = getRoles(usuarioEx);
        return new org.springframework.security.core.userdetails.User(usuarioEx.getUsuario(),
                usuarioEx.getPassword(),
                roles);
    }
	private List<SimpleGrantedAuthority> getRoles(Usuario usuario) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getName()));

        return roles;
    }
	}
