package net.talaatharb.grammarsmith.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ASTNode {
    private final String type;  // e.g., Expression, Statement, etc.
    private final String value; // e.g., variable names, constants
    private final List<ASTNode> children = new ArrayList<>();

    public void addChild(ASTNode child) {
        children.add(child);
    }
}

