package com.github.saem.wizard.health;

import com.codahale.metrics.health.HealthCheck;
import com.github.saem.wizard.core.Wizard;

public class WizardHealthCheck extends HealthCheck {
    final private Wizard wizard;
    
    public WizardHealthCheck(Wizard wizard) {
        this.wizard = wizard;
    }
    
    @Override
    protected Result check() throws Exception {
        if(!wizard.isAlive()) {
            return Result.unhealthy("The wizard is down, heal!");
        }

        return Result.healthy();
    }
    
}
