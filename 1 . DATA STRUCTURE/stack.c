//stack implimentation using linkedlist
#include<stdio.h>
#include<stdlib.h>

struct node
{
        int data;
        struct node * next;
};

struct node * top=NULL;


void display()
{
        if(top==NULL)
        {
                printf("Stack empty!\n");
        }
        else
        {
        struct node * temp;
        printf("Stack -> ");
        temp=top;
        while(temp!=NULL)
        {
                printf(" %d ",temp->data);
                temp=temp->next;
        }
        }
        
}


void push()
{
        struct node * newnode;
        int item;
        newnode=(struct node *)malloc(sizeof(struct node));
        printf("Enter the item :");
        scanf("%d",&item);
        newnode->data=item;
        newnode->next=top;
        top=newnode;
        display();
}



void pop()
{
        struct node * temp;
        if(top==NULL)
        {
                printf("Stack empty!\n");
        }
        else
        {
                printf("%d Popped!\n",top->data);
                temp=top;
                top=top->next;
                free(temp);
        }
}


void search()
{
        struct node * temp;
        int item;
        int flag=0;
        printf("Enter the item :");
        scanf("%d",&item);
        temp=top;
        while(temp!=NULL)
        {
                if(temp->data==item)
                {
                        printf("Item found.\n");
                        flag=1;
                }
                temp=temp->next;
        }
        if(!flag)
        {
                printf("Item not found!\n");
        }
}

void peek(){
    if(top==NULL){
        printf("stack is empty");
        
    }
    else{
        printf("%d",top->data);
    }
}

int main()
{
        int choice;
        while(1)
        {
                printf("\n1. Push\n2. Pop\n3. Search\n4. Display\n5. peek\n6. Exit\nEnter your choice:");
                scanf("%d",&choice);
                switch(choice)
                {
                        case(1):
                                push();
                                break;
                        case(2):
                                pop();
                                break;
                        case(3):
                                search();
                                break;
                        case(4):
                                display();
                                break;
                        case(5):
                                peek();
                                break;
                        case(6):
                                exit(0);
                        default:
                                printf("Invalid choice!\n");
                }
        }
        return 0;
}
