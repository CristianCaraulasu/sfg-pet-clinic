package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Gina");
        owner.setLastName("Basina");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alexia");
        owner1.setLastName("Limuzina");

        ownerService.save(owner1);

        System.out.println("Hello California!!!");

        Vet vet = new Vet();
        vet.setFirstName("cutu-cutu");
        vet.setLastName("bimbo");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jaga-laga");
        vet1.setLastName("Cara-Paga");

        vetService.save(vet);
        vetService.save(vet1);

    }
}
