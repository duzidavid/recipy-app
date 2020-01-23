package cz.duzi.recipeapp.repositories;

import cz.duzi.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {

        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unit.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unit.get().getDescription());
    }

    @Test
    public void findByDescriptionNull() {

        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByDescription(null);

        assertEquals(Optional.empty(), unit);

    }
}