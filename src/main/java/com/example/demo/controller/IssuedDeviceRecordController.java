package com.example.demo.controller;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/devices")