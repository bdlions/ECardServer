package org.bdlions.controller;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bdlions.util.FacebookConfig;
import org.bdlions.util.URIBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author alamgir
 */
//@CrossOrigin
//@Controller
@RestController
//@RequestMapping(method = RequestMethod.GET)
@RequestMapping("/testtemplate")
public class TemplateGen {

    @RequestMapping("/template")
    public String template(@RequestParam(value = "name") String name, Map<String, Object> model) {
        String generatedImgDirURL = FacebookConfig.getInstance().get(FacebookConfig.RESOURCE_URL) + "generated/images/";

        String generatedImgPath = generatedImgDirURL  + name + ".png";
        model.put("page_title", "Blue Whale Fever");
        model.put("url", FacebookConfig.getInstance().get(FacebookConfig.SHARE_HTML_LINK) + "?name=" + name);
        model.put("app_title", "Will you be addicted in Blue Whale?");
        model.put("description", "I invited you to test by yourself? Click here to see your result.");
        model.put("image_url", generatedImgPath);
        model.put("image_type", "image/png");
        model.put("image_width", "800");
        model.put("image_height", "420");
        model.put("app_login_url", getLoginURL());
        return "template";
    }

    public String getLoginURL() {
        URIBuilder uriBuilder = new URIBuilder(FacebookConfig.getInstance().get(FacebookConfig.AUTH_URL));
        uriBuilder.addParameter("client_id", FacebookConfig.getInstance().get(FacebookConfig.APP_ID));
        uriBuilder.addParameter("redirect_uri", FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL));
        uriBuilder.addParameter("scope", FacebookConfig.getInstance().get(FacebookConfig.SCOPE));
        String url = uriBuilder.toString();
        return url;
    }
}
