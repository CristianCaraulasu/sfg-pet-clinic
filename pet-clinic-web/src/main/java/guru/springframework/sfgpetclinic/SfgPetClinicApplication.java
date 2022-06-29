package guru.springframework.sfgpetclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan(basePackages = {"guru.springframework.sfgpetclinic.model","guru.springframework.sfgpetclinic"})
@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);
    }

}
