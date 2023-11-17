package application.controller;

import application.model.entity.Usuario;
import application.model.entity.dto.UsuarioDTO;
import application.service.IUsuarioService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private SecretKey secretKey;
    private final int EXPIRATION_TIME_IN_HOURS = 24;

    @PostMapping("/register/parameters")
    private ResponseEntity<String> register(@RequestBody UsuarioDTO usuarioDTO, @RequestParam("username") String username) {
        Usuario usuario = UsuarioController.convertToEntity(usuarioDTO);
        usuarioService.create(usuario, username);//EL USERNAME TIENE QUE SER UN ADMIN
        return new ResponseEntity<>("Registro exitoso.", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario usuarioFinal = usuarioService.readByUsernameAndPassword(usuario);
        if (usuarioFinal != null) {
            String token = Jwts.builder()
                    .setSubject(usuarioFinal.getUsername())
                    .claim("rol", usuarioFinal.getTipoUsuario())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_HOURS * 60 * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Credenciales inválidas.", HttpStatus.UNAUTHORIZED);
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getPassword()
        );
    }
}
