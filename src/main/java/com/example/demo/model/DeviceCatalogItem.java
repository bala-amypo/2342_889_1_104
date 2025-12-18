package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Device_CatalogItem")
public class DeviceCatalogItem{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
}