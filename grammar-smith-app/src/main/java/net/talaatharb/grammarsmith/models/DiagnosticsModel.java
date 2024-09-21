package net.talaatharb.grammarsmith.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DiagnosticsModel {
    private final List<DiagnosticError> errors = new ArrayList<>();

    public void addError(DiagnosticError error) {
        errors.add(error);
    }

    public void clearErrors() {
        errors.clear();
    }
}



