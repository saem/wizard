package com.github.saem.wizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class WizardConfiguration extends Configuration {
    @NotEmpty
    private String wizardName;
    
    @JsonProperty
    public String getWizardName() {
        return wizardName;
    }

    @JsonProperty
    public void setWizardName(String wizardName) {
        this.wizardName = wizardName;
    }
    
}
