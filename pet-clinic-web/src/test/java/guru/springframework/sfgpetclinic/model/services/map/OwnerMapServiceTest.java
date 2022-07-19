package guru.springframework.sfgpetclinic.model.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long num = 33L;
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService(), new OwnerRepository() {
            @Override
            public Owner findByLastName(String lastName) {
                return null;
            }

            @Override
            public List<Owner> findAllByLastNameLike(String lastName) {
                return null;
            }

            @Override
            public <S extends Owner> S save(S s) {
                return null;
            }

            @Override
            public <S extends Owner> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Owner> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Owner> findAll() {
                return null;
            }

            @Override
            public Iterable<Owner> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Owner owner) {

            }

            @Override
            public void deleteAll(Iterable<? extends Owner> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        });
        Owner owner = new Owner();
        owner.setId(num);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(num);
        assertEquals(owner.getId(),num);
    }

    @Test
    void saveExistingId() {
        long short_ = 2L;
        Owner owner2 = new Owner();
        owner2.setId(short_);;
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(owner2.getId(),savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        System.out.println(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(num));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(num);
        assertEquals(0,ownerMapService.findAll().size());
    }

}