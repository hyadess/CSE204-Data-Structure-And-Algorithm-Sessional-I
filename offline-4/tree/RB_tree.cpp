#include<bits/stdc++.h>
using namespace std;


int n;
int a,b;
template<typename T>
int compareKey(T firstkey, T secondkey)
{
    if(firstkey<secondkey)
        return -1;
    else if(firstkey>secondkey)
        return 1;
    else
        return 0;

}

template<typename T>
class node{

    node<T>* parent;
    node<T>* left;
    node<T>* right;
    string color;  /// black,red
    int siz;
    T key;

public:

    node<T>(T key=NULL){
        this->key=key;
        parent=NULL;
        left=NULL;
        right=NULL;
        color="black";  /// initially black......
        if(key==NULL)
            siz=0;
        else
            siz=1;
    }

    node<T>* getParent()
    {
        return parent;
    }
    node<T>* getLeft()
    {
        return left;
    }
    node<T>* getRight()
    {
        return right;
    }
    string getColor()
    {
        return color;
    }

    T getKey(){
        return key;
    }

    void setParent(node<T>* parent)
    {
        this->parent=parent;
    }
    void setLeft(node<T>* left)
    {
        this->left=left;
    }
    void setRight(node<T>* right)
    {
        this->right=right;
    }
    void setColor(string s)
    {
        this->color=s;
    }

    void setKey(T key)
    {
        this->key=key;
    }

    int getSiz(){
        return siz;
    }

    void setSiz(int siz)
    {
        this->siz=siz;
    }






};


template <typename T>
class RBTree{

    node<T>* root;
    node<T>* blank;



    node<T>* successor(node<T>* root) /// smallest node in the right subtree
    {
        if(root->getRight()==blank)
        {
            return NULL;
        }

        node<T>* right=root->getRight();

        while(1)
        {
            if(right->getLeft()!=blank)
                right=right->getLeft();
            else
                break;
        }
        return right;
    }

    node<T>* predecessor(node<T>* root) /// largest node in the left subtree
    {
        if(root->getLeft()==blank)
        {
            return NULL;
        }

        node<T>* left=root->getLeft();

        while(1)
        {
            if(left->getRight()!=blank)
                left=left->getRight();
            else
                break;
        }
        return left;
    }


    void left_rotate(node<T>* p)
    {
        /// lets change the size;

        node<T>* x=p;
        node<T>* y=p->getRight();
        node<T>* a=y->getLeft();
        node<T>* b=y->getRight();
        node<T>* c=p->getLeft();

        x->setSiz(x->getSiz()-y->getSiz()+a->getSiz());
        y->setSiz(y->getSiz()-a->getSiz()+x->getSiz());


        node<T>* right=p->getRight();
        p->setRight(right->getLeft());

        if(right->getLeft()!=blank)
            right->getLeft()->setParent(p);

        right->setParent(p->getParent());

        if(p->getParent()==blank)
            root=right;
        else if(p==p->getParent()->getLeft())
        {
            p->getParent()->setLeft(right);
        }
        else{
            p->getParent()->setRight(right);
        }
        right->setLeft(p);
        p->setParent(right);




    }

    void right_rotate(node<T>* p)
    {
        /// lets change the size;

        node<T>* y=p;
        node<T>* b=p->getRight();
        node<T>* x=p->getLeft();
        node<T>* c=x->getLeft();
        node<T>* a=x->getRight();

        y->setSiz(y->getSiz()+a->getSiz()-x->getSiz());
        x->setSiz(x->getSiz()+y->getSiz()-a->getSiz());


        node<T>* left=p->getLeft();
        p->setLeft(left->getRight());
        if(left->getRight()!=blank)
            left->getRight()->setParent(p);

        left->setParent(p->getParent());

        if(p->getParent()==blank)
            root=left;
        else if(p==p->getParent()->getRight())
        {
            p->getParent()->setRight(left);
        }
        else{
            p->getParent()->setLeft(left);
        }
        left->setRight(p);
        p->setParent(left);


    }

    node<T>* lookup(T key)
    {
        node<T>* cur=root;
        while(cur!=blank)
        {
            if(compareKey(key,cur->getKey())==-1)
                cur=cur->getLeft();
            else if(compareKey(key,cur->getKey())==1)
                cur=cur->getRight();
            else
                break;

        }
        return cur;
    }

    void insert_fix(node<T>* p)
    {
        node<T>* currNode=p;
        while(currNode->getParent()->getColor()=="red")
        {

            if(currNode->getParent()==currNode->getParent()->getParent()->getLeft())
            {
                node<T>* uncle=currNode->getParent()->getParent()->getRight();
                if(uncle->getColor()=="red")
                {
                    currNode->getParent()->setColor("black");
                    uncle->setColor("black");
                    currNode->getParent()->getParent()->setColor("red");
                    currNode=currNode->getParent()->getParent();
                }
                else
                {
                    if(currNode==currNode->getParent()->getRight())
                    {
                        currNode=currNode->getParent();
                        left_rotate(currNode);
                    }
                    currNode->getParent()->setColor("black");
                    currNode->getParent()->getParent()->setColor("red");
                    right_rotate(currNode->getParent()->getParent());
                }

            }
            else
            {
                node<T>* uncle=currNode->getParent()->getParent()->getLeft();
                if(uncle->getColor()=="red")
                {
                    currNode->getParent()->setColor("black");
                    uncle->setColor("black");
                    currNode->getParent()->getParent()->setColor("red");
                    currNode=currNode->getParent()->getParent();
                }
                else
                {
                    if(currNode==currNode->getParent()->getLeft())
                    {
                        currNode=currNode->getParent();
                        right_rotate(currNode);
                    }
                    currNode->getParent()->setColor("black");
                    currNode->getParent()->getParent()->setColor("red");
                    left_rotate(currNode->getParent()->getParent());
                }

            }
        }
        root->setColor("black");
    }

    void transplant(node<T>* a, node<T>* b)
    {
        if(a->getParent()==this->blank)
            root=b;
        else if(a==a->getParent()->getLeft())
            a->getParent()->setLeft(b);
        else
            a->getParent()->setRight(b);
        b->setParent(a->getParent());
    }

    void delete_fix(node<T>* p)
    {
        node<T>* currNode=p;


        while(currNode!=this->root && currNode->getColor()=="black")
        {

            if(currNode==currNode->getParent()->getLeft())
            {

                node<T>* sibling=currNode->getParent()->getRight();
                if(sibling->getColor()=="red")
                {

                    sibling->setColor("black");
                    currNode->getParent()->setColor("red");

                    left_rotate(currNode->getParent());

                    sibling=currNode->getParent()->getRight();

                }
                if(sibling->getLeft()->getColor()=="black" && sibling->getRight()->getColor()=="black")
                {

                    sibling->setColor("red");
                    currNode=currNode->getParent();
                }
                else{

                    if(sibling->getRight()->getColor()=="black")
                    {
                        sibling->getLeft()->setColor("black");
                        sibling->setColor("red");
                        right_rotate(sibling);
                        sibling=currNode->getParent()->getRight();

                    }
                    sibling->setColor(currNode->getParent()->getColor());
                    currNode->getParent()->setColor("black");
                    sibling->getRight()->setColor("black");
                    left_rotate(currNode->getParent());
                    currNode=this->root;
                }
            }
            else
            {
                node<T>* sibling=currNode->getParent()->getLeft();
                if(sibling->getColor()=="red")
                {

                    sibling->setColor("black");
                    currNode->getParent()->setColor("red");
                    right_rotate(currNode->getParent());
                    sibling=currNode->getParent()->getLeft();

                }
                if(sibling->getLeft()->getColor()=="black" &&
                   sibling->getRight()->getColor()=="black")
                {


                    sibling->setColor("red");
                    currNode=currNode->getParent();
                }
                else{



                    if(sibling->getLeft()->getColor()=="black")
                    {
                        sibling->getRight()->setColor("black");
                        sibling->setColor("red");
                        left_rotate(sibling);
                        sibling=currNode->getParent()->getLeft();

                    }


                    sibling->setColor(currNode->getParent()->getColor());
                    currNode->getParent()->setColor("black");
                    sibling->getLeft()->setColor("black");

                    right_rotate(currNode->getParent());


                    currNode=this->root;

                }


            }


        }


        currNode->setColor("black");
    }

public:
    RBTree()
    {
        blank=new node<T>();
        root=blank;
    }

    bool insert(T key)
    {
        node<T>* e=lookup(key);
        if(e!=blank)
            return false;
        node<T>* newNode=new node<T>(key);
        node<T>* parent=this->blank;
        node<T>* cur=root;
        while(cur!=this->blank)
        {
            parent=cur;
            parent->setSiz(parent->getSiz()+1);
            if(compareKey(newNode->getKey(),cur->getKey())==-1)
                cur=cur->getLeft();
            else
                cur=cur->getRight();
        }

        newNode->setParent(parent);

        if(parent==blank)
            root=newNode;
        else if(compareKey(newNode->getKey(),parent->getKey())==-1)
            parent->setLeft(newNode);
        else
            parent->setRight(newNode);



        newNode->setLeft(blank);
        newNode->setRight(blank);
        newNode->setColor("red");

        insert_fix(newNode);

        return true;

    }

    bool remove(T key)
    {
        node<T>* targetNode=lookup(key);
        node<T>* fixupNode;
        if(targetNode==blank)
        {
            return false;
        }



        node<T>* b=targetNode;
        string old_color=b->getColor();
        if(targetNode->getLeft()==this->blank)
        {
            fixupNode=targetNode->getRight();
            transplant(targetNode,fixupNode);
        }
        else if(targetNode->getRight()==this->blank)
        {
            fixupNode=targetNode->getLeft();
            transplant(targetNode,fixupNode);
        }
        else
        {
            b=successor(targetNode);
            old_color=b->getColor();
            fixupNode=b->getRight();
            if(b->getParent()==targetNode)
            {
                fixupNode->setParent(b);
            }
            else{
                transplant(b,b->getRight());
                b->setRight(targetNode->getRight());
                b->getRight()->setParent(b);
            }
            transplant(targetNode,b);
            b->setLeft(targetNode->getLeft());
            b->getLeft()->setParent(b);
            b->setColor(targetNode->getColor());

            /// change the size
            b->setSiz(targetNode->getSiz());

        }

        /// change the size
        node<T>* r=fixupNode->getParent();
        while(r!=this->blank)
        {
            r->setSiz(r->getSiz()-1);
            r=r->getParent();
        }

        if(old_color=="black")
           delete_fix(fixupNode);



        return true;
    }

    bool found(T key)
    {
        node<T>* e=lookup(key);
        if(e==blank)
            return false;
        else
            return true;
    }

    int smallerKey(T key)
    {
        node<T>* cur=root;
        int ans=0;
        while(cur!=this->blank)
        {
            if(compareKey(cur->getKey(),key)==-1){
                ans+=cur->getSiz()-cur->getRight()->getSiz();
                cur=cur->getRight();
            }
            else if(compareKey(cur->getKey(),key)==1)
            {
                cur=cur->getLeft();
            }
            else{
                ans+=cur->getLeft()->getSiz();
                break;
            }
        }
        return ans;

    }

};


int main()
{
    ifstream input("in.txt");
    ofstream output("out.txt");

    RBTree<int> rb;


    input>>n;
    output<<n<<endl;
    while(n--)
    {

        input>>a>>b;
        output<<a<<" "<<b<<" ";
        if(a==1)
        {
            output<<rb.insert(b)<<endl;
        }
        else if(a==2)
            output<<rb.found(b)<<endl;

        else if(a==0)
        {
            output<<rb.remove(b)<<endl;
        }
        else
            output<<rb.smallerKey(b)<<endl;

    }

}






















