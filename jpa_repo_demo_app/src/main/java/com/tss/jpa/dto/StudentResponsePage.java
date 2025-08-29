package com.tss.jpa.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class StudentResponsePage {

	private List<StudentResponseDto> contents;
	private long totalElements;
	private int size;
	private boolean isLastPage;
	private int totalPages;
}
