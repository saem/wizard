package com.github.saem.wizard.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

public class HitPoints {
    final int hp;
    
    @JsonCreator
    public HitPoints(@JsonProperty("hp") int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public boolean isUnconscious() {
        return this.hp <= 0 && this.hp > -11;
    }
    
    public boolean isDead() {
        return this.hp < -10;
    }
    
    public boolean isAlive() {
        return !this.isDead() && !this.isUnconscious();
    }
    
    @Override
    public boolean equals(Object other) {
        if(other instanceof HitPoints) {
            return this.hp == ((HitPoints) other).hp;
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.hp;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.hp);
    }
}
