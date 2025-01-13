package com.sparta.memo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.sparta.memo.entity.Memo;

@RestController
public class MemoController {

	private final Map<Long, Memo> memoList = new HashMap<>();

	


}
