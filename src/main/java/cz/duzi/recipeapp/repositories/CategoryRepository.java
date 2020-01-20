package cz.duzi.recipeapp.repositories;

import cz.duzi.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
