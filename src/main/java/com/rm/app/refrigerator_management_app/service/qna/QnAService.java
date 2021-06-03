package com.rm.app.refrigerator_management_app.service.qna;

import com.rm.app.refrigerator_management_app.domain.memo.Memo;
import com.rm.app.refrigerator_management_app.domain.qna.QnA;
import com.rm.app.refrigerator_management_app.domain.qna.QnARepository;
import com.rm.app.refrigerator_management_app.web.dto.QnAListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.QnASaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QnAService {
    private final QnARepository qnARepository;

    @Transactional // db에 접근해서 바꿔야할 때 사용
    public Long save(QnASaveRequestDto requestDto) {
        return qnARepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id) {
        QnA qnA = qnARepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        qnARepository.delete(qnA);
    }

    @Transactional(readOnly = true)
    public List<QnAListResponseDto> findAll() {
        return qnARepository.findAll().stream()
                .map(QnAListResponseDto::new)
                .collect(Collectors.toList());
    }
}
