package com.martinetherton.ons.web;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration("classpath:/META-INF/springconfig/app-config.xml")
public class MixedSpringClassImplTest {

    @Autowired
    MixedSpringClass mixedSpringClass;
    
    @Test
    @Ignore
    public void construction() {
        Assert.assertNotNull(mixedSpringClass.getMandatory());
        Assert.assertNotNull(mixedSpringClass.getOptional());
        Assert.assertNotNull(mixedSpringClass.getMixedSpringOptional());
        Assert.assertNotNull(mixedSpringClass.getMixedSpringOptionalViaMethod());
        MixedSpringMandatoryImpl mandatory = new MixedSpringMandatoryImpl();
        mandatory.setName("martin");
        
        Matcher<MixedSpringMandatory> mandatoryMatcher = new MixedSpringMandatoryMatcher(mandatory);
        Assert.assertThat((MixedSpringMandatoryImpl)mixedSpringClass.getMandatory(),Matchers.is(org.hamcrest.Matchers.equalTo(mandatory)));
    }
    
//    private Matcher<MixedSpringMandatoryImpl> hasMandatoryFeatureMatcher(final MixedSpringMandatoryImpl mandatory) {
//        return new FeatureMatcher
//    }
    
}
