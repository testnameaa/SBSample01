package com.example.doma2test.common;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class LogContext {
    private String className;
    private String fileName;
    private Integer lineNumber;

    public LogContext() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        String prefix = "com.example.doma2test.";
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (StringUtils.startsWith(className, prefix) && !StringUtils.contains(className, "LogContext")) {
                this.className = className.replace(prefix,"");
                break;
            }
        }
    }
}
