package com.example.doma2test.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger("appLogger");

    // システム日付をStringで返す
    public static void logValidatinError(LogContext context, String title, String message) {
        logger.info("場所＝{}, ファイル＝{}, 行番号＝{}, タイトル＝{}, メッセージ＝{}", 
                    context.getClassName(), context.getFileName(), context.getLineNumber(), title, message);
    }
}
