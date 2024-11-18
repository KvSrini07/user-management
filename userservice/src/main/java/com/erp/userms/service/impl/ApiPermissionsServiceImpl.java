package com.erp.userms.service.impl;

import com.erp.userms.DTO.ApiPermissionsDTO;
import com.erp.userms.entity.ApiPermissionEntity;
import com.erp.userms.repository.ApiPermissionRepository;
import com.erp.userms.repository.IServiceRepo;
import com.erp.userms.service.Interface.ApiPermissionInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiPermissionsServiceImpl implements ApiPermissionInterface {

    @Autowired
    private IServiceRepo iServiceRepo;

    @Autowired
    private ApiPermissionRepository apiPermissionRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(ApiPermissionsServiceImpl.class);

    @Override
    public ApiPermissionsDTO createApiPermission(ApiPermissionsDTO apiPermissionDTO) {
        ApiPermissionEntity apiPermissionEntity = toEntity(apiPermissionDTO);
        ApiPermissionEntity savedEntity = apiPermissionRepository.save(apiPermissionEntity);
        return toDto(savedEntity);
    }

    @Override
    public List<ApiPermissionsDTO> getAllApiPermissions() {
        List<ApiPermissionEntity> permissions = apiPermissionRepository.findAll();
        return permissions.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ApiPermissionsDTO toDto(ApiPermissionEntity apiPermissionEntity) {
        if (apiPermissionEntity == null) {
            return null;
        }

        ApiPermissionsDTO apiPermissionDTO = new ApiPermissionsDTO();
        apiPermissionDTO.setId(apiPermissionEntity.getId());
        apiPermissionDTO.setName(apiPermissionEntity.getName());
        apiPermissionDTO.setMethod(apiPermissionEntity.getMethod());
        apiPermissionDTO.setDescription(apiPermissionEntity.getDescription());
        apiPermissionDTO.setStatus(apiPermissionEntity.getStatus());

        // Map the service IDs
//        List<Long> serviceIds = apiPermissionEntity.getServices()
//                .stream()
//                .map(ServiceEntity::getServiceId)
//                .collect(Collectors.toList());
//        apiPermissionDTO.setServiceIds(serviceIds);

        return apiPermissionDTO;
    }

    // Convert from DTO to Entity
    public static ApiPermissionEntity toEntity(ApiPermissionsDTO apiPermissionDTO) {
        if (apiPermissionDTO == null) {
            return null;
        }

        ApiPermissionEntity apiPermissionEntity = new ApiPermissionEntity();
        apiPermissionEntity.setId(apiPermissionDTO.getId());
        apiPermissionEntity.setName(apiPermissionDTO.getName());
        apiPermissionEntity.setMethod(apiPermissionDTO.getMethod());
        apiPermissionEntity.setDescription(apiPermissionDTO.getDescription());
        apiPermissionEntity.setStatus(apiPermissionDTO.getStatus());

        return apiPermissionEntity;
    }


    @Override
    public boolean isPermissionNameExists(String name) { return apiPermissionRepository.existsByName(name); }

    @Override
    public ApiPermissionsDTO updateApiPermission(Long id, ApiPermissionsDTO apiPermissionDTO) {
        ApiPermissionEntity existingPermission = apiPermissionRepository.findById(id).orElse(null);

        if (existingPermission == null) {
            return null;
        }

        existingPermission.setName(apiPermissionDTO.getName());
        existingPermission.setMethod(apiPermissionDTO.getMethod());
        existingPermission.setDescription(apiPermissionDTO.getDescription());
        existingPermission.setStatus(apiPermissionDTO.getStatus());

        ApiPermissionEntity updatedEntity = apiPermissionRepository.save(existingPermission);
        return toDto(updatedEntity);
    }

    @Override
    public boolean deleteApiPermission(Long id) {
        if (!apiPermissionRepository.existsById(id)) {
            return false; // API permission not found
        }

        apiPermissionRepository.deleteById(id);
        return true;
    }

}
