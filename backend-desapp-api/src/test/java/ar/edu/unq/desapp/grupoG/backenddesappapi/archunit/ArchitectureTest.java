package ar.edu.unq.desapp.grupoG.backenddesappapi.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {

    @Test
    public void serviceOnlyAccessedByController() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoG.backenddesappapi");

        ArchRule rule = classes()
                .that().resideInAPackage("..service..")
                .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

        rule.check(importedClasses);
    }

    @Test
    public void modelOnlyAccessedByService(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoG.backenddesappapi");

        ArchRule rule = classes()
                .that().resideInAPackage("..model..")
                .should().onlyBeAccessed().byAnyPackage("..service..", "..controller..", "..model..");

        rule.check(importedClasses);
    }

    @Test
    public void repositoryOnlyAccessedByService(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoG.backenddesappapi");

        ArchRule rule = classes()
                .that().resideInAPackage("..repository..")
                .should().onlyBeAccessed().byAnyPackage("..service..", "..repository..");

        rule.check(importedClasses);
    }

    @Test
    public void controllerOnlyAccessedBySelf(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoG.backenddesappapi");

        ArchRule rule = classes()
                .that().resideInAPackage("..controller..")
                .should().onlyBeAccessed().byAnyPackage("..controller..");

        rule.check(importedClasses);
    }

}
