package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Device_CatalogItem")
public class DeviceCatalogItem{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column (unique=true)
    private String deviceCode;
    private String deviceType;
    private String model;
    @Max(1)
    private Integer maxAllowedPerEmployee;
    private Boolean active;
    public DeviceCatalogItem(){
    }
}