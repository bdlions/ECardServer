package org.bdlions.controller;

import java.util.Map;
import org.bdlions.util.LinkedInConfig;
import org.bdlions.util.URIBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author nazmul hasan
 */
//@CrossOrigin
//@Controller
@RestController
//@RequestMapping(method = RequestMethod.GET)
@RequestMapping("/linkedin")
public class LinkedInIndex {

    @RequestMapping("/template")
    public RedirectView template(@RequestParam(value = "name") String name, Map<String, Object> model) {
        RedirectView redirectView = new RedirectView();
        URIBuilder uriBuilder = new URIBuilder(LinkedInConfig.getInstance().get(LinkedInConfig.SHARE_URL));
        uriBuilder.addParameter("url", LinkedInConfig.getInstance().get(LinkedInConfig.SHARE_HTML_LINK) + name);
        uriBuilder.addParameter("mini", LinkedInConfig.getInstance().get(LinkedInConfig.MINI));
        uriBuilder.addParameter("title", LinkedInConfig.getInstance().get(LinkedInConfig.TITLE));
        uriBuilder.addParameter("summary", LinkedInConfig.getInstance().get(LinkedInConfig.SUMMARY));
        uriBuilder.addParameter("source", LinkedInConfig.getInstance().get(LinkedInConfig.SOURCE));
        String url = uriBuilder.toString();
        redirectView.setUrl(url);
        return redirectView;
    }
}
