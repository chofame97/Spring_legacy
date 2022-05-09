package org.study.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
// @AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	
	private final Chef chef;
		
}
