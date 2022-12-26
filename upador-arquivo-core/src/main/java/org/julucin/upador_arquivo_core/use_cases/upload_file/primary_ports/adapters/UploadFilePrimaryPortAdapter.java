package org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.adapters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.UploadFileUseCaseActivityImpl;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.UploadFilePrimaryPort;

@Slf4j
@RequiredArgsConstructor
public class UploadFilePrimaryPortAdapter implements UploadFilePrimaryPort {

    private final UploadFileUseCaseActivity uploadFileUseCaseActivity;

    @Override
    public void usePort() {
        log.info("Executing primary port for uploading file");
        this.uploadFileUseCaseActivity.execute();
    }
}
