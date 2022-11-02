package org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions;

public class FileUploadRuntimeException extends RuntimeException {
    public FileUploadRuntimeException(String message, String fileName) {
        super("Something wrong happened while trying to upload file '"
                .concat(fileName)
                .concat("'. Error message: '")
                .concat(message)
                .concat("'")
        );
    }
}
