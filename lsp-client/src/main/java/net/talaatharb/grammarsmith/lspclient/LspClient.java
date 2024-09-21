package net.talaatharb.grammarsmith.lspclient;

import java.util.List;
import java.util.function.Consumer;

import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.lsp4j.Diagnostic;

import lombok.RequiredArgsConstructor;
import net.talaatharb.grammarsmith.lspserver.HighlightInfo;
import net.talaatharb.grammarsmith.lspserver.LspServer;

@RequiredArgsConstructor
public class LspClient {
	
	private final LspServer lspServer;

	public List<HighlightInfo> requestSyntaxHighlightingSync(String text) {
		var tokens = lspServer.provideTokens(text);
		return lspServer.provideSyntaxHighlighting(tokens);
	}

	public List<Diagnostic> requestDiagnosticsSync(String text) {
		var tokens = lspServer.provideTokens(text);
		return lspServer.provideDiagnostics(lspServer.provideParseTree(tokens));
	}
	
	public void requestDiagnosticsAsync(String text, Consumer<List<Diagnostic>> callback) {
        // Send a request to the LSP server for diagnostics
        // Once the response is received, call the callback with the response
    }
	
	public void requestParseTreeAsync(String text, Consumer<ParseTree> callback) {
		// Send a request to the LSP server for parse tree
	}
	
	public void requestASTAsync(String text, Consumer<Object> callback) {
		// Send a request to the LSP server for parse tree
	}
	
	public void requestLLVMIRAsync(String text, Consumer<String> callback) {
		// Send a request to the LSP server for parse tree
	}

}
