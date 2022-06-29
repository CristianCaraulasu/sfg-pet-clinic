package guru.springframework.sfgpetclinic.model.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long num = 33L;
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
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