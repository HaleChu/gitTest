package pers.god.demo.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chuhao
 * @Description:
 * @Date 2020/10/29
 */
public interface DownloadService {

    void downloadFile(HttpServletResponse response);
}
