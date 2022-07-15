package guru.springframework.sfgpetclinic.formatters;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by jt on 9/22/18.
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

//        for (PetType type : findPetTypes) {
//            if (type.getName().equals(text)) {
//                return type;
//            }
//        }

        Optional<PetType> petTypeOptional = findPetTypes.stream()
                .filter(object -> object.getName().equals(text))
                .findFirst();

        if(petTypeOptional.isPresent())
            return petTypeOptional.get();

        throw new ParseException("type not found: " + text, 0);
    }
}