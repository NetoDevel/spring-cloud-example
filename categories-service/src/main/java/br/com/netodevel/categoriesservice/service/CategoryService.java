package br.com.netodevel.categoriesservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netodevel.categoriesservice.domain.Category;
import br.com.netodevel.categoriesservice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Optional<Category> findOne(Integer categoryId) {
		return categoryRepository.findById(categoryId);
	}
	
}
