package com.example.BankingProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan(basePackages = "org.example.BankingProject.entity")
class BankingProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
