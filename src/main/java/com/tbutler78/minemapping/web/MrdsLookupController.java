package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.MrdsLookup;
import com.tbutler78.minemapping.service.MrdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by butlert on 4/16/17.
 */

@Controller
@RequestMapping("mrdslookup")
public class MrdsLookupController {

    private final MrdsService mrdsService;

    @Autowired
    public MrdsLookupController(MrdsService mrdsService) {
        this.mrdsService = mrdsService;
    }

    @RequestMapping
    @ResponseBody
    public List<MrdsLookup> getAll(){
        return mrdsService.getAll();
    }
}


