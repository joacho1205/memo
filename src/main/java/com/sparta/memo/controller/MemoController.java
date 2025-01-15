package com.sparta.memo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;

@RestController
@RequestMapping("/memos")
public class MemoController {

	private final Map<Long, Memo> memoList = new HashMap<>();

	@PostMapping
	public MemoResponseDto createMemo(@RequestBody MemoRequestDto dto) {

		// 식별자가 1씩 증가 하도록 만듦
		Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

		// 요청받은 데이터로 Memo 객체 생성
		Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

		// Inmemory DB에 Memo 저장
		memoList.put(memoId, memo);

		return new MemoResponseDto(memo);
	}


}
