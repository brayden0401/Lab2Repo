class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
/*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   
   /*
   pre-order traversal
   */
   
   /**
    * A method that traverses the tree in the pre order
    * @param root node of tree
    */
   public void preOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }

      System.out.print(root.value + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */

   /**
    * A method that traverses the tree in order
    * @param root node of tree 
    */
   public void inOrderTraversal(Node root){
      //implement me
      if(root == null){
         return;
      }

      inOrderTraversal(root.left);
      System.out.print(root.value + " ");
      inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */

   /**
    * A method that traverses the tree in pre order
    * @param root node of tree
    */
   public void postOrderTraversal(Node root){
      //implement me

      if(root == null){
         return;
      }

      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + " ");
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */

   /**
    * A method to find a certain key in a tree
    * @param root node of tree
    * @param key to find
    * @return true if the key is found; false if the key is not found
    */
   public boolean find(Node root, int key){
	  //implement me
      if(root == null){
         return false;
      }

      if(root.value == key){
         return true;
      }

      if(root.value > key){
         return find(root.left, key);
      } else {
         return find(root.right, key);
      }
         
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */

   /**
    * Method that finds the smallest node in the tree
    * @param root node of tree
    * @return the smallest element of the tree
    */
   public int getMin(Node root){
      //implement me
      if(root.left == null){
         return root.value;
      }
      return getMax(root.left);
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}