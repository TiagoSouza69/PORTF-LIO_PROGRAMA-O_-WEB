package com.example.User;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/usuarioss")
public class UsuarioControle {
	

	
	@Autowired
	private UsuarioServico usuarioControle;
	@Autowired
	private ModelMapper modelmapper;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario>listausuario(){
		return usuarioControle.listausuario();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		return usuarioControle.inserir(usuario);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario procurarid(@PathVariable("id") Long id){
		return usuarioControle.procurarid(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
				
		
				
	}
	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeUsuario(@PathVariable("id")Long id) {
		usuarioControle.procurarid(id)
		.map(usuario -> {usuarioControle.delete(usuario.getId());
		return Void.TYPE;
		
	}) .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		

}
	@PutMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarusuario(@PathVariable("id") Long id , @RequestBody Usuario usuario) {
		usuarioControle.procurarid(id) 
		.map(usuarioBase -> { modelmapper.map(usuario, usuarioBase);
		usuarioControle.atualizar(usuarioBase);
		return Void.TYPE;
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		
	}
}
