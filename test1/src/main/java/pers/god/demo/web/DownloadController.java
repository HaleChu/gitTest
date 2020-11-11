package pers.god.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.god.demo.service.DownloadService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/29
 */
@RestController
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @RequestMapping("download")
    public void downloadFile(HttpServletResponse response) {
        downloadService.downloadFile(response);
    }

}
