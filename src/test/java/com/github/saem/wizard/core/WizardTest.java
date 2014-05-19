/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.saem.wizard.core;

import com.github.saem.wizard.core.HitPoints;
import com.github.saem.wizard.core.Wizard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author saem
 */
public class WizardTest {
    private final ObjectMapper mapper = new ObjectMapper();
    
    public WizardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void serializesToJson() throws JsonProcessingException, IOException {
        final Wizard wizard = new Wizard("Saem");
        assertThat("A Wizard can be serialized to JSON", 
                this.mapper.writeValueAsString(wizard),
                is(equalTo(this.mapper.writeValueAsString(this.mapper.readValue(fixture("fixtures/wizard.json"), Wizard.class))))
        );
    }
    
    @Test
    public void deserializesFromJson() throws IOException {
        final Wizard wizard = new Wizard("Saem");
        assertThat("A wizard can be deserialized from JSON",
                this.mapper.readValue(fixture("fixtures/wizard.json"), Wizard.class),
                is(wizard));
        System.out.println(this.mapper.readValue(fixture("fixtures/wizard.json"), Wizard.class));
        System.out.println(wizard);
    }
    
    @Test
    public void testIsUnconsciousReturnsFalseWhenHitPointsAreGreaterThanZero() {
        Wizard wizard = new Wizard();
        wizard.hp = new HitPoints(1);
        boolean result = wizard.isUnconscious();
        assertFalse(result);
    }

    @Test
    public void testIsDeadReturnsFalseWhenHitPointsAreGreaterThanNegativeEleven() {
        Wizard wizard = new Wizard();
        wizard.hp = new HitPoints(-10);
        boolean result = wizard.isDead();
        assertFalse(result);
    }

    @Test
    public void testIsAliveReturnsTrueWhenHitPointsAreGreaterThanZero() {
        Wizard wizard = new Wizard();
        wizard.hp = new HitPoints(1);
        boolean result = wizard.isAlive();
        assertTrue(result);
    }
    
}
