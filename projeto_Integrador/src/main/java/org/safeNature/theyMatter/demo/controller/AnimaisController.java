package org.safeNature.theyMatter.demo.controller;

import java.util.List;

import org.safeNature.theyMatter.demo.model.AnimaisTable;
import org.safeNature.theyMatter.demo.repository.AnimaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
public class AnimaisController {


	@Autowired
	 public AnimaisRepository animaisRepository; //Injeta o repositorio dentro dessa classe.

	    //METODOS GET --------------------------------------------------------------\\

	    @GetMapping("/todos")
	    public ResponseEntity<List<AnimaisTable>> getAll() {
	        return ResponseEntity.ok(animaisRepository.findAll());
	    }
	    @GetMapping("/id/{id}")
	    public ResponseEntity<AnimaisTable> getById(@PathVariable Long id) {
	        return animaisRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @GetMapping("/nome/{nome}")
	    public ResponseEntity<List<AnimaisTable>> getByNome(@PathVariable String nome) {
	        return ResponseEntity.ok(animaisRepository.findAllByNomeContainingIgnoreCase(nome));
	    }
	    
	    

	    // FIM DOS METODOS GET
	    // --------------------------------------------------------\\

	    //

	    // METODO POST
	    // ----------------------------------------------------------------\\

	    @PostMapping("/post")
	    public ResponseEntity<AnimaisTable> post(@RequestBody AnimaisTable animaisTable) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(animaisRepository.save(animaisTable));
	    }
	    // -----------------------------------------------------------------------------\\

	    //

	    // METODO
	    // PUT/UPDATE------------------------------------------------------------\\

	    @PutMapping("put/{id}")
	    public AnimaisTable put(@PathVariable Long id, @RequestBody AnimaisTable animaisTable) {
	        animaisTable.setId(id);
			animaisRepository.save(animaisTable);
			return animaisTable;
	    }

	    // ------------------------------------------------------------------------------\\

	    //

	    // METODO DELETE
	    // -----------------------------------------------------------------\\

	    @DeleteMapping("/delete/{id}")
	    public String deletar(@PathVariable Long id) {
	        try {
	            animaisRepository.deleteById(id);
	            return "Sucesso";
	        } catch(Exception e) {
	            return "Erro: "+ e.getMessage();
	        }
	    }
	
	
	

}
