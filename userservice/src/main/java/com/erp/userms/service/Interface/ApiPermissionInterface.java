package com.erp.userms.service.Interface;

import com.erp.userms.DTO.ApiPermissionsDTO;

import java.util.List;

public interface ApiPermissionInterface {
    ApiPermissionsDTO createApiPermission(ApiPermissionsDTO permissionDTO);

    List<ApiPermissionsDTO> getAllApiPermissions();

    boolean isPermissionNameExists(String name);

    ApiPermissionsDTO updateApiPermission(Long id, ApiPermissionsDTO apiPermissionDTO);

    boolean deleteApiPermission(Long id);
}
