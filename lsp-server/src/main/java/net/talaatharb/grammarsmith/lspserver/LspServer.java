package net.talaatharb.grammarsmith.lspserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.lsp4j.Diagnostic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LspServer {

//	private final Lexer lexer;
//	private final Parser parser;

	public List<? extends Token> provideTokens(String text) {
		return Arrays.asList(text.split("\\S+")).stream().map(s -> new CommonToken(0, s)).toList();
	}
	
	public ParseTree provideParseTree(List<? extends Token> tokens) {
		return null;
	}

	public List<HighlightInfo> provideSyntaxHighlighting(List<? extends Token> tokens) {
		return tokens.stream().map(t -> new HighlightInfo()).toList();
	}

	public List<Diagnostic> provideDiagnostics(ParseTree tree) {
		return new ArrayList<>();
	}

}
