package com.tbutler78.minemapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
@SpringBootTest(classes = {MineMappingApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MineMappingApplicationTest {
    @Test
    public void contextLoads() {}
}
