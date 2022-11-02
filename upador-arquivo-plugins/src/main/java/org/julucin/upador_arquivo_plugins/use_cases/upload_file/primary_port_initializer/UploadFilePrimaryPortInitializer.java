package org.julucin.upador_arquivo_plugins.use_cases.upload_file.primary_port_initializer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.factories.UploadFileUseCaseActivityFactory;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.UploadFilePrimaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.factories.UploadFilePrimaryPortFactory;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.FilePropertiesRetrieverSecondaryPortAdapter;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.FileUploaderProviderSecondaryPortAdapter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UploadFilePrimaryPortInitializer {

    public static UploadFilePrimaryPort initializeUploadFilePrimaryPort(){
        return new UploadFilePrimaryPortFactory().makePrimaryPort(getUploadFileUseCaseActivity());
    }

    private static UploadFileUseCaseActivity getUploadFileUseCaseActivity() {
        var fileUploaderSecondaryPort = initializeFileUploaderProviderSecondaryPort();
        var fileRetrieverSecondaryPort = initializeFilePropertiesRetrieverSecondaryPort();
        return new UploadFileUseCaseActivityFactory().makeUseCaseActivity(fileUploaderSecondaryPort, fileRetrieverSecondaryPort);
    }

    private static FileUploaderProviderSecondaryPort initializeFileUploaderProviderSecondaryPort() {
        return new FileUploaderProviderSecondaryPortAdapter();
    }

    private static FilePropertiesRetrieverSecondaryPort initializeFilePropertiesRetrieverSecondaryPort() {
        return new FilePropertiesRetrieverSecondaryPortAdapter();
    }

}
