package net.talaatharb.grammarsmith.lspclient;

import java.util.List;

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

}
