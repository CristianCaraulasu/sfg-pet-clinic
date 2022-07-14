package guru.springframework.sfgpetclinic.model.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.model.services.OwnerService;
import guru.springframework.sfgpetclinic.model.services.PetService;
import guru.springframework.sfgpetclinic.model.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;
    private final OwnerRepository ownerRepository;

    public OwnerMapService(PetTypeService petTypeService, PetService petService,OwnerRepository ownerRepository) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach( pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }  else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) { super.delete(object); }

    @Override
    public void deleteById(Long id) { super.deleteById(id); }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> result = null;
        Set<Owner> ownerSet = this.findAll();
        for(Owner owner: ownerSet){
            if(owner.getLastName().equals(lastName)){
                result = Optional.of(owner);
                break;
            }
        }
        result.ifPresent(owner -> System.out.println(owner.getLastName()));
        return result.orElse(null);
    }

    @PostConstruct
    public void constructed() {
        System.out.println("I was constructed! OwnerServiceMap");
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        return ownerRepository.findAllByLastNameLike(lastName);
    }

}
