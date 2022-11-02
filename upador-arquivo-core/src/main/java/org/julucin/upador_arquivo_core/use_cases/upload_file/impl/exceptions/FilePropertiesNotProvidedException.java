package org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions;

public class FilePropertiesNotProvidedException extends RuntimeException{

    public FilePropertiesNotProvidedException(){
        super("File properties object was not provided by the secondary port adapter.");
    }

}
