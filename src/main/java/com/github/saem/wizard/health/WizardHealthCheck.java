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
        if(wizard.isUnconscious()) {
            return Result.unhealthy("The wizard is unconscious, heal!");
        } else if (wizard.isDead()) {
            return Result.unhealthy("The wizard is dead, ressurect!");
        }

        return Result.healthy();
    }
    
}
