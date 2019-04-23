package node.composite;

import node.RootNode;
import visitor.ASTVisitor;
import visitor.BaseASTVisitor;

import java.util.ArrayList;

public class ListNode extends RootNode {
    @Override
    public String toString() { return "[LIST]"; }

    @Override
    public <T> T accept(ASTVisitor<? extends T> visitor) {
        if ( visitor instanceof BaseASTVisitor) return ((BaseASTVisitor<? extends T>)visitor).visitListNode(this);
        else return visitor.visitChildren(this);
    }

    public void setID(RootNode node){
        if (children.size() > 0){
            children.set(0, node);
        } else children.add(node);
    }
    public RootNode getID(){ return children.get(0); }

    public void addFirstElement(RootNode node){
        if (children.size() != 0){
            children.add(node);
        } else children.add(children.size(), node);
    }
    // Throws exception if invalid ID
    public RootNode getFirstElement() {
        try {
            if (children.size() > 1) {
                return children.get(1);
            } else throw new Exception("INVALID index of list value");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
