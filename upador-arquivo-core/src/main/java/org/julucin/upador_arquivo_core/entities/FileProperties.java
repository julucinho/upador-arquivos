package org.julucin.upador_arquivo_core.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public abstract class FileProperties {

    protected String fullPathToFile;

    public abstract File loadFile();


}
