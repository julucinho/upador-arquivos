package org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.factories;

import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.UploadFilePrimaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.adapters.UploadFilePrimaryPortAdapter;

public class UploadFilePrimaryPortFactory {

    public UploadFilePrimaryPort makePrimaryPort(UploadFileUseCaseActivity uploadFileUseCaseActivity){
        return new UploadFilePrimaryPortAdapter(uploadFileUseCaseActivity);
    }

}
