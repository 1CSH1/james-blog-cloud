package org.jamesblog.about.controller;

import org.jamesblog.about.model.About;
import org.jamesblog.about.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: James-CSH
 * @Date: 11/5/17 3:11 PM
 */
@RestController
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @RequestMapping(value = "about/use", method = RequestMethod.GET)
    public ResponseEntity<About> getUseAbout() throws Exception {
        return Optional.ofNullable(aboutService.getUseAbout())
                .map(about -> new ResponseEntity<About>(about, HttpStatus.OK))
                .orElseThrow(() -> new Exception("getAbout() throw Exception"));
    }

}
