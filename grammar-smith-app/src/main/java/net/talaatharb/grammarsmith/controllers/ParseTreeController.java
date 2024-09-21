package net.talaatharb.grammarsmith.controllers;

import lombok.RequiredArgsConstructor;
import net.talaatharb.grammarsmith.lspclient.LspClient;
import net.talaatharb.grammarsmith.models.ParseTreeModel;

@RequiredArgsConstructor
public class ParseTreeController {

    private final LspClient lspClient;
    private final ParseTreeModel parseTreeModel;

    public void onInputCodeChanged(String inputCode) {
        // Send a request to the LSP server to generate the parse tree
        lspClient.requestParseTree(inputCode, response -> {
            parseTreeModel.setRoot(response);
            // Notify view to update the parse tree visualization
        });
    }
}

