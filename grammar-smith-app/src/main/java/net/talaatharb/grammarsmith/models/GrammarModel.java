package net.talaatharb.grammarsmith.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GrammarModel {
    private String grammarText;
    private final List<DiagnosticError> errors = new ArrayList<>();
}

