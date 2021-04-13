package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.domain.memo.Memo;
import com.rm.app.refrigerator_management_app.domain.memo.MemoRepository;
import com.rm.app.refrigerator_management_app.web.dto.MemoSaveRequestDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemoApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void Memo_등록() throws Exception {
        //given
        String content = "content";
        boolean complete = true;
        MemoSaveRequestDto requestDto = MemoSaveRequestDto.builder()
                .content(content)
                .complete(complete)
                .build();

        String url = "http://localhost:" + port + "/api/memo";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Memo> all = memoRepository.findAll();
        int size = all.size();
        Memo memo = all.get(size-1); // 마지막 튜플을 가져옴
        assertThat(memo.getContent()).isEqualTo(content);
        assertThat(memo.getComplete()).isEqualTo(complete);

        // 삭제
        memoRepository.delete(memo);

    }

    @Test
    public void Memo_수정() throws Exception {
        //given
        Memo savedMemo = memoRepository.save(Memo.builder()
                .content("content")
                .complete(true)
                .build());

        Long updateId = savedMemo.getId();
        String updateContent = "content2";
        boolean updateComplete = false;

        MemoUpdateRequestDto requestDto = MemoUpdateRequestDto.builder()
                .content(updateContent)
                .complete(updateComplete)
                .build();

        String url = "http://localhost:" + port + "/api/memo/"+ updateId;

        HttpEntity<MemoUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Memo> all = memoRepository.findAll();
        int size = all.size();
        Memo memo = all.get(size-1); // 마지막 튜플을 가져옴
        assertThat(memo.getContent()).isEqualTo(updateContent);
        assertThat(memo.getComplete()).isEqualTo(updateComplete);

        // 삭제
        memoRepository.delete(memo);
    }
}
