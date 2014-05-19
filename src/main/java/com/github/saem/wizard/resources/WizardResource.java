package com.github.saem.wizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.saem.wizard.core.Wizard;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/wizard")
@Produces(MediaType.APPLICATION_JSON)
public class WizardResource {
    private final Wizard wizard;
    
    public WizardResource(Wizard wizard) {
        this.wizard = wizard;
    }
    
    @GET
    @Timed
    public Wizard sayHello(@QueryParam("name") Optional<String> name) {
        return this.wizard;
    }
}
