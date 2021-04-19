package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.service.memo.MemoService;
import com.rm.app.refrigerator_management_app.web.dto.MemoListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoSaveRequestDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class MemoApiController {

    private final MemoService memoService;
    // private final MemoRepository memoRepository;

    /*
    @PostMapping("/test")
    public Memo testdb() {
        final Memo memo = Memo.builder()
                .content("test")
                .complete(true)
                .build();
        return memoRepository.save(memo);
    }*/



    @GetMapping("/api/memo") // 조회
    public List<MemoListResponseDto> findAllMemo() {
        return memoService.findAll();
    }

    @PostMapping("/api/memo") // 저장
    public Long save(@RequestBody MemoSaveRequestDto requestDto) {
        return memoService.save(requestDto);
    }

    @PutMapping("/api/memo/{id}") // 수정
    public Long update(@PathVariable Long id, @RequestBody MemoUpdateRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memo/{id}") // 삭제
    public Long delete(@PathVariable Long id) {
        memoService.delete(id);
        return id;
    }

    @GetMapping("/api/memo/{id}")
    public MemoResponseDto findById (@PathVariable Long id) {
        return memoService.findById(id);
    }
}
