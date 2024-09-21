package net.talaatharb.grammarsmith.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.Diagnostic;

import lombok.RequiredArgsConstructor;
import net.talaatharb.grammarsmith.lspclient.LspClient;
import net.talaatharb.grammarsmith.models.DiagnosticError;
import net.talaatharb.grammarsmith.models.DiagnosticsModel;

@RequiredArgsConstructor
public class DiagnosticsController {

    private final LspClient lspClient;
    private final DiagnosticsModel diagnosticsModel;

    public void requestDiagnostics(String text) {
        lspClient.requestDiagnosticsAsync(text, response -> {
            // Parse diagnostics from response and update model
            List<DiagnosticError> errors = parseDiagnostics(response);
            diagnosticsModel.clearErrors();
            diagnosticsModel.getErrors().addAll(errors);
            // Notify view to update error list
        });
    }

    private List<DiagnosticError> parseDiagnostics(List<Diagnostic> response) {
        // Convert LSP diagnostics into DiagnosticError objects
        List<DiagnosticError> errors = new ArrayList<>();
        for (var lspDiagnostic : response) {
            errors.add(new DiagnosticError(
                    lspDiagnostic.getRange().getStart().getLine(),
                    lspDiagnostic.getRange().getStart().getCharacter(),
                    lspDiagnostic.getMessage()
            ));
        }
        return errors;
    }
}

