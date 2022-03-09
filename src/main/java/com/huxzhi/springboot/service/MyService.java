package com.huxzhi.springboot.service;

import com.huxzhi.springboot.controller.dto.PostResidenceDTO;

import java.util.Map;

public interface MyService {
    Map getData(Integer id);

    void postResidence(PostResidenceDTO postResidenceDTO);
}
