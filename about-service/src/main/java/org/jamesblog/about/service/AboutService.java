package org.jamesblog.about.service;

import org.jamesblog.about.mapper.AboutMapper;
import org.jamesblog.about.model.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: James-CSH
 * @Date: 11/5/17 3:11 PM
 */
@Service
public class AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    public About getUseAbout() {
        return aboutMapper.selectByUse();
    }

}
