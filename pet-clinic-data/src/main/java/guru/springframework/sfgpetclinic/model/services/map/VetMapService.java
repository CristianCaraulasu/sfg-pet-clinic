package guru.springframework.sfgpetclinic.model.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findByID(aLong);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
            super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
