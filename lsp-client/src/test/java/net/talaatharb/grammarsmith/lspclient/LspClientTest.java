package net.talaatharb.grammarsmith.lspclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.List;

import org.eclipse.lsp4j.Diagnostic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.grammarsmith.lspserver.HighlightInfo;
import net.talaatharb.grammarsmith.lspserver.LspServer;

@ExtendWith(MockitoExtension.class)
class LspClientTest {

	@InjectMocks
	private LspClient lspClient;

	@Mock
	private LspServer lspServer;

	@Test
	void testSendDocumentForHighlighting() {
		// Simulate sending grammar rules to the server
		when(lspServer.provideSyntaxHighlighting(anyList())).thenReturn(getSampleHighlighting());
		String grammarText = "if x == 10";

		List<HighlightInfo> highlightInfo = lspClient.requestSyntaxHighlighting(grammarText);

		// Ensure highlight info is received correctly
		assertNotNull(highlightInfo);
		assertEquals(3, highlightInfo.size()); // Assuming 3 tokens highlighted
	}

	@Test
	void testReceiveDiagnostics() {
		// Simulate receiving diagnostics from the server
		when(lspServer.provideDiagnostics(any())).thenReturn(getSampleDiagnostics());

		List<Diagnostic> diagnostics = lspClient.requestDiagnostics("if x == 10");

		// Ensure diagnostics are received correctly
		assertNotNull(diagnostics);
		assertEquals(0, diagnostics.size());
	}

	private List<HighlightInfo> getSampleHighlighting() {
		return List.of(new HighlightInfo(), new HighlightInfo(), new HighlightInfo());
	}

	private List<Diagnostic> getSampleDiagnostics() {
		return List.of();
	}
}
