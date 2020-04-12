class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

// A Java program to introduce Binary Tree
class BinaryTree
{
    // Root of Binary Tree
    Node root;

    // Constructors
    BinaryTree(int key)
    {
        root = new Node(key);
    }

    BinaryTree()
    {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
  "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }


    static Node add(Node current, Node n){ //TODO doesn't work on empty tree
        if (current == null) {
            current = n;
            return current;
        }

        /* Otherwise, recur down the tree */
        if (n.key < current.key)
            current.left = add(current.left, n);
        else if (n.key > current.key)
            current.right = add(current.right, n);
        return current;
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    public static void main(String[] args)
    {
        BinaryTree tree1 = new BinaryTree();

        /*create root*/
        tree1.root = new Node(1);

    /* following is the tree after above statement

          1
        /   \
      null  null     */

        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);

    /* 2 and 3 become left and right children of 1
           1
         /   \
        2      3
      /    \    /  \
    null null null null  */


        tree1.root.left.left = new Node(4);
    /* 4 becomes left child of 2
                1
            /       \
           2          3
         /   \       /  \
        4    null  null  null
       /   \
      null null
     */
        System.out.println("Preorder traversal of binary tree is ");
        tree1.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree1.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree1.printPostorder();

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(0);
        tree2.add(tree2.root,new Node(1));
        tree2.add(tree2.root,new Node(2));
        tree2.add(tree2.root,new Node(3));
        tree2.add(tree2.root,new Node(4));
        tree2.add(tree2.root,new Node(5));
        tree2.add(tree2.root,new Node(6));
        tree2.add(tree2.root,new Node(7));
        tree2.add(tree2.root,new Node(8));
        tree2.add(tree2.root,new Node(9));
        tree2.add(tree2.root,new Node(10));

        System.out.println("\nInorder traversal of binary tree is ");
        tree2.printInorder(tree2.root);
    }
}
