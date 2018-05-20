package br.com.netodevel.categoriesservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.categoriesservice.domain.Category;
import br.com.netodevel.categoriesservice.service.CategoryService;


@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{category_id}")
	public ResponseEntity<?> show(@PathVariable("category_id") Integer categoryId) {
		if (categoryService.findOne(categoryId).isPresent()) {
			Category category = categoryService.findOne(categoryId).get();
			return new ResponseEntity<Category>(category, HttpStatus.OK);	
		} else {
			return new ResponseEntity<String>("category not found.", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> create(@RequestBody Category category) {
		Category categorySaved = categoryService.save(category);
		return new ResponseEntity<Category>(categorySaved, HttpStatus.OK);
	}
	
}
