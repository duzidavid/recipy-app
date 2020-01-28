package cz.duzi.recipeapp.converters;

import cz.duzi.recipeapp.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, cz.duzi.recipeapp.commands.UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public cz.duzi.recipeapp.commands.UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final cz.duzi.recipeapp.commands.UnitOfMeasureCommand uomc = new cz.duzi.recipeapp.commands.UnitOfMeasureCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }
        return null;
    }
}
