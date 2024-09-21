package net.talaatharb.grammarsmith.lspserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.lsp4j.Diagnostic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LspServerTest {

	@InjectMocks
	private LspServer lspServer;

	@Mock
	private Parser parser;

	@Mock
	private Lexer lexer;

	@Test
	void testSyntaxHighlighting() {
		// Simulating the process of syntax highlighting
		when(lexer.getAllTokens()).thenAnswer(invocation -> List.of(
			    new CommonToken(0, "if"),
			    new CommonToken(0, "x"),
			    new CommonToken(0, "==")
			));
		List<? extends Token> tokens = lexer.getAllTokens();
		List<HighlightInfo> highlights = lspServer.provideSyntaxHighlighting(tokens);

		// Ensure highlighting info is correctly generated
		assertNotNull(highlights);
		assertEquals(3, highlights.size()); // Assuming 3 tokens for testing
	}

	@Test
	void testDiagnostics() {
		when(parser.getRuleContext()).thenReturn(mock(ParserRuleContext.class));

		ParseTree tree = parser.getRuleContext();
		List<Diagnostic> diagnostics = lspServer.provideDiagnostics(tree);

		// Ensure diagnostics are provided (mock tree is error-free)
		assertNotNull(diagnostics);
		assertEquals(0, diagnostics.size()); // No errors expected
	}

}
