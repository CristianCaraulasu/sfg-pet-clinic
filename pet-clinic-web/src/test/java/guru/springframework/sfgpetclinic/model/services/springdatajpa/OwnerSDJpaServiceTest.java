package guru.springframework.sfgpetclinic.model.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.model.repositories.PetRepository;
import guru.springframework.sfgpetclinic.model.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;


    @Test
    void findByLastName() {

        Owner returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerRepository.findByLastName(LAST_NAME);

        assertEquals(smith.getLastName(),returnOwner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

}