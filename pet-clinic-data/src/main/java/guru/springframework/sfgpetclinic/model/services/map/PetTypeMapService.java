package guru.springframework.sfgpetclinic.model.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
