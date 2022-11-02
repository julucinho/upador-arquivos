package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.exceptions;

public class UploadingFileToS3RuntimeException extends RuntimeException {
    public UploadingFileToS3RuntimeException(String name, String message) {
        super("Something went wrong while trying to upload file '"
                .concat(name)
                .concat("' to S3. See the following retrieved message from service: '")
                .concat(message)
                .concat("'")
        );
    }
}
