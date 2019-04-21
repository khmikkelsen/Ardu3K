package node.expression;

import node.RootNode;
import visitor.ASTVisitor;
import visitor.BaseASTVisitor;

public abstract class AbstractInfixExpressionNode extends AbstractExpressionNode {

    public RootNode getLeft() {
        if (children.size() > 0) {
            return children.get(0);
        } else return null;
    }
    public RootNode getRight() {
        if (children.size() > 1) {
            return children.get(1);
        } else return null;
    }
    public void setLeft(RootNode node) {
        if(children.size() > 0)
            children.set(0, node);
        else
            children.add(node);
    }
    public void setRight(RootNode node) {
        if(children.size() > 1)
            children.set(1, node);
        else
            children.add(node);
    }

    @Override
    public <T> T accept(ASTVisitor<? extends T> visitor) {
        if ( visitor instanceof BaseASTVisitor) return ((BaseASTVisitor<? extends T>)visitor).visitAbstractInfixExpressionNode(this);
        else return visitor.visitChildren(this);
    }
}
