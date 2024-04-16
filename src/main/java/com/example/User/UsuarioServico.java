package com.example.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service

public class UsuarioServico {
	
  @Autowired
  private UserRepository UserRepository;
  
 public List<Usuario>listausuario(){
	 return UserRepository.findAll(); 
 }
  
 public Optional<Usuario>procurarid(Long id){
	 return UserRepository.findById(id); 
 }
 public Usuario inserir(Usuario usuario){
	 return UserRepository.save(usuario);
 }
 public void delete(Long id) {
	  UserRepository.deleteById(id);
 }
 public Usuario atualizar(Usuario usuario){
	 return UserRepository.save(usuario);
 }
 
 

}
