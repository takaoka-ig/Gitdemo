package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleTest {
    
  //テストメソッド
    @Test
    void myFirstTest() {      
	// 期待される結果と実際の結果が同じかどうか、判定する。
        assertEquals(2, 1 + 1);
    }

    @Test
    void mySecondTest() {
	// 期待される結果と実際の結果が同じかどうか、判定する。
        assertEquals(3, 1 + 1);
    }
}
