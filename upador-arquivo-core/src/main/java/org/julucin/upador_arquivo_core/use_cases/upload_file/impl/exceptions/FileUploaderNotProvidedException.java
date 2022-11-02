package org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions;

public class FileUploaderNotProvidedException extends RuntimeException{

    public FileUploaderNotProvidedException(){
        super("File uploader object was not provided by the secondary port adapter.");
    }


}
