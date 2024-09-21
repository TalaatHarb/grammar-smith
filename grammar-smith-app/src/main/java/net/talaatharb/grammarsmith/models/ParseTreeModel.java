package net.talaatharb.grammarsmith.models;

import org.antlr.v4.runtime.tree.ParseTree;

import lombok.Data;

@Data
public class ParseTreeModel {
    private ParseTree root;

    public String toText() {
        // Convert parse tree to text (for Git compatibility)
        return root.toStringTree();
    }
}

