package net.talaatharb.grammarsmith.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.Diagnostic;

import lombok.RequiredArgsConstructor;
import net.talaatharb.grammarsmith.lspclient.LspClient;
import net.talaatharb.grammarsmith.models.DiagnosticError;
import net.talaatharb.grammarsmith.models.GrammarModel;


@RequiredArgsConstructor
public class GrammarEditorController {

	private final LspClient lspClient;
	private final GrammarModel grammarModel;

	public void onTextChanged(String newText) {
		grammarModel.setGrammarText(newText);
		// Send request to LSP server for syntax highlighting and diagnostics
		lspClient.requestDiagnosticsAsync(newText, response -> {
			// Handle response: update the GrammarModel's errors
			List<DiagnosticError> errors = parseDiagnostics(response);
			grammarModel.getErrors().clear();
			grammarModel.getErrors().addAll(errors);
			// Notify the view to update error markers, if needed
		});
	}

	private List<DiagnosticError> parseDiagnostics(List<Diagnostic> response) {
		// Extract errors from the LSP response and convert to internal DiagnosticError
		// format
		List<DiagnosticError> errors = new ArrayList<>();
		for (var lspDiagnostic : response) {
			errors.add(new DiagnosticError(lspDiagnostic.getRange().getStart().getLine(),
					lspDiagnostic.getRange().getStart().getCharacter(), lspDiagnostic.getMessage()));
		}
		return errors;
	}
}
