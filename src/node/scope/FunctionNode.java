package node.scope;

import gen.Ardu3kParser;
import node.RootNode;
import node.primary.VoidNode;
import visitor.semantic.ExpressionTypeVisitor;

public class FunctionNode extends RootNode {
    private RootNode returnType;
    public FunctionNode(Ardu3kParser.FunctionContext ctx) {
        super(ctx);
    }

    @Override
    public String toString() { return "Function "; }

    public RootNode getId() {
        return children.get(0);
    }
    public void setId(RootNode node) {
        if(children.size() > 0)
            children.set(0, node);
        else
            children.add(node);
    }

    public RootNode getParameter() {
        return children.get(1);
    }
    public void setParameter(RootNode node) {
        if(children.size() > 1)
            children.set(1, node);
        else
            children.add(node);
    }

    public RootNode getBlock() {
        return children.get(2);
    }
    public void setBlock(RootNode node) {
        if(children.size() > 2)
            children.set(2, node);
        else
            children.add(node);
    }

    public RootNode getReturnType() {
        if (returnType == null) { // If not already set
            setReturnType();
            if (returnType != null) {
                return returnType;

            } else return new VoidNode();
        } else return returnType;
    }
    private void setReturnType(){
        ExpressionTypeVisitor exprVisit = new ExpressionTypeVisitor();
        returnType = exprVisit.visit(this);
    }
}
