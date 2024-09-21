package net.talaatharb.grammarsmith.controllers;

import lombok.RequiredArgsConstructor;
import net.talaatharb.grammarsmith.lspclient.LspClient;
import net.talaatharb.grammarsmith.models.ASTModel;
import net.talaatharb.grammarsmith.models.ASTNode;

@RequiredArgsConstructor
public class ASTController {

	private final LspClient lspClient;
	private final ASTModel astModel;

	public void requestAST(String inputCode) {
		// Send request to LSP server to get AST
		lspClient.requestASTAsync(inputCode, response -> {
			// Handle response: update ASTModel with the new AST
			ASTNode rootNode = null;
			astModel.setRoot(rootNode);
			// Notify the view to update the AST visualization
		});
	}

	public void requestLLVMConversion(String inputCode) {
		// Convert AST to LLVM IR
		lspClient.requestLLVMIRAsync(inputCode, response -> {
			// Handle response: store LLVM IR in the ASTModel
			// Notify view to update the LLVM IR display
		});
	}

//    private ASTNode parseASTFromResponse(LSPResponse response) {
//        // Parse the response into your custom ASTNode structure
//        return response.getAST();
//    }
}
