package com.project.base.proyectobase.domain.usecase.auth;

import com.project.base.proyectobase.domain.auth.User;
import com.project.base.proyectobase.domain.auth.gateway.AuthGateway;
import com.project.base.proyectobase.domain.auth.gateway.JwtGateway;
import com.project.base.proyectobase.domain.auth.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class UserUseCase {

    private final AuthGateway authGateway;

    private final JwtGateway jwtGateway;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public String registrarUsuario(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        User userRegistrado = this.authGateway.registrarUsuario(user);
        return jwtGateway.generarToken(user, this.generateExtraClaims(userRegistrado));
    }

    public String loginUsuario(User user){
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        this.authenticationManager.authenticate(authentication);//verificar que el usuario sea quien dice ser con el username y password.
        User userBD = authGateway.consultarUsuarioPorUsername(user.getUsername());//buscamos en BD por username.
        String jwt = jwtGateway.generarToken(userBD, generateExtraClaims(userBD));//generación del token.
        //this.saveUserToken((User) userBD,jwt);//guardar token en BD para cuando hagamos logout
        return jwt;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getNombre());
        extraClaims.put("role",user.getRole());
        extraClaims.put("authorities",user.getRole().getPermissions());
        return extraClaims;
    }

}
