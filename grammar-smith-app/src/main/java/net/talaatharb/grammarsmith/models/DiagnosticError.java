package net.talaatharb.grammarsmith.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DiagnosticError {
    private final int line;
    private final int column;
    private final String message;
}
