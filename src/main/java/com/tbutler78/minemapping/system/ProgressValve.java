package com.tbutler78.minemapping.system;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.poi.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;

public class ProgressValve extends ValveBase {

  @Override
  public void invoke(Request request, Response response) throws IOException, ServletException {
    try (InputStream loadingHtml = getClass().getResourceAsStream("loading.html")) {
      IOUtils.copy(loadingHtml, response.getOutputStream());
    }
  }
  public ProgressValve() {
    Listener
        .initialization()
        .thenRun(this::removeMyself);
  }

  private void removeMyself() {
    getContainer().getPipeline().removeValve(this);
  }
}
