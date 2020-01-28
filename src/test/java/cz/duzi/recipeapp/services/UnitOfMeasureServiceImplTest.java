package cz.duzi.recipeapp.services;

import cz.duzi.recipeapp.commands.UnitOfMeasureCommand;
import cz.duzi.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import cz.duzi.recipeapp.domain.UnitOfMeasure;
import cz.duzi.recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService unitOfMeasureService;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository,unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2l);

        unitOfMeasures.add(uom1);
        unitOfMeasures.add(uom2);

        //when
        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}