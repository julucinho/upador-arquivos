package org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports;

import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.contracts.FileUploader;

public interface FileUploaderProviderSecondaryPort {

    FileUploader usePort();

}
