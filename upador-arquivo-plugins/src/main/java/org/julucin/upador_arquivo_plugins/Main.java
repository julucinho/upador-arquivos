package org.julucin.upador_arquivo_plugins;

import org.julucin.upador_arquivo_plugins.use_cases.upload_file.primary_port_initializer.UploadFilePrimaryPortInitializer;

public class Main {

    public static void main(String[] args) {
        try {
            UploadFilePrimaryPortInitializer.initializeUploadFilePrimaryPort().usePort();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
