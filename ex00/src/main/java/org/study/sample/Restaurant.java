package org.study.sample;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

// setter 주입 @Setter(onMethod_ = {@Autowired})
// 생성자 주입 @AllArgsConstructor
// 필드 주입 @Autowired *추천하는 방식은 아님

@Component // 직접 작성한 현재 class 를 Bean 으로 등록
@ToString
@RequiredArgsConstructor
public class Restaurant {
	
	// 객체생성
	private final Chef chef;
	
}
