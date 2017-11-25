package org.bdlions.controller;

import java.util.Map;
import org.bdlions.util.FacebookConfig;
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
@RequestMapping("/facebook")
public class FaceBookIndex {

    @RequestMapping("/template")
    public RedirectView template(@RequestParam(value = "name") String name, Map<String, Object> model) {
        RedirectView redirectView = new RedirectView();
        URIBuilder uriBuilder = new URIBuilder(FacebookConfig.getInstance().get(FacebookConfig.SHARE_URL));
        uriBuilder.addParameter("app_id", FacebookConfig.getInstance().get(FacebookConfig.APP_ID));
        uriBuilder.addParameter("display", "popup");
        uriBuilder.addParameter("href", FacebookConfig.getInstance().get(FacebookConfig.SHARE_HTML_LINK)+name);
        uriBuilder.addParameter("redirect_uri", FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL));
        String url = uriBuilder.toString();
        redirectView.setUrl(url);
        return redirectView;
    }
}
