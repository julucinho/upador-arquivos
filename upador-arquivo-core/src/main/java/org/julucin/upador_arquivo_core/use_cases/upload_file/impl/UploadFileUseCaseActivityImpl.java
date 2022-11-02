package org.julucin.upador_arquivo_core.use_cases.upload_file.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.contracts.FileUploader;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FilePropertiesNotProvidedException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FileUploadRuntimeException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FileUploaderNotProvidedException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;

import java.io.File;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class UploadFileUseCaseActivityImpl implements UploadFileUseCaseActivity {

    private final FileUploaderProviderSecondaryPort fileUploaderProviderSecondaryPort;
    private final FilePropertiesRetrieverSecondaryPort filePropertiesRetrieverSecondaryPort;

    @Override
    public void execute() {
        var fileProperties = this.getFileProperties();
        var file = this.loadFileUsing(fileProperties);
        this.tryToUpload(file);
    }

    private FileProperties getFileProperties() {
        log.info("Retrieving the file properties to use.");
        return Optional.ofNullable(this.filePropertiesRetrieverSecondaryPort.usePort())
                .orElseThrow(FilePropertiesNotProvidedException::new);
    }

    private File loadFileUsing(FileProperties fileProperties) {
        log.info("Loading the file to memory.");
        return fileProperties.loadFile();
    }

    private void tryToUpload(File file) {
        var fileUploader = this.getFileUploader();
        try {
            log.info("Trying to upload the file.");
            fileUploader.upload(file);
        } catch (Exception exception){
            throw new FileUploadRuntimeException(exception.getMessage(), file.getName());
        }
    }

    private FileUploader getFileUploader() {
        log.info("Retrieving the file uploader to use.");
        return Optional.ofNullable(this.fileUploaderProviderSecondaryPort.usePort())
                .orElseThrow(FileUploaderNotProvidedException::new);
    }

}
