package com.example.projetoaulaAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoaulaAPI.entities.Usuario;
import com.example.projetoaulaAPI.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> findAll() {
	    List<Usuario> result = repository.findAll();
	    return result;
	}
	
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable Long id) {
	   Usuario result = repository.findById(id).get();
	    return result;
	}
	
	@PostMapping
	public Usuario insert(@RequestBody Usuario usuario) {
	   Usuario result = repository.save(usuario);
	    return result;
	}
	
	@PutMapping("/{id}")
	public Usuario update(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
	    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	    
	    if (usuarioOptional.isPresent()) {
	        Usuario usuario = usuarioOptional.get();
	        usuario.setName(novoUsuario.getName());
	        usuario.setEmail(novoUsuario.getEmail());
	        
	        Usuario result = usuarioRepository.save(usuario);
	        return result;
	    } else {
	   	
	    return null;	
	    
	    }
	}
	
       @DeleteMapping("/{id}")  
       public ResponseEntity<Object> delete(@PathVariable Long id){
           Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
           
           if (usuarioOptional.isPresent()) {
        	   usuarioRepository.delteById(id);
        	   return ResponseEntity.ok().build();
           } else {
        	   
        	   return ResponseEntity.notFound().build();
           }
       }
   }