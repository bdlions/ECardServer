/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bdlions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alamgir
 */
@RestController
public class ControllerIndex {
    @RequestMapping("/")
    String home() {
        return "ECard service.";
    }
}
