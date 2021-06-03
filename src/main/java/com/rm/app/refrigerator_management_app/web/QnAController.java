package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.domain.qna.QnARepository;
import com.rm.app.refrigerator_management_app.service.qna.QnAService;
import com.rm.app.refrigerator_management_app.web.dto.MemoListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoSaveRequestDto;
import com.rm.app.refrigerator_management_app.web.dto.QnAListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.QnASaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class QnAController {

    private final QnAService qnAService;

    @GetMapping("/api/qna") // 조회
    public List<QnAListResponseDto> findAllQnA() {
        return qnAService.findAll();
    }

    @PostMapping("/api/qna") // 저장
    public Long save(@RequestBody QnASaveRequestDto requestDto) {
        return qnAService.save(requestDto);
    }

    @DeleteMapping("/api/qna/{id}") // 삭제
    public Long delete(@PathVariable Long id) {
        qnAService.delete(id);
        return id;
    }
}
