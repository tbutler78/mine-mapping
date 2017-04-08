package com.tbutler78.minemapping;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestPropertySource(properties = "spring.cache.type=none")
@SpringBootTest(classes = {MineMappingApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public abstract class MineMappingApplicationTest {



}
