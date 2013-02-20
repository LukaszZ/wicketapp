package com.lzola;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JavaPackage;
import jdepend.textui.JDepend;

public class ConstraintTest {
	private JDepend jdepend;

	@BeforeMethod
    protected void setUp() throws IOException {
      
        jdepend = new JDepend();
    
        jdepend.addDirectory("./target/classes");
    }
  
	@Test
    public void testMatch() {
        //given
        DependencyConstraint constraint = new DependencyConstraint();

        JavaPackage dao = constraint.addPackage("com.lzola.dao");
        JavaPackage domain = constraint.addPackage("com.lzola.domain");
        JavaPackage services = constraint.addPackage("com.lzola.service");
        JavaPackage web = constraint.addPackage("com.lzola.web");
    
        domain.dependsUpon(dao);
        services.dependsUpon(domain);
        web.dependsUpon(services);
        web.dependsUpon(domain);
                
    
        //when
        jdepend.analyze();
//        boolean isConstraintMatched = jdepend.dependencyMatch(constraint);
        
        //then
//        assertThat(isConstraintMatched).isTrue();        
    }    
}
