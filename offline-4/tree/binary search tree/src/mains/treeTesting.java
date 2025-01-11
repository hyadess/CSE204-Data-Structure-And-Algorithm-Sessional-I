package mains;

import bst.binarySearchTree;

import java.io.*;

public class treeTesting {




    public static void main(String args[]) throws IOException {
        binarySearchTree<Integer> bst=new binarySearchTree<>();

//        System.out.println(bst.find(1));
//
//
//        bst.insert(8);
//        bst.insert(10);
//        bst.insert(3);
//        bst.insert(1);
//        bst.insert(14);
//        bst.insert(6);
//        bst.insert(4);
//        bst.insert(13);
//        bst.insert(7);
//
//
//        bst.print();
//
//        bst.inOrderTraverse();
//        bst.preOrderTraverse();
//        bst.postOrderTraverse();
//
//        bst.delete(8);
//        bst.print();
//        bst.delete(7);
//        bst.print();
//        bst.delete(10);
//        bst.print();
//        bst.delete(10);
//        bst.print();
//        System.out.println(bst.find(4));


        Reader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String s = br.readLine();
            if (s == null) break;


            if (s.charAt(0)=='F')
            {
                if(bst.find(Integer.parseInt(s.substring(2,s.length())))==true)
                    System.out.println("True");
                else
                    System.out.println("False");

            }
            else if(s.charAt(0)=='I')
            {
                bst.insert(Integer.parseInt(s.substring(2,s.length())));
                bst.print();
            }
            else if(s.charAt(0)=='D')
            {
                Integer x=Integer.parseInt(s.substring(2,s.length()));

                if(!bst.find(x))   // element is not found....
                    System.out.println("Invalid operation");
                else
                {
                    bst.delete(x);
                    bst.print();
                }

            }
            else if(s.charAt(0)=='T')
            {
                if(s.substring(2,s.length()).equals("In"))
                    bst.inOrderTraverse();
                if(s.substring(2,s.length()).equals("Pre"))
                    bst.preOrderTraverse();
                if(s.substring(2,s.length()).equals("Post"))
                    bst.postOrderTraverse();
            }

            else
            {
                System.out.println("invalid command");
            }

           // System.out.println(s);
        }
        br.close();
        fr.close();

    }





}
