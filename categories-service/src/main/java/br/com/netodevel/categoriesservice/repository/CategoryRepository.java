package br.com.netodevel.categoriesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netodevel.categoriesservice.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
