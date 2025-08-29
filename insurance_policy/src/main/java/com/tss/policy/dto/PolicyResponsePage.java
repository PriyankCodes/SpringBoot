package com.tss.policy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PolicyResponsePage {

	private List<PolicyResponseDto> contents;
	private long totalElements;
	private int size;
	private boolean isLastPage;
	private int totalPages;
}
