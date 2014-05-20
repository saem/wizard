package com.github.saem.wizard.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Wizard {
    public String name = "Rincewind";
    
    private int hp = 4;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Wizard() {
    }
    
    public Wizard(String name) {
        this.name = name;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }
    
    @Override
    public boolean equals(Object other) {
        if(other instanceof Wizard) {
            Wizard otherWizard = (Wizard) other;
            return (this.name == null ? otherWizard.name == null : this.name.equals(otherWizard.name))
                && this.hp == otherWizard.hp
                ;
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + this.name.hashCode();
        hash = hash * 31 + this.hp;
        return hash;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.hp;
    }
}
