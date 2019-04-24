package node.expression.multiplicative;

import gen.Ardu3kParser;
import visitor.ASTVisitor;
import visitor.BaseASTVisitor;

public class ExponentialNode extends AbstractInfixMultiplicativeNode {

    public ExponentialNode(Ardu3kParser.InfixMultiplicativeExprContext ctx) {
        super(ctx);
    }

    @Override
    public String toString() {
        return "^";
    }

}
