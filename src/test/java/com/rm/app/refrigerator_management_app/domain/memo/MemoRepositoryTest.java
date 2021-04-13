package com.rm.app.refrigerator_management_app.domain.memo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest // H2 데이터베이스를 자동으로 실행
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void 메모_불러오기() {
        // given
        String content = "테스트 메모";
        boolean complete = true;
        memoRepository.save(Memo.builder() // id값(기본키)이 있다면 update, 없다면 insert 쿼리가 실행된다.
        .content(content)
        .complete(complete)
        .build());

        // when
        List<Memo> memoList = memoRepository.findAll(); // 테이블에 있는 모든 데이터를 조회
        int size = memoList.size();

        // then
        Memo memo = memoList.get(size-1); // 마지막 튜플을 가져옴
        assertThat(memo.getContent()).isEqualTo(content);
        assertThat(memo.getComplete()).isEqualTo(complete);

        // 삭제
        memoRepository.delete(memo);
    }
}
