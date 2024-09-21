package net.talaatharb.grammarsmith.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LLVMIRModel {
    private String llvmIRCode;

    public void saveToFile(String filePath) throws IOException {
        Files.write(Paths.get(filePath), llvmIRCode.getBytes());
    }

    public void loadFromFile(String filePath) throws IOException {
        this.llvmIRCode = new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

