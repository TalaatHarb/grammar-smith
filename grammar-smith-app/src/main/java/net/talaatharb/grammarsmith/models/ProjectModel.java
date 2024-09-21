package net.talaatharb.grammarsmith.models;

import java.io.IOException;

import lombok.Data;

@Data
public class ProjectModel {
    private String projectName;
    private GrammarModel grammarModel;
    private ParseTreeModel parseTreeModel;
    private ASTModel astModel;
    private LLVMIRModel llvmIRModel;

    public ProjectModel(String projectName) {
        this.projectName = projectName;
    }

    public void saveProject(String directoryPath) throws IOException {
        // Serialize each model to files in the directory
//        grammarModel.saveToFile(directoryPath + "/grammar.txt");
//        parseTreeModel.saveToFile(directoryPath + "/parsetree.txt");
//        astModel.saveToFile(directoryPath + "/ast.txt");
        llvmIRModel.saveToFile(directoryPath + "/llvmir.txt");
    }

    public void loadProject(String directoryPath) throws IOException {
        // Load each model from files
//        grammarModel.loadFromFile(directoryPath + "/grammar.txt");
//        parseTreeModel.loadFromFile(directoryPath + "/parsetree.txt");
//        astModel.loadFromFile(directoryPath + "/ast.txt");
        llvmIRModel.loadFromFile(directoryPath + "/llvmir.txt");
    }
}

