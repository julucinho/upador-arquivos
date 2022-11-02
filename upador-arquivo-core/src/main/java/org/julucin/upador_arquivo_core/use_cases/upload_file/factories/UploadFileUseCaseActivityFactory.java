package org.julucin.upador_arquivo_core.use_cases.upload_file.factories;

import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.UploadFileUseCaseActivityImpl;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;


public class UploadFileUseCaseActivityFactory {

    public UploadFileUseCaseActivity makeUseCaseActivity(
            FileUploaderProviderSecondaryPort fileUploaderProviderSecondaryPort,
            FilePropertiesRetrieverSecondaryPort filePropertiesRetrieverSecondaryPort){
        return new UploadFileUseCaseActivityImpl(fileUploaderProviderSecondaryPort, filePropertiesRetrieverSecondaryPort);
    }

}
