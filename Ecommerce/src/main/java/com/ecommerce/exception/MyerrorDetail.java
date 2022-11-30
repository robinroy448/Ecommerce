package com.ecommerce.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyerrorDetail {
	
	private LocalDateTime time;
	private String msg;
	private String des;

}
