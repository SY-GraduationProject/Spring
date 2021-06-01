package com.rm.app.refrigerator_management_app.service.material;

import com.rm.app.refrigerator_management_app.domain.material.Material;
import com.rm.app.refrigerator_management_app.domain.material.MaterialRepository;
import com.rm.app.refrigerator_management_app.web.dto.MaterialListResponseDto;
import com.rm.app.refrigerator_management_app.web.dto.MaterialSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    @Transactional // db에 접근해서 바꿔야할 때 사용
    public Long save(MaterialSaveRequestDto requestDto) {
        return materialRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete() {
        List<Material> all = materialRepository.findAll();
        int size = all.size();
        if(size != 0) {
            Material material = all.get(size-1); // 마지막 튜플을 가져옴
            materialRepository.delete(material);
        }
    }

    @Transactional(readOnly = true)
    public List<MaterialListResponseDto> findAll() {
        return materialRepository.findAll().stream()
                .map(MaterialListResponseDto::new)
                .collect(Collectors.toList());
    }
}
