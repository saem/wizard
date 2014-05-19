package com.github.saem.wizard;

import com.github.saem.wizard.core.Wizard;
import com.github.saem.wizard.health.WizardHealthCheck;
import com.github.saem.wizard.resources.WizardResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WizardApplication extends Application<WizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new WizardApplication().run(args);
    }
    
    @Override
    public String getName() {
        return "Wizzard!";
    }
    
    @Override
    public void initialize(Bootstrap<WizardConfiguration> bootstrap) {
        // do initialization stuff here
    }
    
    @Override
    public void run(WizardConfiguration configuration, Environment environment) {
        Wizard wizard = new Wizard(configuration.getWizardName());

        final WizardResource resource = new WizardResource(
                wizard);
        environment.jersey().register(resource);
        
        final WizardHealthCheck health = 
                new WizardHealthCheck(wizard);
        environment.healthChecks().register("template", health);
    }
}
