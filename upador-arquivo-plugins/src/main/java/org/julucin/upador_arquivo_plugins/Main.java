package org.julucin.upador_arquivo_plugins;

import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.primary_port_initializer.UploadFilePrimaryPortInitializer;

@Slf4j
public class Main {

    public static void main(String[] args) {
        try {
            UploadFilePrimaryPortInitializer.initializeUploadFilePrimaryPort().usePort();
        } catch (Exception exception){
            log.error(exception.getMessage());
        }
    }
}
