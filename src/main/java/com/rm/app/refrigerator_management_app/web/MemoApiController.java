package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.domain.memo.Memo;
import com.rm.app.refrigerator_management_app.domain.memo.MemoRepository;
import com.rm.app.refrigerator_management_app.service.memo.MemoService;
import com.rm.app.refrigerator_management_app.web.dto.MemoListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoSaveRequestDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoApiController {

    private final MemoService memoService;
    // private final MemoRepository memoRepository;

    @GetMapping("/api/memo")
    public List<MemoListResponseDto> findAllMemo() {
        return memoService.findAll();
    }

    /*
    @PostMapping("/test")
    public Memo testdb() {
        final Memo memo = Memo.builder()
                .content("test")
                .build();
        return memoRepository.save(memo);
    }*/

    @PostMapping("/api/memo")
    public Long save(@RequestBody MemoSaveRequestDto requestDto) {
        return memoService.save(requestDto);
    }

    @PutMapping("/api/memo/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoUpdateRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    @GetMapping("/api/memo/{id}")
    public MemoResponseDto findById (@PathVariable Long id) {
        return memoService.findById(id);
    }
}
