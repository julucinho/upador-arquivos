package org.julucin.upador_arquivo_plugins.use_cases.upload_file.lambda_handler;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.UploadFilePrimaryPort;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.primary_port_initializer.UploadFilePrimaryPortInitializer;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Setter
@Getter
public class LambdaHandler implements RequestHandler<Map<String, String>, String> {

    private UploadFilePrimaryPort uploadFilePrimaryPort;

    @Override
    public String handleRequest(Map<String, String> stringStringMap, Context context) {
        log.info("Handling Lambda request process has initialized.");
        try {
            this.assurePrimaryPortIsInstantiated();
            this.uploadFilePrimaryPort.usePort();
            return "yay";
        } catch (Exception exception){
            log.error(exception.getMessage());
            return "not yay";
        }
    }

    private void assurePrimaryPortIsInstantiated() {
        log.info("Making sure primary port is instantiated.");
        if (Optional.ofNullable(this.uploadFilePrimaryPort).isEmpty())
            this.uploadFilePrimaryPort = this.instantiateNewPrimaryPortForUploadingFile();
    }

    private UploadFilePrimaryPort instantiateNewPrimaryPortForUploadingFile() {
        log.info("Instantiating primary port.");
        return UploadFilePrimaryPortInitializer.initializeUploadFilePrimaryPort();
    }
}
