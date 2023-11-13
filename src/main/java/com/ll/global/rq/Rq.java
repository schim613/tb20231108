package com.ll.global.rq;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String action;
    private final String queryString;
    private Map<String, String> params;

    public Rq(String cmd) {
        final String[] cmdBits =  cmd.split("\\?", 2);
        action = cmdBits[0].trim();
        queryString = cmdBits.length == 2 ? cmdBits[1].trim() : "";
        params = Arrays.stream(queryString.split("&"))
                .filter(param -> param.contains("="))
                .map(param -> param.split("=", 2))
                .collect(Collectors.toMap(
                        paramBits -> paramBits[0].trim(),
                        paramBits -> paramBits[1].trim(),
                        (existing, replacement) -> replacement));

        /*params = new HashMap<>();

        if (queryString.isBlank()) return;

        Arrays
                .stream(queryString.split("&"))
                .forEach(param -> {
                    final String[] paramBits = param.split("=", 2);
                    final String paramName = paramBits[0].trim();
                    final String paramValue = paramBits[1].trim();

                    params.put(paramName, paramValue);
                });*/
    }

    public String getAction() {
        return action;
    }

    public String getParameter(final String paramName) {
        return getParameter(paramName, null);
    }

    public String getParameter(final String paramName, final String defaultValue) {
        return params.getOrDefault(paramName, defaultValue);
    }
}
