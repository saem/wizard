package com.github.saem.wizard.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties({ "unconscious", "dead", "alive" })
public class Wizard {
    @JsonProperty
    public String name = "Rincewind";

    @JsonProperty
    @JsonDeserialize(as=HitPoints.class)
    public HitPoints hp = new HitPoints(4);

    public Wizard() {
    }
    
    public Wizard(String name) {
        this.name = name;
    }
    
    public boolean isUnconscious() {
        return this.hp.isUnconscious();
    }
    
    public boolean isDead() {
        return this.hp.isDead();
    }
    
    public boolean isAlive() {
        return this.hp.isAlive();
    }
    
    @Override
    public boolean equals(Object other) {
        if(other instanceof Wizard) {
            Wizard otherWizard = (Wizard) other;
            return this.name == otherWizard.name
                && this.hp == otherWizard.hp
                ;
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + this.name.hashCode();
        hash = hash * 31 + this.hp.hashCode();
        return hash;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.hp;
    }
}
