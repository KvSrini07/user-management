//package com.pix.userms.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "service_api_permissions")
//public class ServiceApiPermissionEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "service_id", nullable = false)
//    private ServiceEntity serviceEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "api_permission_id", nullable = false)
//    private ApiPermissionEntity apiPermissionEntity;
//
//    public ServiceApiPermissionEntity() {}
//
//    public ServiceApiPermissionEntity(ServiceEntity serviceEntity, ApiPermissionEntity apiPermissionEntity) {
//        this.serviceEntity = serviceEntity;
//        this.apiPermissionEntity = apiPermissionEntity;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public ServiceEntity getServiceEntity() {
//        return serviceEntity;
//    }
//
//    public void setServiceEntity(ServiceEntity serviceEntity) {
//        this.serviceEntity = serviceEntity;
//    }
//
//    public ApiPermissionEntity getApiPermissionEntity() {
//        return apiPermissionEntity;
//    }
//
//    public void setApiPermissionEntity(ApiPermissionEntity apiPermissionEntity) {
//        this.apiPermissionEntity = apiPermissionEntity;
//    }
//}
