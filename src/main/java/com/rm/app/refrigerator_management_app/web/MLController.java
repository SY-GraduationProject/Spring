package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.service.material.MaterialService;
import com.rm.app.refrigerator_management_app.web.dto.MaterialListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MaterialSaveRequestDto;
import com.rm.app.refrigerator_management_app.web.dto.MemoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class MLController {
    private final MaterialService materialService;
    String url = "http://210.117.181.74:5000/detection";

    @GetMapping(value = "/api/material")
    public List<MaterialListResponseDto> MaterialList() {
        return materialService.findAll();
    }

    @GetMapping(value = "/ml")
    public List<MaterialListResponseDto> ml() throws ParseException {
        // to Flask
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // make Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange("http://210.117.181.74:5000/detection", HttpMethod.GET, entity, String.class);

        // 디비 처리
        // 기존 데이터를 삭제
        materialService.delete();
        // 데이터 파싱해서 저장
        boolean egg = false, onion = false, orange = false, cabbage = false, cucumber = false;

        JSONParser info = new JSONParser();
        System.out.println(info.parse(response.getBody()));
        JSONArray ob = (JSONArray) info.parse(response.getBody());
        int size = ob.size();
        int i=0;
        while(true && size!=0) {
            switch(ob.get(i).toString()) {
                case "egg" :
                    egg = true;
                    break;
                case "onion" :
                    onion = true;
                    break;
                case "orange" :
                    orange = true;
                    break;
                case "cabbage" :
                    cabbage = true;
                    break;
                case "cucumber" :
                    cucumber = true;
                    break;
            }
            System.out.println(ob.get(i));
            i++;
            if(i==size) break;
        }


        MaterialSaveRequestDto requestDto = MaterialSaveRequestDto.builder()
                .egg(egg)
                .onion(onion)
                .orange(orange)
                .cabbage(cabbage)
                .cucumber(cucumber)
                .build();

        materialService.save(requestDto);

        return materialService.findAll();
    }
}
