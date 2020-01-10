package com.mdtech.minio_sample.common.controller;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JsonView extends AbstractView {
    private Object result;

    public JsonView(Object result) {
        super();
        this.result = result;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        String resultAsJSONString = JsonSerializerManager.serialize(result);
        response.getWriter().write(resultAsJSONString);
    }

}
