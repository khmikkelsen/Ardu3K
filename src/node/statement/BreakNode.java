package node.statement;

import node.RootNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTVisitor;
import visitor.BaseASTVisitor;

public class BreakNode extends RootNode {

    public BreakNode(RootNode parent) {
        super(parent);
    }

    public BreakNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public BreakNode(RootNode parent, ParserRuleContext ctx) {
        super(parent, ctx);
    }

    public BreakNode() {
    }

    @Override
    public String toString() { return "BREAK"; }

}
