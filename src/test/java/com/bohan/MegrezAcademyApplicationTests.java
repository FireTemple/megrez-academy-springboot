package com.bohan;

import com.bohan.exception.BaseResponseCodeImp;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MegrezAcademyApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	public void test1(){
		System.out.println(BaseResponseCodeImp.SUCCESS);
	}

}
