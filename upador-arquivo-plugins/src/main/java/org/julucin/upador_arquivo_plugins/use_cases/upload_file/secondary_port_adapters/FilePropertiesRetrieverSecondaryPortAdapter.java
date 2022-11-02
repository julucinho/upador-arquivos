package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters;

import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.entities.factories.FilePropertiesFactory;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.UploadFilesUseCaseEnvVarRetriever;

public class FilePropertiesRetrieverSecondaryPortAdapter implements FilePropertiesRetrieverSecondaryPort {
    @Override
    public FileProperties usePort() {
        var fileProperties = FilePropertiesFactory.makeFileProperties();
        fileProperties.setFullPathToFile(UploadFilesUseCaseEnvVarRetriever.getFullPathToFile());
        return fileProperties;
    }
}
