package com.binaryCars.horses.exceptions;

import java.time.LocalDateTime;

public record ApiError(
    String path,
    String message,
    int errorCode,
    LocalDateTime timeStamp
) {

}
