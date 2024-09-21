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

	public List<HighlightInfo> requestSyntaxHighlighting(String text) {
		var tokens = lspServer.provideTokens(text);
		return lspServer.provideSyntaxHighlighting(tokens);
	}

	public List<Diagnostic> requestDiagnostics(String text) {
		var tokens = lspServer.provideTokens(text);
		return lspServer.provideDiagnostics(lspServer.provideParseTree(tokens));
	}
	
	public void requestDiagnostics(String text, Consumer<List<Diagnostic>> callback) {
        // Send a request to the LSP server for diagnostics
        // Once the response is received, call the callback with the response
    }
	
	public void requestParseTree(String text, Consumer<ParseTree> callback) {
		// Send a request to the LSP server for parse tree
	}
	
	public void requestAST(String text, Consumer<Object> callback) {
		// Send a request to the LSP server for parse tree
	}
	
	public void requestLLVMIR(String text, Consumer<String> callback) {
		// Send a request to the LSP server for parse tree
	}

}
