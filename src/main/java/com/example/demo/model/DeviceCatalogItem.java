package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Device_CatalogItem")
public class DeviceCatalogItem{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column (unique=true)
    private String deviceCode;
    @NotBlank
    private String deviceType;
    @NotBlank
    private String model;
    @NotNull
    @Min(1)
    private Integer maxAllowedPerEmployee;
    @NotNull
    private Boolean active;
    public DeviceCatalogItem(){
    }
    public DeviceCatalogItem(Long id, String deviceCode, String deviceType, String model,
            @Max(1) Integer maxAllowedPerEmployee, Boolean active) {
        this.deviceCode = deviceCode;
        this.deviceType = deviceType;
        this.model = model;
        this.maxAllowedPerEmployee = maxAllowedPerEmployee;
    }
    @PrePersist
    void onCreate(){
        if(this.active==null){
            this.active=true;
        }
    }
    public Long getid() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDeviceCode() {
        return deviceCode;
    }
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getMaxAllowedPerEmployee() {
        return maxAllowedPerEmployee;
    }
    public void setMaxAllowedPerEmployee(Integer maxAllowedPerEmployee) {
        this.maxAllowedPerEmployee = maxAllowedPerEmployee;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    
}